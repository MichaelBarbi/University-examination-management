package testing;

import java.time.LocalDateTime;
import java.util.List;

import javasource.resourceobjects.Logger;

/**
 * Tester per il corretto funzionamento degli resource objects
 * 
 * @author barbi michael
 */

public class Tester {
	
	/**
	 * 
	 * Costruttore
	 */
	public Tester() {}
	
	/**
	 * Funzione main
	 * 
	 * @param args String[]
	 */
	public static void main(String[] args) {
	
		
	}
	
	/**
	 * Stampa una lista di stringhe (Debug)
	 * 
	 * @param lista {@link List}String
	 */
	public static void printStringList(List<String> lista) {
		if (lista != null && lista.size() > 0) {
			for (String s : lista) {
				System.out.println(s);
			}
		} else {
			Logger.writeLog("Lista di stringhe errata", LocalDateTime.now(), Thread.currentThread().getStackTrace());
		}
	}
	
	/**
	 * Stampa un array di stringhe (Debug)
	 * 
	 * @param lista String[]
	 */
	public static void printStringList(String[] lista) {
		if (lista != null && lista.length > 0) {
			for (String s : lista) {
				System.out.println(s);
			}
		} else {
			Logger.writeLog("Array di stringhe errata", LocalDateTime.now(), Thread.currentThread().getStackTrace());
		}
	}
}
