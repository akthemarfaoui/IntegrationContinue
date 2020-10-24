package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;

@Repository
public interface ContratRepository extends CrudRepository<Contrat, Integer>{

	@Query("SELECT count(*) FROM Contrat")
    public int countContrat();
	
	@Query("SELECT c FROM Contrat as c")
    public List<Contrat> listContrats();
	
	@Query("SELECT c FROM Contrat as c WHERE reference=:reference")
	public Contrat getContratByReference(@Param("reference")int reference);
	
	@Query("SELECT c FROM Contrat as c where employe_id=:id")
	public Contrat getContratByEmployeId(@Param("id")int employe_id);
	
	@Modifying
    @Transactional
    @Query("DELETE from Contrat")
    public void deleteAllContrat();
	
	@Modifying
    @Transactional
    @Query("DELETE from Contrat where reference =:reference")
    public void deleteContratById(@Param("reference")int reference);
	
	@Modifying
    @Transactional
    @Query("DELETE from Contrat where employe_id =:id")
    public void deleteContratByEmployeId(@Param("id")int
    		employe_id);
	
	@Query("SELECT c FROM Contrat as c where type_contrat=:type")
	public List<Contrat> getContratByType(@Param("type")String contrat_type);
	
	@Query("SELECT c FROM Contrat as c ORDER BY date_debut DESC")
	public List<Contrat> listContratByDate();
	
	@Query("SELECT SUM(salaire) FROM Contrat WHERE type_contrat=:type")
	public Double sommeDesSalairesParTypedeContrat(@Param("type")String contrat_type);
} 
