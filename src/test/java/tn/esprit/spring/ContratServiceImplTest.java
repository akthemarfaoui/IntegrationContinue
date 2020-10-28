package tn.esprit.spring;

<<<<<<< HEAD


import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
=======
import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.Test;
>>>>>>> c2e5859cb841b24c32b80fa5cca80e71341821a2
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
<<<<<<< HEAD
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IDepartementService;
=======
import tn.esprit.spring.services.IContratService;
>>>>>>> c2e5859cb841b24c32b80fa5cca80e71341821a2

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {
	
	
<<<<<<< HEAD
	/* ******************** JUNIT TEST CLASS AKTHEM ARFAOUI ***************************  */
=======
	/* ******************** JUNIT TEST CLASS OUTAIL OUNI ***************************  */
>>>>>>> c2e5859cb841b24c32b80fa5cca80e71341821a2

	@Autowired 
	IContratService cs; 

	@Test
	public void testRetrieveAllContrat() {
<<<<<<< HEAD
		List<Contrat> listContrat = cs.getAllContrats(); 
		
		// if there are 2 Contrats in DB : 
		assertEquals(2, listContrat.size());
=======
		List<Contrat> listDepartment = cs.getAllContrats();
		
		// if there are 0 contracts in DB : 
		assertEquals(0, listDepartment.size());
>>>>>>> c2e5859cb841b24c32b80fa5cca80e71341821a2
	}

	

}

