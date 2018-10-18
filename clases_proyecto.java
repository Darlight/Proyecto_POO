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


class Sistema {
	private String resPoblacion;
	private String resEmpleo;
	private String resMuertes;
	private String resCanasta;
	private Calculadora calculadora;
	private Analizador analizador;
	public Sistema(){
		resPoblacion = "";
		resEmpleo = "";
		resMuertes = "";
		resCanasta = "";
		calculadora =  new Calculadora();
		analizador = new Analizador();
	}
	public String showPoblacion(int year){
		resPoblacion = ("|█████████████████████████████████████████████████████████████████|\n");
		resPoblacion += ("Poblacion total del año " + year + " : " + calculadora.calcPoblacionTotal(year) + "personas \n");
		resPoblacion += ("Cantidad de hombres: " + calculadora.calcPoblacionHombres(year) + "\n");
		resPoblacion += ("Cantidad de mujeres: " + calculadora.calcPoblacionMujeres(year) + "\n");
		resPoblacion += ("|█████████████████████████████████████████████████████████████████|\n");
		return resPoblacion;
	}
	public String showIngresoLaboral(int year){
		resEmpleo = ("|█████████████████████████████████████████████████████████████████|\n");
		resEmpleo += ("Ingreso promedio mensual de una persona del año " + year +" : Q " + calculadora.calcIngresoLaboral(year) + "\n");
		resEmpleo += ("|█████████████████████████████████████████████████████████████████|\n");
		return resEmpleo;

	}
	public String showMuertes(int year){
		resMuertes = ("|█████████████████████████████████████████████████████████████████|\n");
		resMuertes += ("Promedio General de fallecidos en Guatemala del año " + year + ": " + calculadora.calcMuertes(year) +  "  Personas\n");
		resMuertes += ("Promedio General de fallecidos por causa ambiental en Guatemala del año " + year + ": " + calculadora.calcMuertesCausaAmbiental(year) +  "  Personas\n");
		resMuertes += ("|█████████████████████████████████████████████████████████████████|\n");
		return resEmpleo;
	}
	public String showCostoCanastaBasica(int year){
		resCanasta = ("|█████████████████████████████████████████████████████████████████|\n");
		resCanasta += ("Promedio General de la canasta basica del año" + year + ": " + calculadora.calcCostoCanastaBasica(year) + " Quetzales \n");
		resCanasta += ("|█████████████████████████████████████████████████████████████████|\n");
		return resCanasta;
	}

}

class Calculadora {
	
	// variables
	private int result;
	private double resultDouble;
	
	
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