package javasource;

import java.io.File;

/**
 * Questa classe racchiude tutte le costanti utilizzate nel programma
 * 
 * @author Barbi Michael
 */

public class Constants {
	
	/**
	 * files project path
	 */
	public final static String PATH = "src" + File.separator + "staticfiles" + File.separator + "files" + File.separator;
	
	/**
	 * Percorso file Materie
	 */
	public final static String MATERIE = (new File(Constants.PATH + "materie.txt")).getAbsolutePath();
	
	/**
	 * Separatore delle materie
	 */
	public final static String MATERIE_SEP = ",";
	
	/**
	 * Percorso file users. Contiene tutti gli utenti registrati
	 */
	public final static String USERS = (new File(Constants.PATH + "users.txt")).getAbsolutePath();
	
	/**
	 * Separatore informazioni del file users
	 */
	public final static String USERS_SEP = " ";
	
	/**
	 * Percorso file di log. Contiene tutti gli errori del programma
	 */
	public final static String LOG = (new File(Constants.PATH + "log.txt")).getAbsolutePath();
	
	/**
	 * Separatore di errori
	 * 
	 * In questo caso due newLine con formato specifico del sistema (ex: \n, \r\n)
	 */
	public final static String LOG_SEP = System.getProperty("line.separator") + System.getProperty("line.separator");
	

}
