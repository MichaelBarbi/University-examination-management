package javasource.resourceobjects;

import java.io.Serializable;
import java.util.List;

/**
 * La classe Untente rappresenta un untente registrabile sulla piattaforma
 * 
 * @author Barbi Michael
 */

public abstract class Utente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

	/**
	 * Nome
	 */
	private String nome;
	
	/**
	 * Cognome
	 */
	private String cognome;
	
	/**
	 * Data di nascita
	 */
	private Date dataNascita;
	
	/**
	 * Nome Utente per il login, diverso dal codice di matricola
	 */
	private String username;
	
	/**
	 * Email
	 */
	private String email;
	
	/**
	 * password
	 */
	private String password;
	
	
	/**
	 * Costruttore
	 */
	public Utente() {
		super();
		this.setNome(null);
		this.setCognome(null);
		this.setDataNascita(null);
		this.setUsername(null);
		this.setEmail(null);
		this.setPassword(null);
	}

	/**
	 * Costruttore con parametri
	 * 
	 * @param nome String
	 * @param cognome String
	 * @param dataNascita Date
	 * @param username String
	 * @param email String
	 * @param password String
	 */
	public Utente(String nome, String cognome, Date dataNascita, String username, String email, String password) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.setDataNascita(dataNascita);
		this.setUsername(username);
		this.setEmail(email);
		this.setPassword(password);
	}

	/**
	 * Restituisce il campo nome
	 *
	 * @return nome String
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Imposta il valore del campo nome
	 *
	 * @param nome String
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce il campo cognome
	 *
	 * @return cognome String
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * Imposta il valore del campo cognome
	 *
	 * @param cognome String
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Restituisce il campo dataNascita
	 *
	 * @return dataNascita Date
	 */
	public Date getDataNascita() {
		return dataNascita;
	}

	/**
	 * Imposta il valore del campo dataNascita
	 *
	 * @param dataNascita Date
	 */
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	/**
	 * Restituisce il campo username
	 *
	 * @return username String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Imposta il valore del campo username
	 *
	 * @param username String
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Restituisce il campo email
	 *
	 * @return email String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Imposta il valore del campo email
	 *
	 * @param email String
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Restituisce il campo password
	 *
	 * @return password String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Imposta il valore del campo password
	 *
	 * @param password String
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Restituisce una lista di utenti appartententi ad una delle classi figlie
	 * 
	 * @param utenti {@link List}{@link Utente}
	 * @return {@link List}{@link Utente}
	 */
	public abstract List<Utente> getUtentiDelloStessoTipo(List<Utente> utenti);
	
}
