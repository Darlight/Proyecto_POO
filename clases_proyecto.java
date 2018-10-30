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
	//Variables del constructor del Sistema
	private String resPoblacion;
	private String resEmpleo;
	private String resMuertes;
	private String resCanasta;
	private String resAnalisis;
	private Calculadora calculadora;
	private Analizador analizador;
	
	
	//Constructor de sistema
	public Sistema(){
		//Se inicia con valores los variables de instancia
		resPoblacion = "";
		resEmpleo = "";
		resMuertes = "";
		resCanasta = "";
		resAnalisis = "";
		
		//Se crean las clases principales complementarios para estimar los datos programados
		calculadora =  new Calculadora();
		analizador = new Analizador();
	}
	
	public String showPoblacion(int year) {
		//La poblacion resultado respecto al anio
		resPoblacion = ("\n|█████████████████████████████████████████████████████████████████|\n\n");
		resPoblacion += ("Poblacion total del año " + year + ": " + calculadora.calcPoblacionTotal(year) + " personas\n");
		resPoblacion += ("Cantidad de hombres: " + calculadora.calcPoblacionHombres(year) + "\n");
		resPoblacion += ("Cantidad de mujeres: " + calculadora.calcPoblacionMujeres(year));
		resPoblacion += ("\n\n|█████████████████████████████████████████████████████████████████|\n");
		return resPoblacion;
	}
	
	public String showIngresoLaboral(int year) {
		//Muestra el ingreso Laboral 
		resEmpleo = ("\n|█████████████████████████████████████████████████████████████████|\n\n");
		resEmpleo += ("Ingreso promedio mensual de una persona del año " + year +": Q " + calculadora.calcIngresoLaboral(year));
		resEmpleo += ("\n\n|█████████████████████████████████████████████████████████████████|\n");
		return resEmpleo;

	}
	
	public String showMuertes(int year) {
		//Promedio general respecto a un anio la cantidad de muertes
		resMuertes = ("\n|█████████████████████████████████████████████████████████████████|\n\n");
		resMuertes += ("Promedio General de fallecidos en Guatemala del año " + year + ": " + calculadora.calcMuertes(year) +  " personas");
		resMuertes += ("\nPor causa ambiental: " + calculadora.calcMuertesCausaAmbiental(year) +  "  personas");
		resMuertes += ("\n\n|█████████████████████████████████████████████████████████████████|\n");
		return resMuertes;
	}
	
	public String showCostoCanastaBasica(int year) {
		//Canasta basica respecto al anio
		resCanasta = ("\n|█████████████████████████████████████████████████████████████████|\n\n");
		resCanasta += ("Promedio General de la canasta basica del año " + year + ": " + calculadora.calcCostoCanastaBasica(year) + " Quetzales");
		resCanasta += ("\n\n|█████████████████████████████████████████████████████████████████|\n");
		return resCanasta;
	}
	
	public String showAnalisis(int year) {
		// analisis
		resAnalisis = ("\n|█████████████████████████████████████████████████████████████████|\n\n");
		resAnalisis += (analizador.analize(year));
		resAnalisis += ("\n\n|█████████████████████████████████████████████████████████████████|\n");
		return resAnalisis;
	}
}



class Calculadora {
	
	// variables
	protected int result;
	protected double resultDouble;

	// constructor
	public Calculadora() {}
	
	
	// metodos
	
