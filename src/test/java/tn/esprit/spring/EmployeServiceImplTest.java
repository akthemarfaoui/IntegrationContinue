package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {
	
	@Autowired 
	IEmployeService es;
	
	@Test
	public void testAuthenticate() {
		
		String username_innexistant = "qq";
		String password = "";
		
		Employe e = es.authenticate(username_innexistant, password);
		assertEquals(e, null); // Vrai 

	}
	
	@Test
	public void testAjouterContrat() {
		
		int reference = es.ajouterContrat(new Contrat());
		assertEquals(reference, 1);  // Faux

	}


	
}
