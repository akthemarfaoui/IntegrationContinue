package tn.esprit.Log4j;

import java.util.List;

import org.apache.log4j.Logger;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.ContratServiceImpl;

public class AffichageLog {

	private static final Logger l = Logger.getLogger(AffichageLog.class);
	ContratServiceImpl cs = new ContratServiceImpl();
	public static void main(String[] args) {
		AffichageLog al = new AffichageLog();
		al.getAllPrducts();
	}
 
	public void getAllPrducts() {
//		List<Contrat> list = cs.getAllContrats();
		try {
			
			// DEBUG / INFO / WARN / ERROR  
			
			l.info("In getAllPrducts() : ");
			
			l.debug("Je vais  lancer la divsion.");
			int i = 0; //1/0; 
			// ....
			l.debug("Je viens de lancer la divsion. " + i);
			l.debug("Je viens de finir l'op�ration X."); 

			l.info("Out getAllPrducts() without errors." ); // after retruning 
		} catch (Exception e) {
			l.error("Erreur dans getAllPrducts() : " + e); // after throwing 
		} finally {
			// dans tous les cas
			l.info("M�thode getAllPrducts() finie  ");
		}
	}
}