	public int calcPoblacionTotal(int year) {
		
		result = (int) Math.round(13677815.3463658 * Math.pow(1.024508023, (year-2008)/0.999751029));
		
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
	
	public double calcIngresoLaboral(int year) {
		
		resultDouble = (67.732 * year) - 134409;
		
		return resultDouble;
	}
	
	public int calcMuertes(int year) {
		
		result = (int) Math.round( 37.47 * Math.pow(year, 2) + 70.567 * year + 66867);
		
		return result;
	}
	
	public int calcMuertesCausaAmbiental(int year) {
		
		result = (int) Math.round( 2632.6 * year + 9855.5);
		
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
	
	public String analize(int year) {
		
		String analisis ="\nPara el " + year + " se obtiene el siguiente analisis:";
		
		// para el analisis de personas
		int resPoblacion = this.calcPoblacionTotal(year);
		int resHombres = this.calcPoblacionHombres(year);
		int resMujeres = this.calcPoblacionMujeres(year);
		
		// para el analisis de pobreza
		double resIngreso = this.calcIngresoLaboral(year);
		double resCostoCB = this.calcCostoCanastaBasica(year);
		
		// para el analisis del ambiente
		int resMuertes = this.calcMuertes(year);
		int resMuertesA = this.calcMuertesCausaAmbiental(year);
		
		
		
		// analisis y formacion de la respuesta en base a los resultados
		
	// personas
		analisis += "\n\n - En cuanto a la poblacion, se puede decir que esta conformada";
		if (resHombres > resMujeres) {
			analisis += "\n   mayormente por hombres, siendo estos el " + Math.round(100*resHombres/(resHombres+resMujeres)) + "% de ella.";
			
		} else if (resHombres < resMujeres) {
			
			analisis += "\n   mayormente por mujeres, siendo estas el " + Math.round(100*resMujeres/(resHombres+resMujeres)) + "% de ella.";
			
		} else {
		
			analisis += "\n   por la misma cantidad de hombres que mujeres (50%).";
		}
		
		analisis += "\n   La poblacion total se estima que sera " + resPoblacion + " personas para el " + year + ".";
		
		
	// pobreza
		analisis += "\n\n - En cuanto a la calidad de vida y pobreza, se puede decir que ";
		if (resIngreso > resCostoCB) {
			analisis += "\n   esta en buen estado por que el ingreso mensual promedio para una persona (Q. " + Math.round(resIngreso) + ") \n   le es suficiente para poder comprar la canasta basica (Q. " + Math.round(resCostoCB) + ").";
			analisis += "\n   Se puede decir que gran parte de la poblacion no vive en pobreza extrema.";
			
		} else if (resIngreso < resCostoCB) {
			
			analisis += "\n   esta en mal estado por que el ingreso mensual promedio para una persona (Q. " + Math.round(resIngreso) + ") \n   no es suficiente para poder al menos comprar la canasta basica (Q. " + Math.round(resCostoCB) + ").";
			analisis += "\n   Se puede decir que probablemente hay pobreza extrema y baja calidad de vida para gran parte de la poblacion.";
			
		} else {
		
			analisis += "\n   esta en un estado critico por que las personas en promedio pueden comprar la canasta bascia (" + Math.round(resCostoCB) + ") pero no les queda dinero para nada mas.";
		}
		
		
	// ambiente
		analisis += "\n\n - En cuanto al estado del medio ambiente, se puede decir que ";
		if (resMuertes > resMuertesA) {
			analisis += "\n   esta en buen estado por que hay mas muertes normales (" + resMuertes + ") que por causa del medio ambiente (" + resMuertesA + ").";
			analisis += "\n   Siendo estas solo el " + Math.round(100*resMuertesA/resMuertes) + "% de las defunciones totales.";
			
		} else if (resMuertes < resMuertesA) {
			
			analisis += "\n   esta en muy mal estado por que hay mas muertes a causa del ambiente (" + resMuertesA + ") que por causa natural (" + resMuertes + ").";
			analisis += "\n   Siendo la diferencia entre estas de " + (resMuertesA-resMuertes) + " defunciones.";
			
		} else {
		
			analisis += "\n   esta en un estado critico por que la cantidad de personas que mueren a causa del ambiente (" + resMuertesA + ") iguala a la cantidad de personas que mueren por causa natural (" + resMuertes + ").";
		}
		
		
	// conclusion
		analisis += "\n";
		
		return analisis;
	}
}











