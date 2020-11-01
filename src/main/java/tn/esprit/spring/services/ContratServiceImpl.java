package tn.esprit.spring.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {

	private static final Logger l = Logger.getLogger(ContratServiceImpl.class);
	@Autowired
	ContratRepository contratRepository;


	public List<Contrat> getAllContrats() {
		List<Contrat> list = (List<Contrat>) contratRepository.listContrats();
		return list;
	}


	@Override
	public List<Contrat> getContratsByType(String type) {
		return contratRepository.getContratByType(type);
	}


	@Override
	public List<Contrat> getContratSortByDate() {
		return contratRepository.listContratByDate();
	}


	@Override
	public int countContrats() {
		return contratRepository.countContrat();
		}


	@Override
	public Double sommeDesSalairesByType(String type) {
		return contratRepository.sommeDesSalairesParTypedeContrat(type);
	}


	@Override
	public void deleteAllContrats() {
		contratRepository.deleteAll();
		
	}


	@Override
	public void deleteContratById(int reference) {
		contratRepository.deleteById(reference);
	}


	@Override
	public void deleteContratByEmployeId(int employe_id) {
		contratRepository.deleteContratByEmployeId(employe_id);
		
	}


	@Override
	public Contrat getContratByEmployeId(int employe_id) {
		return contratRepository.getContratByEmployeId(employe_id);
	}


	@Override
	public Contrat getContratById(int reference) {
		return contratRepository.getContratByReference(reference);
	}


	@Override
	public int addOrUpdate(Contrat contrat) {
		contratRepository.save(contrat);
		return contrat.getReference();
	}

}
