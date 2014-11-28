package brahim.maven.FitxersMaven;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App{

	private static final String fitxer_a_llegir = "/matricules.txt";
	
	public static void main( String[] args ){
    	
    	BufferedReader inb = null;
    	
    	InputStream in = App.class.getResourceAsStream(fitxer_a_llegir);
    	
    	try {
    		Reader re = new InputStreamReader(in);
    		
    	    inb = new BufferedReader(re);
			
    	    String linia;
    	    
    	    linia = inb.readLine();
    	    
			while( linia != null ){
				String [] partsLinia = linia.split(" ");
				
				String numeros = partsLinia[0];
				
				String lletres = partsLinia[1];
				
				boolean dadesIntroCorrectes = ValidarDades(lletres, numeros);
				
				if(dadesIntroCorrectes == true){
					Matricula m = new Matricula( lletres, numeros);
					
					m.DonarLavolta();
					
					System.out.println(m.getMatricual());
				}

				linia = inb.readLine();
			}
			
		} catch (FileNotFoundException e1) {
			System.out.println("Peta perque no existeix el fitxer");
			e1.printStackTrace();
			
		} catch (IOException e) {
			System.out.println("Peta perque no pot llegir La linia");
			e.printStackTrace();
		} finally {
			try {
				inb.close();
            } catch (IOException e) {
            System.out.println("Peta al tencar");
          }
	   }
	}
	
	public static boolean ValidarDades(String lletres, String numeros){
		
		 boolean lletresCorrecte = false;
		 boolean numerosCorrecte = false;		
		
		 numerosCorrecte = ValidarDades2("[0-9]{4}", numeros);
		 
		 lletresCorrecte = ValidarDades2("[a-zA-Z]{2,3}", lletres);

		if(lletresCorrecte == true && numerosCorrecte == true){
		
			return true;
		}else{
			return false;
		}
		
	}
	
	public static boolean ValidarDades2(String norma, String valor){
		
		boolean esCorrecte =  false;
		
	    Pattern pat = Pattern.compile(norma);
	    Matcher mat = pat.matcher(valor);
	     
	    if (mat.matches()) {
	        esCorrecte = true;
	         
	    } else {
	        System.out.println("No s'han introduit caracters valids o la longitud es incorrectes");
	    }
		return esCorrecte;
	}
}
