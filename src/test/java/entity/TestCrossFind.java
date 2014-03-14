package entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import entity.schema2.Prestation;

@ContextConfiguration(locations="classpath:entity/spring.xml")
public class TestCrossFind extends AbstractTransactionalTestNGSpringContextTests {
	@Autowired
	private SessionFactory sessionFactory;
	
	@BeforeMethod
	public void beforeMethod(){
		executeSqlScript("entity/script.sql", false);
	}
	
	@Test
	public void testFindPrestationsPourOuvrier(){
		String hql = "select p from Prestation p, Contrat c where "
				+ "p.numContrat=c.numContrat "
				+ "and p.prestataire.numTrav=c.travailleur.numTrav "
				+ "and p.prestataire.dossier.numDossier=c.employeur.numDossier "
				+ "and c.travailleur.category = :cat";
		
		List<Prestation> ps = getSession().createQuery(hql).setParameter("cat", "Ouvrier").list();
		assertEquals(ps.size(), 2);
		for(Prestation p:ps){
			assertEquals(p.getPrestataire().getName(), "toto");
		}
	}
	
	@Test
	public void testFindPrestationsPourEmployé(){
		String hql = "select p from Prestation p, Contrat c where "
				+ "p.numContrat=c.numContrat "
				+ "and p.prestataire.numTrav=c.travailleur.numTrav "
				+ "and p.prestataire.dossier.numDossier=c.employeur.numDossier "
				+ "and c.travailleur.category = :cat";
		
		List<Prestation> ps = getSession().createQuery(hql).setParameter("cat", "Employé").list();
		assertEquals(ps.size(), 2);
	}
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
