package javasource.resourceobjects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javasource.Constants;

/**
 * La classe Logger definisce uno strumento per la creazione di file di Log
 * 
 * @author barbi michael
 */

public abstract class Logger {
	
	/**
	 * 
	 * Costruttore
	 */
	public Logger() {
		
	}

	/**
	 * Nome della classe in cui compare l'errore
	 */
	private String className;
	
	/**
	 * Nome del metodo in cui compare l'errore
	 */
	private String methodName;
	
	/**
	 * Messaggio dell'errore
	 */
	private String message;
	
	/**
	 * Numero riga dell'errore
	 */
	private long riga;
	
	/*
	 * instante di tempo dell'errore
	 */
	private LocalDateTime local;

	/**
	 * Restituisce il campo className
	 *
	 * @return className String
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Imposta il valore del campo className
	 *
	 * @param className String
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Restituisce il campo methodName
	 *
	 * @return methodName String
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * Imposta il valore del campo methodName
	 *
	 * @param methodName String
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * Restituisce il campo message
	 *
	 * @return message String
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Imposta il valore del campo message
	 *
	 * @param message String
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	/**
	 * Scrive sul file di log un nuovo errore
	 * 
	 * @param message String
	 * @param local {@link LocalDateTime}
	 * @param stackTrace {@link StackTraceElement}[]
	 */
	public static void writeLog(String message, LocalDateTime local, StackTraceElement[] stackTrace) {
		try {
			
			StackTraceElement callingMethod = stackTrace[2];
			
			File logFile = new File(Constants.LOG);
			
			//Scrittura sul file di log
			BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true));
			
			bw.write(Constants.LOG_SEP);
			
			/**
			 * 
			 * timestamp
			 * numero riga - nome file - nome metodo
			 * messaggio di errore
			 */
			
	        // Crea un formato per la data e l'ora
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	        // Formatta la data e l'ora
	        String formattedDateTime = local.format(formatter);
	        bw.write(formattedDateTime);
	        
	        bw.newLine();
	        bw.write(callingMethod.getLineNumber() + ") " + callingMethod.getClassName() + " - " + callingMethod.getMethodName());
	        bw.newLine();
	        bw.write(message);	
			
	        bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
