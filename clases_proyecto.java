// Universidad del Valle de Guatemala
// Proyecto POO
// Grupo 6
// Luis Quezada 18028
// Mario Perdomo 18029
// Andree Toledo 18439
// Josue Sagastume 18173
// Martin Ortega 18029

// Classes del Proyecto

import java.lang.*;


class Sitema {}

class Calculadora {
	
	// variables
	protected int result;
	protected double resultDouble;
	
	
	// constructor
	public Calculadora() {}
	
	
	// metodos
	
	public int calcPoblacionTotal(int year) {
		
		result = (int) Math.round(2e-14 * Math.exp(0.024 * year));
		
		return result;
	}
	
	public int calcPoblacionHombres(int year) {
	
		result = (int) Math.round(5e-15 * Math.exp(0.0242 * year));
		
		return result;
	}
	
	public int calcPoblacionMujeres(int year) {
	
		result = (int) Math.round(1e-14 * Math.exp(0.0238 * year));
		
		return result;
	}
	
	public int calcIngresoLaboral(int year) {
		
		result = (int) Math.round((81.37 * year) + 1226);
		
		return result;
	}
	
	public int calcMuertes(int year) {
		
		result = (int) Math.round( 37.47 * Math.pow(year, 2) + 70.567 * year + 66867);
		
		return result;
	}
	
	public int calcMuertesCausaAmbiental(int year) {
		
		result = (int) Math.round( 637.57 * Math.pow(year, 2) - 1192.8 * year + 14318);
		
		return result;
	}
	
	public double calcCostoCanastaBasica(int year) {
		
		resultDouble = 3e-53 * Math.exp(0.064 * year);
		
		return resultDouble;
	}
}

class Analizador extends Calculadora {
	
	// constructor
	public Analizador() {}
	
	public void analize(int year) {
		
		// falta, parte de la entrega 4
	}
}
