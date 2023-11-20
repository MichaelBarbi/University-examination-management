package javasource.resourceobjects;

import java.io.Serializable;

/**
 * La classe Date definisce la rappresentazione di una data
 * 
 * @author Barbi Michael 
 */

public class Date implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Giorno dell'anno
	 */
	private Integer giorno;
	
	/**
	 * Mese dell'anno
	 */
	private Integer mese;
	
	/**
	 * Anno
	 */
	private Integer anno;


	/**
	 * Costruttore
	 */
	public Date() {
		super();
		this.setGiorno(null);
		this.setMese(null);
		this.setAnno(null);
	}

	/**
	 * Costruttore
	 * 
	 * @param giorno Integer
	 * @param mese Integer
	 * @param anno Integer
	 */
	public Date(Integer giorno, Integer mese, Integer anno) {
		super();
		this.setGiorno(giorno);
		this.setMese(mese);
		this.setAnno(anno);
	}

	/**
	 * Restituisce il campo giorno
	 *
	 * @return giorno Integer
	 */
	public Integer getGiorno() {
		return giorno;
	}

	/**
	 * Imposta il valore del campo giorno
	 *
	 * @param giorno Integer
	 */
	public void setGiorno(Integer giorno) {
		this.giorno = giorno;
	}

	/**
	 * Restituisce il campo mese
	 *
	 * @return mese Integer
	 */
	public Integer getMese() {
		return mese;
	}

	/**
	 * Imposta il valore del campo mese
	 *
	 * @param mese Integer
	 */
	public void setMese(Integer mese) {
		this.mese = mese;
	}

	/**
	 * Restituisce il campo anno
	 *
	 * @return anno Integer
	 */
	public Integer getAnno() {
		return anno;
	}

	/**
	 * Imposta il valore del campo anno
	 *
	 * @param anno Integer
	 */
	public void setAnno(Integer anno) {
		this.anno = anno;
	}
	
	/**
	 * Ritorna la data nel formato "dd/mm/aa" in stringa
	 * 
	 * @return String
	 */
	public String getStringDate() {
		return this.giorno + "/" + this.mese + "/" + this.anno;
	}
}
