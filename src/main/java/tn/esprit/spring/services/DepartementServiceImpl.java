package tn.esprit.spring.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Log4j.AffichageLog;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {
	private static final Logger l = Logger.getLogger(AffichageLog.class);



	@Autowired
	DepartementRepository deptRepoistory;


	public List<Departement> getAllDepartements() {
		l.info("On Va afficher la liste des departements  ");
		l.debug(" Debug retour liste departements  ");
		return (List<Departement>) deptRepoistory.findAll();
	}

}
