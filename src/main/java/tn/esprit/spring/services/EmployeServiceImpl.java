package tn.esprit.spring.services;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	private static final Logger l = Logger.getLogger(EmployeServiceImpl.class);

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;

	@Override
	public Employe authenticate(String login, String password) {
		l.info("fetching from database for emp: "+ login);
		return employeRepository.getEmployeByEmailAndPassword(login, password);
	}

	@Override
	public int addOrUpdateEmploye(Employe employe) {
		
		l.info("In addOrUpdateEmploye method");

		employeRepository.save(employe);
		l.info("Out addOrUpdateEmploye method");

		return employe.getId();
	}


	public void mettreAjourEmailByEmployeId(String email, int employeId) {

		Optional<Employe> employe = employeRepository.findById(employeId);
		if(employe.isPresent())
		{
			employe.get().setEmail(email);
			employeRepository.save(employe.get());
		}else {
			
			l.error("Employe with id "+employeId+" is not found");
			throw new NoSuchElementException();

		}


	}

	@Transactional	
	public void affecterEmployeADepartement(int employeId, int depId) {
	
		l.info("In affecterEmployeADepartement method");

		Optional<Employe> employeManagedEntity = employeRepository.findById(employeId);
		Optional<Departement> depManagedEntity = deptRepoistory.findById(depId);

		if(depManagedEntity.isPresent())
		{

			l.info("departement found In affecterEmployeADepartement method");

			if(employeManagedEntity.isPresent())
			{
				l.info("employe found In affecterEmployeADepartement method");
				
				if(depManagedEntity.get().getEmployes() == null){

					List<Employe> employes = new ArrayList<>();
					employes.add(employeManagedEntity.get());
					depManagedEntity.get().setEmployes(employes);
				}else{

					depManagedEntity.get().getEmployes().add(employeManagedEntity.get());
				}
				
				l.info("departement is saving...");

				deptRepoistory.save(depManagedEntity.get()); 
				
				l.info("departement is saved");

			}else{
			
				l.error("employe id not found");
				throw new NoSuchElementException();

			}
			
		}else{
			
			l.error("departement id not found");
			throw new NoSuchElementException();
		}
		

		l.info("Out affecterEmployeADepartement method");

	}
	
	@Transactional
	public void desaffecterEmployeDuDepartement(int employeId, int depId)
	{
		l.info("In desaffecterEmployeDuDepartement method");

		Optional<Departement> dep =deptRepoistory.findById(depId);

		if(dep.isPresent())
		{
			int employeNb = dep.get().getEmployes().size();
			for(int index = 0; index < employeNb; index++){
				if(dep.get().getEmployes().get(index).getId() == employeId){
					dep.get().getEmployes().remove(index);
					break;//a revoir
				}
			}
		}else{
			
			l.error("Departement not found in desaffecterEmployeDuDepartement");
			throw new NoSuchElementException();
		}
		

		l.info("Out desaffecterEmployeDuDepartement method");

	} 
	
	// Tablesapce (espace disque) 

	public int ajouterContrat(Contrat contrat) {
		l.info("In ajouterContrat method");

		contratRepoistory.save(contrat);
		
		l.info("Out ajouterContrat method");

		return contrat.getReference();
	}

	public void affecterContratAEmploye(int contratId, int employeId) {
		
		l.info("In affecterContratAEmploye method");

		Optional<Contrat> contratManagedEntity =contratRepoistory.findById(contratId);
		Optional<Employe> employeManagedEntity =employeRepository.findById(employeId);

		if(contratManagedEntity.isPresent())
		{
			if(employeManagedEntity.isPresent())
			{
				contratManagedEntity.get().setEmploye(employeManagedEntity.get());
				contratRepoistory.save(contratManagedEntity.get());
			}else{
				
				l.error("Employe not found in affecterContratAEmploye");
				throw new NoSuchElementException();
				
			}
		}else{

			l.error("contrat not found in affecterContratAEmploye");
			throw new NoSuchElementException();
		
		}
		
		l.info("Out affecterContratAEmploye method");

	}

	public String getEmployePrenomById(int employeId) {

		l.info("In getEmployePrenomById method");

		Optional<Employe> employeManagedEntity =employeRepository.findById(employeId);
		
		if(employeManagedEntity.isPresent())
		{

			return employeManagedEntity.get().getPrenom();
			
		}else{
			l.error("Employe not found in getEmployePrenomById method");

			return "";	
		}
	}
	 
	public void deleteEmployeById(int employeId)
	{
		
		l.info("In deleteEmployeById method");

		Optional<Employe> employe = employeRepository.findById(employeId);

		if(employe.isPresent()){
			
			for(Departement dep : employe.get().getDepartements()){
				dep.getEmployes().remove(employe.get());
			}
		
			employeRepository.delete(employe.get());
		}else{

			l.error("Employe with id "+employeId+" is not found in method deleteEmployeById");
			throw new NoSuchElementException();
			
		}
		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association

		l.info("Out deleteEmployeById method");

	}

	public void deleteContratById(int contratId) {
		l.info("In deleteContratById method");
		
		Optional<Contrat> contratManagedEntity = contratRepoistory.findById(contratId);
		if(contratManagedEntity.isPresent())
		{
		
			contratRepoistory.delete(contratManagedEntity.get());		
		
		}else{
			
			l.error("contrat is not found");
			throw new NoSuchElementException();
			
		}

		l.info("Out deleteContratById method");
		
	}

	public int getNombreEmployeJPQL() {
		return employeRepository.countemp();
	}

	public List<String> getAllEmployeNamesJPQL() {
		return employeRepository.employeNames();

	}

	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
		return employeRepository.getAllEmployeByEntreprisec(entreprise);
	}

	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		employeRepository.mettreAjourEmailByEmployeIdJPQL(email, employeId);

	}
	public void deleteAllContratJPQL() {
		employeRepository.deleteAllContratJPQL();
	}

	public float getSalaireByEmployeIdJPQL(int employeId) {
		return employeRepository.getSalaireByEmployeIdJPQL(employeId);
	}

	public Double getSalaireMoyenByDepartementId(int departementId) {
		return employeRepository.getSalaireMoyenByDepartementId(departementId);
	}

	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		return timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	}

	public List<Employe> getAllEmployes() {
		l.info("In getAllEmployes method");
		
		return (List<Employe>) employeRepository.findAll();
	}

}
