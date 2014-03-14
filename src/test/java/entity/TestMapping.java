package entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import entity.schema1.Contrat;
import entity.schema2.Prestation;

@ContextConfiguration(locations="classpath:entity/spring.xml")
public class TestMapping extends AbstractTransactionalTestNGSpringContextTests{
	@Autowired
	private SessionFactory sessionFactory;
	
	@BeforeMethod
	public void beforeMethod(){
		executeSqlScript("entity/script.sql", false);
	}
	
	@Test
	public void testFindContrat(){
		Contrat contrat = (Contrat) getSession().get(Contrat.class,1);
		
		assertNotNull(contrat);
		assertEquals(contrat.getNumContrat(), "1");
		assertEquals(contrat.getTravailleur().getNom(),"toto");
		assertEquals(contrat.getEmployeur().getNom(),"Test1");
	}
	
	@Test
	public void testFindPrestation(){
		Prestation prestation = (Prestation) getSession().get(Prestation.class,1);
		
		assertNotNull(prestation);
		assertEquals(prestation.getNumContrat(),"1");
		assertEquals(prestation.getPrestataire().getName(),"toto");
		assertEquals(prestation.getPrestataire().getDossier().getNumDossier(),"a01");
	}
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
