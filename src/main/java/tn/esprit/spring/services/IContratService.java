package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;


public interface IContratService {
	
	
	public List<Contrat> getAllContrats();
	public List<Contrat> getContratsByType(String type);
	public List<Contrat> getContratSortByDate();
	public int countContrats();
	public Double sommeDesSalairesByType(String type);
	public void deleteAllContrats();
	public void deleteContratById(int reference);
	public void deleteContratByEmployeId(int employe_id);
	public Contrat getContratByEmployeId(int employe_id);
	public Contrat getContratById(int reference);
	
	int addOrUpdate(Contrat contrat);


	
	
	

	
}
