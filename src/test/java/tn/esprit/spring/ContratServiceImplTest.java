package tn.esprit.spring;

import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {
	
	
	/* ******************** JUNIT TEST CLASS OUTAIL OUNI ***************************  */

	@Autowired 
	IContratService cs; 

	@Test
	public void testRetrieveAllContrat() {
		List<Contrat> listDepartment = cs.getAllContrats();
		
		// if there are 0 contracts in DB : 
		assertEquals(0, listDepartment.size());
	}

	

}

