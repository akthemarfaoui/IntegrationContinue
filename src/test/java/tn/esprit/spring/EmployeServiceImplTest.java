package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {
	
	@Autowired 
	IEmployeService es;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testAuthenticate() {
		
		String username_innexistant = "qq";
		String password = "";
		
		Employe e = es.authenticate(username_innexistant, password);
		assertEquals(e, null); // Vrai 

	}
	
	@Test
	public void testAddOrUpdateEmploye()
	{
		
		int newId = es.addOrUpdateEmploye(new Employe());
		
		assertNotEquals(newId, 0);
		
	}
	
	
	@Test
	public void testAffecterEmployeADepartement() 
	{
		
		try
		{

			es.affecterEmployeADepartement(0, 0);

		}catch(NoSuchElementException e)
		{
			fail("testAffecterEmployeADepartement: emp or dept not found");
		}
		
	}
	
	
	
	@Test
	public void testMettreAjourEmailByEmployeId()
	{
	
		try
		{

			es.mettreAjourEmailByEmployeId("qqs dqs", 58);	

		}catch(NoSuchElementException e)
		{
			fail("testMettreAjourEmailByEmployeId: emp not found");
		}
	}
	

	@Test
	public void testDesaffecterEmployeDuDepartement()
	{
		
		try
		{

			es.desaffecterEmployeDuDepartement(42, 48);

		}catch(NoSuchElementException e)
		{
			fail("testDesaffecterEmployeDuDepartement: emp or dept found");
		}
	}
	
	
	@Test
	public void testAjouterContrat() {
		
		int reference = es.ajouterContrat(new Contrat());
		assertEquals(reference, 1);  // Faux

	}
	

	@Test
	public void testAffecterContratAEmploye()
	{
		
		try
		{

			es.affecterContratAEmploye(47,6);

		}catch(NoSuchElementException e)
		{
			fail("testAffecterContratAEmploye: emp or dept found");
		}

	}
	
	@Test
	public void testDeleteEmployeById()
	{
		
		try
		{

			es.deleteEmployeById(88);

		}catch(NoSuchElementException e)
		{
			fail("testDeleteEmployeById: emp found");
		}
		
	}
	
	@Test
	public void testDeleteContratById()
	{
		try
		{

			es.deleteContratById(38);

		}catch(NoSuchElementException e)
		{
			fail("testDeleteEmployeById: emp found");
		}
	}
	
	@Test
	public void testGetEmployePrenomById()
	{
		assertNotEquals( "", es.getEmployePrenomById(98));
	}
	
	
}
