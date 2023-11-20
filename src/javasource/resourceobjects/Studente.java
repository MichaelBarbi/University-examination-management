package javasource.resourceobjects;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Studente rappresenta il singolo studente universitario.
 * 
 * @author Barbi Michael
 */

public class Studente extends Utente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double mediaVoto;
	private String codiceMatricola;
	//private List<Esami> esamiSvolti;
	//private List<Esami> esamiPrenotati;
	private String[] esamiDaFare;
	private Integer annoDiCorso;
	private CorsoLaurea corsoLaurea;
	
	
	/**
	 * Dato una lista di utenti, ne restituisce una con solo studenti
	 * 
	 * @param utenti
	 * @return List<Utente>
	 */
	@Override
	public List<Utente> getUtentiDelloStessoTipo(List<Utente> utenti) {
		
		if (utenti != null && utenti.size() > 0) {
			List<Utente> studenti = new ArrayList<Utente>();
			
			for (Utente user : utenti) {
				if (user instanceof Studente) {
					studenti.add(user);
				}
			}
			
			return studenti;
		}
		
		System.out.println("\nLa lista di utenti è vuota");
		
		return null;
	}
	

}
