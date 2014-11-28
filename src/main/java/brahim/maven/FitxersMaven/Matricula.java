package brahim.maven.FitxersMaven;

public class Matricula {

	String lletres;
	
	String numeros;
	
	String Matricual;
	
	
	public Matricula(String Lletres, String Numeros) {
		
		lletres = Lletres;
		numeros =  Numeros;
		Matricual = numeros+lletres;
		
	}
	
	public void DonarLavolta(){
		
		Matricual = lletres+" "+numeros;
	}

	public String getLletres() {
		return lletres;
	}

	public void setLletres(String lletres) {
		this.lletres = lletres;
	}

	public String getNumeros() {
		return numeros;
	}

	public void setNumeros(String numeros) {
		this.numeros = numeros;
	}

	public String getMatricual() {
		return Matricual;
	}

	public void setMatricual(String matricual) {
		Matricual = matricual;
	}
	
	

}
