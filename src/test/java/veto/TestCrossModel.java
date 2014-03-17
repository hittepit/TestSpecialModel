package veto;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import veto.facturation.Facture;
import veto.facturation.Ligne;
import veto.soins.Proprietaire;
import veto.soins.Soin;

@ContextConfiguration(locations="classpath:veto/spring.xml")
public class TestCrossModel extends AbstractTransactionalTestNGSpringContextTests {
	@Autowired
	private SessionFactory sessionFactory;
	
	@BeforeMethod
	public void beforeMethod(){
		executeSqlScript("veto/script.sql", false);
	}
	
	/**
	 * Test la récupération de factures du modèle facturation à partir de l'id d'un propriétaire du modèle soins
	 */
	@Test
	public void testFindFacturesPourPropretaireId(){
		String hql = "select f from Facture f, Proprietaire p where "
				+ "p.clientNum = f.client.clientNum and "
				+ "p.id=:id";
		
		List<Facture> factures = getSession().createQuery(hql).setParameter("id", 1).list();
		assertEquals(factures.size(), 3);
		
		factures = getSession().createQuery(hql).setParameter("id", 2).list();
		assertEquals(factures.size(), 1);
	}
	
	/**
	 * Le problème, c'est qu'il y a deux lignes dans la facture pour Kitty, donc elle apparaît deux fois et donc deux villes
	 */
	@Test
	public void testFindVillesClientFacturePourUnChat(){
		String hql="select distinct(f.client.ville) from Facture f, Soin s where "
				+ "f.client.clientNum=s.animal.proprietaire.clientNum and "
				+ "f.codeAnimal=s.animal.numAnimal and "
				+ "s.animal.espece = :espece";
		
		List<Facture> villes = getSession().createQuery(hql).setParameter("espece", "Chat").list();
		assertEquals(villes.size(),2);
	}
	
	@Test
	public void testFindProprietaireDesAnimauxAyantRecuSoinsCouteux(){
		String hql="select s.animal.proprietaire from Soin s, Ligne l where "
				+ "l.index = s.index and "
				+ "l.facture.codeAnimal = s.animal.numAnimal and "
				+ "l.facture.client.clientNum = s.animal.proprietaire.clientNum and "
				+ "l.prixUnitaire > :maximum";
		
		List<Proprietaire> proprietaires = getSession().createQuery(hql).setParameter("maximum", 14.0).list();
		assertEquals(proprietaires.size(), 1);
		assertEquals(proprietaires.get(0).getNom(),"Toto");
	}
	
	@Test
	public void testFindSoinEtSonNom(){
		String hql = "select s,l from Soin s, Ligne l where "
				+ "l.index = s.index and "
				+ "l.facture.codeAnimal = s.animal.numAnimal and "
				+ "l.facture.client.clientNum = s.animal.proprietaire.clientNum";
		
		List<Object[]> tuples = getSession().createQuery(hql).list();
		assertEquals(tuples.size(), 5);
		for(Object[] tuple:tuples){
			Soin s = (Soin) tuple[0];
			Ligne l = (Ligne) tuple[1];
			assertEquals(s.getIndex(), l.getIndex());
			assertEquals(s.getAnimal().getNumAnimal(), l.getFacture().getCodeAnimal());
		}
	}
	
	@Test
	public void testFindTotalFacturesProprietaireParSonNom(){
		String hql = "select sum(l.prixUnitaire*l.quantite) from Ligne l, Soin s where "
				+ "l.index = s.index and "
				+ "l.facture.codeAnimal = s.animal.numAnimal and "
				+ "l.facture.client.clientNum = s.animal.proprietaire.clientNum and "
				+ "s.animal.proprietaire.nom = :nom";
		
		Double total = (Double) getSession().createQuery(hql).setParameter("nom", "Toto").uniqueResult();
		
		assertEquals(total,35.0);
		
		total =  (Double) getSession().createQuery(hql).setParameter("nom", "Tutu").uniqueResult();
		
		assertEquals(total,22.5);
	}
	
	@Test
	public void testFindTotalParProprietaire(){
		String hql = "select s.animal.proprietaire as proprietaire, sum(l.prixUnitaire*l.quantite) as total from Ligne l, Soin s where "
				+ "l.index = s.index and "
				+ "l.facture.codeAnimal = s.animal.numAnimal and "
				+ "l.facture.client.clientNum = s.animal.proprietaire.clientNum "
				+ "group by s.animal.proprietaire";
		
		List<Object[]> tuples = getSession().createQuery(hql).list();
		assertEquals(tuples.size(), 2);
		
		for(Object[] t:tuples){
			Proprietaire proprietaire = (Proprietaire) t[0];
			Double total = (Double) t[1];
			if(proprietaire.getNom().equals("Toto")){
				assertEquals(total,35.0);
			} else if(proprietaire.getNom().equals("Tutu")){
				assertEquals(total,22.5);
			} else {
				fail("Personne d'autre");
			}
		}
	}
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
