package veto;

import static org.testng.Assert.assertEquals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import veto.facturation.Facture;
import veto.soins.Soin;

@ContextConfiguration(locations="classpath:veto/spring.xml")
public class TestModel extends AbstractTransactionalTestNGSpringContextTests{
	@Autowired
	private SessionFactory sessionFactory;
	
	@BeforeMethod
	public void beforeMethod(){
		executeSqlScript("veto/script.sql", false);
	}
	
	@Test
	public void testFindSoin(){
		Soin soin = (Soin) getSession().get(Soin.class, 100);
		assertEquals(soin.getIndex(), 1);
		assertEquals(soin.getAnimal().getEspece(),"Chien");
		assertEquals(soin.getAnimal().getProprietaire().getClientNum(),"C1");
	}
	
	@Test
	public void testFindFacturePourKitty(){
		Facture facture = (Facture) getSession().get(Facture.class,18);
		assertEquals(facture.getNomAnimal(), "Kitty");
		assertEquals(facture.getClient().getNom(),"Tutu");
		assertEquals(facture.getLignes().size(),2);
	}
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
