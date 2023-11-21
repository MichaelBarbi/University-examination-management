package javasource.resourceobjects;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * La classe TipologiaCorsoEsame descrive la tipologia di un corso di laurea.
 * 
 * @author Barbi Michael
 */

public enum TipologiaCorsoEsame implements Serializable{
	
	/**
	 * Laurea triennale
	 */
	TRIENNALE("triennale"),
	
	/**
	 * Laurea Magistrale
	 */
	MAGISTRALE("magistrale"),
	
	/**
	 * Laurea a ciclo unico
	 */
	CICLO_UNICO("cicloUnico");
	
	private String tipo;
	
	/** 
	 * Costruttore con parametri
	 * 
	 * @param tipo String
	 */
	TipologiaCorsoEsame(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Restituisce il campo tipo
	 * 
	 * @return tipo String
	 */
	public String getTipo() {
		return this.tipo;
	}
	
	/**
	 * Imposta il valore del campo tipo
	 * 
	 * @param tipo String
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Restituisce uno dei possibili tipi passandogli la rispettiva stringa
	 * 
	 * @param tipo String
	 * @return TipologiaCorsoEsame
	 */
	public TipologiaCorsoEsame fromString(String tipo) {
        for (TipologiaCorsoEsame g : TipologiaCorsoEsame.values()) {
            if (g.tipo.equalsIgnoreCase(tipo)) {
                return g;
            }
        }
        return null;
    }
	
	/**
	 * Restituisce il numero di anni da frequentare in base al tipo di corso
	 * 
	 * @return Integer
	 */
	public Integer numeroAnni() {
		switch (this.tipo) {
		case "triennale":
			return 3;
		case "magistrale":
			return 2;
		case "cicloUnico":
			return 5;
		default:
			return 0;
		}
	}
	
	/**
	 * Ritorna il tipo di laurea specificato uno dei numeri corrispondenti
	 * 
	 * @param number Integer
	 * @return type TipologiaCorsoEsame
	 */
	public TipologiaCorsoEsame getTypeFromNumber(Integer number) {
		
		if (number != null) {
			
			switch (number) {
			case 3: 
				return this.TRIENNALE;
			case 2:
				return this.MAGISTRALE;
			case 5:
				return this.CICLO_UNICO;
			default:
				Logger.writeLog("Il numero passato è diverso da quelli prestabiliti", LocalDateTime.now(), Thread.currentThread().getStackTrace());
				return null;
			}
		} else {
			Logger.writeLog("Il numero passato è null", LocalDateTime.now(), Thread.currentThread().getStackTrace());
			return null;
		}
		
	}
	
}
