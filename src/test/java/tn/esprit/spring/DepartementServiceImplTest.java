package tn.esprit.spring;

import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceImplTest {
	
	
	/* ******************** JUNIT TEST CLASS AKTHEM ARFAOUI ***************************  */

	@Autowired 
	IDepartementService ds; 

	@Test
	public void testRetrieveAllDepartment() {
		List<Departement> listDepartment = ds.getAllDepartements(); 
		
		// if there are 5 users in DB : 
		assertEquals(5, listDepartment.size());
	}

	

}

