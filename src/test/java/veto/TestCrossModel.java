package veto;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import veto.facturation.Facture;

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
	public void findFacturesPourPropretaireId(){
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
	public void findVillesClientFacturePourUnChat(){
		String hql="select distinct(f.client.ville) from Facture f, Soin s where "
				+ "f.client.clientNum=s.animal.proprietaire.clientNum and "
				+ "f.codeAnimal=s.animal.numAnimal and "
				+ "s.animal.espece = :espece";
		
		List<Facture> villes = getSession().createQuery(hql).setParameter("espece", "Chat").list();
		assertEquals(villes.size(),2);
	}
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}