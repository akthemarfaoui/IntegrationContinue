package tn.esprit.spring;



import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IDepartementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {
	
	
	/* ******************** JUNIT TEST CLASS AKTHEM ARFAOUI ***************************  */

	@Autowired 
	IContratService cs; 

	@Test
	public void testRetrieveAllContrat() {
		List<Contrat> listContrat = cs.getAllContrats(); 
		
		// if there are 2 Contrats in DB : 
		assertEquals(2, listContrat.size());
	}

	

}

