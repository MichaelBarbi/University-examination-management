package javasource.resourceobjects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javasource.Constants;

/**
 * La classe CorsoLaurea rappresenta un singolo corso di laurea di un'università
 * 
 * @author Barbi Michael
 */

public class CorsoLaurea implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Titolo del corso di laurea
	 */
	private String titolo;
	
	/**
	 * Tipologia del corso di laurea
	 */
	private TipologiaCorsoEsame tipo;
	
	/**
	 * Dipartimento del corso di laurea
	 */
	private String dipartimento;
	
	/**
	 * Tutte le materie del corso di laurea
	 */
	private String[][] materie;
	
	/**
	 * Lettura da file
	 */
	private BufferedReader br;
	
	/**
	 * Scrittura su file
	 */
	private static BufferedWriter bw;
	

	/**
	 * Costruttore
	 */
	public CorsoLaurea() {
		this.setTitolo(null);
		this.setTipo(TipologiaCorsoEsame.TRIENNALE); //Valore di default
		this.setDipartimento(null);
		this.setMaterie(null);
	}

	/**
	 * Costruttore con parametri (1)
	 * 
	 * @param titolo String
	 * @param tipo {@link TipologiaCorsoEsame}
	 * @param dipartimento String
	 * @param materie String[][]
	 */
	public CorsoLaurea(String titolo, TipologiaCorsoEsame tipo, String dipartimento, String[][] materie) {
		this.setTitolo(titolo);
		this.setTipo(tipo);
		this.setDipartimento(dipartimento);
		this.setMaterie(materie);
	}
	
	/**
	 * Costruttore con parametri (2)
	 * 
	 * @param titolo String
	 * @param tipo String
	 * @param dipartimento String
	 * @param materie String[][]
	 */
	public CorsoLaurea(String titolo, String tipo, String dipartimento, String[][] materie) {
		this.setTitolo(titolo);
		this.setTipo(tipo);
		this.setDipartimento(dipartimento);
		this.setMaterie(materie);
	}
	
	/**
	 * Costruttore con parametri (3)
	 * 
	 * @param titolo String
	 * @param tipo String
	 * @param dipartimento String
	 */
	public CorsoLaurea(String titolo, String tipo, String dipartimento) {
		this.setTitolo(titolo);
		this.setTipo(tipo);
		this.setDipartimento(dipartimento);
	}
	
	/**
	 * Costruttore con parametri (3)
	 * 
	 * @param titolo String
	 * @param tipo {@link TipologiaCorsoEsame}
	 * @param dipartimento String
	 */
	public CorsoLaurea(String titolo, TipologiaCorsoEsame tipo, String dipartimento) {
		this.setTitolo(titolo);
		this.setTipo(tipo);
		this.setDipartimento(dipartimento);
	}


	/**
	 * Restituisce il campo titolo
	 *
	 * @return titolo String
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * Imposta il valore del campo titolo
	 *
	 * @param titolo String
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * Restituisce il campo tipo
	 *
	 * @return tipo {@link TipologiaCorsoEsame}
	 */
	public TipologiaCorsoEsame getTipo() {
		return tipo;
	}
	
	/**
	 * Restituisce il campo tipo
	 *
	 * @return tipo String
	 */
	public String getTipoString() {
		return tipo.getTipo();
	}

	/**
	 * Imposta il valore del campo tipo
	 *
	 * @param tipo {@link TipologiaCorsoEsame}
	 */
	public void setTipo(TipologiaCorsoEsame tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Imposta il valore del campo tipo
	 *
	 * @param tipo String
	 */
	public void setTipo(String tipo) {
		this.tipo.setTipo(tipo);
	}

	/**
	 * Restituisce il campo dipartimento
	 *
	 * @return dipartimento String
	 */
	public String getDipartimento() {
		return dipartimento;
	}

	/**
	 * Imposta il valore del campo dipartimento
	 *
	 * @param dipartimento String
	 */
	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}

	/**
	 * Restituisce il campo materie
	 *
	 * @return materie String[][]
	 */
	public String[][] getMaterie() {
		return materie;
	}

	/**
	 * Imposta il valore del campo materie
	 *
	 * @param materie String[][]
	 */
	public void setMaterie(String[][] materie) {
		this.materie = materie;
	}
	
	/**
	 * Se la durata del corso di laurea è pari a n, viene definito una matrice di n righe, 
	 * nelle quali verranno assegnate le varie materia per ogni anno
	 */
	private void setMaterieSize() {
		if (this.tipo != null) {
			Integer tot = tipo.NumeroAnni();
			this.materie = new String[tot][];
		} else {
			System.err.println("\nIl tipo del corso di laurea non è specificato");
		}
	}
	
	/*
	 * Visualizza le materie su terminale
	 */
	public void printSerialMaterie() {
		if (materie != null) {
			
			System.out.println("\nStampa " + this.titolo);
			for (int i = 0; i < materie.length; i++) {
				System.out.print((i+1) + " anno = ");
				for (int j = 0; j < this.materie[i].length; j++) {
					System.out.print(this.materie[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.err.println("\nMaterie non presenti");
		}
	}
	
	/**
	 * Dato una lista di corsi, permette di salvarli tutti su un file
	 * 
	 * @param corsi List<CorsoLaurea>
	 */
	public static void writeCoursesOnFile(List<CorsoLaurea> corsi) {
		if (corsi != null) {
			
			try {
				//Aprire il file
				File materieFile = new File(Constants.MATERIE);
				
				bw = new BufferedWriter(new FileWriter(materieFile));
				
				//Scrittura del numero di corsi registrati
				bw.write(corsi.size());
				bw.newLine();
				
				//Scrittura dei vari corsi di laurea
				for(CorsoLaurea corso : corsi) {
					
					/*
					 * - Titolo corso
					 * - Dipartimento
					 * - Numero di anni
					 * - Lista di materie per ogni anno
					 *
					 */
					
					bw.write(corso.getTitolo());
					bw.newLine();
					
					bw.write(corso.getDipartimento());
					bw.newLine();
					
					bw.write(corso.getTipoString());
					bw.newLine();
					
					for(String[] materie_per_anno: corso.getMaterie()) {
						for (String materia: materie_per_anno) {
							bw.write(materia + Constants.MATERIE_SEP);
						}
						bw.newLine();
					}
				}
				
				bw.close();
				
			} catch (NullPointerException n) {
				n.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Logger.writeLog("Nessun corso definito", LocalDateTime.now(), Thread.currentThread().getStackTrace());
		}
	}
	
	public static List<CorsoLaurea> readCorsiOnFile() {
		List<CorsoLaurea> corsi_read = new ArrayList<CorsoLaurea>();
		
		try {
			
			//Apertura file
			File materieFile = new File(Constants.MATERIE);
			
			if (materieFile.length() == 0) {
				Logger.writeLog("Il file è vuoto", LocalDateTime.now(), Thread.currentThread().getStackTrace());
				return null;
			}
			
			BufferedReader br = new BufferedReader(new FileReader(materieFile));
			
			Integer size = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < size; i++) {
				CorsoLaurea corso = new CorsoLaurea();
				
				corso.setTitolo(br.readLine());
				corso.setDipartimento(br.readLine());
				corso.setTipo(br.readLine());
				
				corso.setMaterieSize();
				
				for (int j = 0; i < corso.getTipo().NumeroAnni(); j++) {
					corso.getMaterie()[j] = br.readLine().split(Constants.MATERIE_SEP); 
				}
			}
			
			br.close();
			
			
		} catch (IOException io) {
			Logger.writeLog(io.getMessage(), LocalDateTime.now(), Thread.currentThread().getStackTrace());
		} catch (NullPointerException n) {
			Logger.writeLog(n.getMessage(), LocalDateTime.now(), Thread.currentThread().getStackTrace());
		}
		
		return corsi_read;
	}
	
}
