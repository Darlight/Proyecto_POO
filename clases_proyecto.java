/*
Universidad del Valle de Guatemala
Proyecto POO
Grupo 6
Luis Quezada 18028
Mario Perdomo 18029
Andree Toledo 18439
Josue Sagastume 18173
Martin Ortega 18020
Classes del Proyecto
*/

import java.lang.*;
import java.text.NumberFormat;


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
	private NumberFormat format = NumberFormat.getInstance();	

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
		
		analisis += "\n   La poblacion total se estima que sera " + format.format(resPoblacion)+ " personas para el " + format.format(year) + ".";
		
		
	// pobreza
		analisis += "\n\n - En cuanto a la calidad de vida y pobreza, se puede decir que ";
		if (resIngreso > resCostoCB) {
			analisis += "\n   esta en buen estado por que el ingreso mensual promedio para una persona (Q. " + format.format(Math.round(resIngreso)) + ") \n   le es suficiente para poder comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB)) + ").";
			analisis += "\n   Se puede decir que gran parte de la poblacion no vive en pobreza extrema.";
			
		} else if (resIngreso < resCostoCB) {
			
			analisis += "\n   esta en mal estado por que el ingreso mensual promedio para una persona (Q. " + format.format(Math.round(resIngreso)) + ") \n   no es suficiente para poder al menos comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB)) + ").";
			analisis += "\n   Se puede decir que probablemente hay pobreza extrema y baja calidad de vida para gran parte de la poblacion.";
			
		} else {
		
			analisis += "\n   esta en un estado critico por que las personas en promedio pueden comprar la canasta bascia (" + format.format(Math.round(resCostoCB)) + ") pero no les queda dinero para nada mas.";
		}
		
		
	// ambiente
		analisis += "\n\n - En cuanto al estado del medio ambiente, se puede decir que ";
		if (resMuertes > resMuertesA) {
			analisis += "\n   esta en buen estado por que hay mas muertes normales (" + format.format(resMuertes) + ") que por causa del medio ambiente (" + resMuertesA + ").";
			analisis += "\n   Siendo estas solo el " + format.format(Math.round(100*resMuertesA/resMuertes)) + "% de las defunciones totales.";
			
		} else if (resMuertes < resMuertesA) {
			
			analisis += "\n   esta en muy mal estado por que hay mas muertes a causa del ambiente (" + format.format(resMuertesA) + ") que por causa natural (" + resMuertes + ").";
			analisis += "\n   Siendo la diferencia entre estas de " + format.format(resMuertesA-resMuertes) + " defunciones.";
			
		} else {
		
			analisis += "\n   esta en un estado critico por que la cantidad de personas que mueren a causa del ambiente (" + format.format(resMuertesA) + ") iguala a la cantidad de personas que mueren por causa natural (" + format.format(resMuertes) + ").";
		}
		
		
	// conclusion
		analisis += "\n";
		
		return analisis;
	}
	public String analize(int year1, int year2){
		String analisis ="\nPara el " + year1 + " y  el " + year2 + ", se obtiene el siguiente analisis:";

		// para el analisis de personas y comparacion de años
		int resPoblacion1 = this.calcPoblacionTotal(year1);
		int resHombres1 = this.calcPoblacionHombres(year1);
		int resMujeres1 = this.calcPoblacionMujeres(year1);
		int resPoblacion2 = this.calcPoblacionTotal(year2);
		int resHombres2 = this.calcPoblacionHombres(year2);
		int resMujeres2 = this.calcPoblacionMujeres(year2);
		
		// para el analisis de pobreza
		double resIngreso1 = this.calcIngresoLaboral(year1);
		double resCostoCB1 = this.calcCostoCanastaBasica(year1);
		double resIngreso2 = this.calcIngresoLaboral(year2);
		double resCostoCB2 = this.calcCostoCanastaBasica(year2);
		
		
		// para el analisis del ambiente
		int resMuertes1 = this.calcMuertes(year1);
		int resMuertesA1 = this.calcMuertesCausaAmbiental(year1);
		int resMuertes2 = this.calcMuertes(year2);
		int resMuertesA2 = this.calcMuertesCausaAmbiental(year2);
		
		analisis += "\n\n - En cuanto a las poblaciones, se puede decir que esta conformadas";
		//1era condicion
		if (resHombres1 > resMujeres1 && resHombres2 > resMujeres2) {

			analisis += "\n   mayormente por hombres del " + format.format(year1) + ", siendo estos el " + format.format(Math.round(100*resHombres1/(resHombres1+resMujeres1))) + "%, mientras que del " + format.format(year2) + " , conformados mayormente de hombres, siendo estos el " + format.format(Math.round(100*resHombres2/(resHombres2+resMujeres2))) + "%.";
		//2 condicion
		} else if (resHombres1 < resMujeres1 && resHombres2 > resMujeres2) {
			
			analisis += "\n   mayormente por mujeres, siendo estas el " + format.format(Math.round(100*resMujeres1/(resHombres1+resMujeres1))) + "%, mientras que del " + format.format(year2) + " , conformados mayormente de hombres, siendo estos el " + format.format(Math.round(100*resMujeres2/(resHombres2+resMujeres2))) + "%.";
		//3 condicion	
		} else if (resHombres1 > resMujeres1 && resHombres2 < resMujeres2) {

			analisis += "\n   mayormente por hombres del " + format.format(year1) + " , siendo estos el " + format.format(Math.round(100*resHombres1/(resHombres1+resMujeres1))) + "%, mientras que del " + format.format(year2) + " , conformados mayormente de mujeres, siendo estas el " + format.format(Math.round(100*resMujeres2/(resHombres2+resMujeres2))) + "%.";
		//4 condicion
		} else if (resHombres1 < resMujeres1 && resHombres2 < resMujeres2) {
		
			analisis += "\n   mayormente por mujeres del " + format.format(year1) + " , siendo estos el " + format.format(Math.round(100*resMujeres1/(resHombres1+resMujeres1))) + "%, mientras que del " + format.format(year2) + " , conformados mayormente de mujeres, siendo estas el " + format.format(Math.round(100*resMujeres2/(resHombres2+resMujeres2))) + "%.";
		//5 condicion
		}else if (resHombres1 == resMujeres1 && resHombres2 < resMujeres2) {
		
			analisis += "\n   por la misma cantidad de hombres que mujeres del"  + format.format(year1) + " (50%), mientras que del " + format.format(year2) + ", conformados mayormente de mujeres, siendo estas el " + format.format(Math.round(100*resMujeres2/(resHombres2+resMujeres2))) + "%.";
		//6 condicion
		} else if (resHombres1 == resMujeres1 && resHombres2 > resMujeres2) {
			
			analisis += "\n   por la misma cantidad de hombres que mujeres del"  + format.format(year1) + " (50%), mientras que del " + format.format(year2) + ", conformados mayormente de hombres, siendo estos el " + format.format(Math.round(100*resHombres2/(resHombres2+resMujeres2))) + "%.";
		//7 condicion
		} else if (resHombres1 > resMujeres1 && resHombres2 == resMujeres2) {

			analisis += "\n   mayormente por hombres del " + format.format(year1) + ", siendo estos el " + format.format(Math.round(100*resHombres1/(resHombres1+resMujeres1))) + "%, mientras que del " + format.format(year2) + " , por la misma cantidad de hombres que mujeres (50%).";

		//8 condicion
		} else if (resHombres1 < resMujeres1 && resHombres2 == resMujeres2) {

			analisis += "\n   mayormente por mujeres del " + format.format(year1) + ", siendo estas el " + format.format(Math.round(100*resMujeres1/(resMujeres1+resMujeres1))) + "%, mientras que del " + format.format(year2) + " , por la misma cantidad de hombres que mujeres (50%).";
		//9 condicion
		}else if (resHombres1 == resMujeres1 && resHombres2 == resMujeres2) {
			
			analisis += "\n   por la misma cantidad de hombres que mujeres en ambas poblaciones (50%).";

		}
		
		analisis += "\n   La poblacion total se estima que sera " + format.format(resPoblacion1) + " personas para el " + format.format(year1) + ", mientras que del " + format.format(year2) + " sera" + format.format(resPoblacion2) + " personas.";
		
		
	// pobreza
		analisis += "\n\n - En cuanto a la calidad de vida y pobreza, se puede decir que ";
		if (resIngreso1 > resCostoCB1 && resIngreso2 > resCostoCB2) {

			analisis += "\n   esta en buen estado porque el ingreso mensual promedio para una persona (Q. " + format.format(Math.round(resIngreso1)) + ") \n  del " + format.format(year1) + ", le es suficiente para poder comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB1)) + ").";
			analisis += "\n En el caso del " + format.format(year2) + ", tambien esta en buen estado por que el ingreso mensual promedio para una persona (Q. " + format.format(Math.round(resIngreso2)) + ") \n  del " + format.format(year2) + ", le es suficiente para poder comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB2)) + ").";
			analisis += "\n   Se puede decir que gran parte de la poblacion en ambos casos no viven en pobreza extrema.";
			
		} else if (resIngreso1 > resCostoCB1 && resIngreso2 < resCostoCB2) {
			
			analisis += "\n   esta en buen estado porque el ingreso mensual promedio para una persona (Q. " + format.format(Math.round(resIngreso1)) + ") \n  del " + format.format(year1) + ", le es suficiente para poder comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB1)) + ").";
			analisis += "\n En el caso del " + format.format(year2) + ", esta en un critico estado porque las personas en promedio pueden comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB2)) + "), pero no les queda dinero para nada mas.";
			analisis += "\n   Se puede decir que gran parte de la poblacion del " + format.format(year1) +" no viven en pobreza extrema. Sin embargo, el " + format.format(year2) +  " no contiene el promedio necesario de economia para vivir sanos en su vida cotidiana.";
			
		} else if (resIngreso1 > resCostoCB1 && resIngreso2 == resCostoCB2){
		
			analisis += "\n   esta en buen estado porque el ingreso mensual promedio para una persona (Q. " + format.format(Math.round(resIngreso1)) + ") \n  del " + format.format(year1) +  ", le es suficiente para poder comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB1)) + ").";
			analisis += "\n En el caso del " + format.format(year2) + ", esta en un critico estado por que las personas en promedio pueden comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB2)) + "), pero solo estarian sobreviviendo, ya que el ingreso promedio es de (Q. " + format.format(Math.round(resIngreso2)) + ").";
			analisis += "\n  Se puede decir que gran parte de la poblacion del " + format.format(year1) +" no viven en pobreza extrema. Sin embargo, en el " + format.format(year2) + " los ciudadanos estarian solamente sobreviviendo, indicando un mal desarrollo humano.";

		} else if (resIngreso1 < resCostoCB1 && resIngreso2 > resCostoCB2) {

			analisis += "\n   esta en un critico estado porque las personas en promedio pueden comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB1)) + "), pero no les queda dinero para nada mas.";
			analisis += "\n En el caso del " + format.format(year2) + ", tambien esta en buen estado por que el ingreso mensual promedio para una persona (Q. " + format.format(Math.round(resIngreso2)) + "), le es suficiente para poder comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB2)) + ").";
			analisis += "\n   Se puede decir que gran parte de la poblacion del " + format.format(year2) +" no viven en pobreza extrema. Sin embargo, el " + format.format(year1) +  " no contiene el promedio necesario de economia para vivir sanos en su vida cotidiana.";

		}else if (resIngreso1 < resCostoCB1 && resIngreso2 < resCostoCB2) {
			analisis += "\n   esta en un critico estado porque las personas en promedio pueden comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB1)) + "), pero no les queda dinero para nada mas.";
			analisis += "\n En el caso del " + format.format(year2) + ", esta en un critico estado porque las personas en promedio pueden comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB2)) + "), pero no les queda dinero para nada mas.";
			analisis += "\n   Se puede decir que gran parte de la poblacion en ambos casos viven en pobreza extrema.";

		}else if (resIngreso1 < resCostoCB1 && resIngreso2 == resCostoCB2) {
			analisis += "\n   esta en un critico estado porque las personas en promedio pueden comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB1)) + "), pero no les queda dinero para nada mas.";
			analisis += "\n En el caso del " + format.format(year2) + ", esta en un critico estado porque las personas en promedio pueden comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB2)) + "), pero solo estarian sobreviviendo, ya que el ingreso promedio es de (Q. " + format.format(Math.round(resIngreso2)) + ").";
			analisis += "\n   Se puede decir que gran parte de la poblacion del " + format.format(year1) +"  viven en pobreza extrema. Sin embargo, el " + format.format(year2) + " los ciudadanos estarian solamnete sobreviviendo, indicando un mal desarrollo humano.";
		}else if (resIngreso1 == resCostoCB1 && resIngreso2 > resCostoCB2) {
			analisis += "\n   esta en un critico estado porque las personas en promedio pueden comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB2)) + "), pero solo estarian sobreviviendo, ya que el ingreso promedio es de (Q. " + format.format(Math.round(resIngreso2)) + ").";
			analisis += "\n En el caso del " + format.format(year2) + ", tambien esta en buen estado por que el ingreso mensual promedio para una persona (Q. " + format.format(Math.round(resIngreso2)) + "), le es suficiente para poder comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB2)) + ").";
			analisis += "\n   Se puede decir que gran parte de la poblacion del " + format.format(year2) +"  no viven en pobreza extrema. Sin embargo, el " + format.format(year1) +  " los ciudadanos estarian solamente sobreviviendo, indicando un mal desarrollo humano.";
		}else if (resIngreso1 == resCostoCB1 && resIngreso2 < resCostoCB2) {
			analisis += "\n   esta en un critico estado porque las personas en promedio pueden comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB2)) + "), pero solo estarian sobreviviendo, ya que el ingreso promedio es de (Q. " + format.format(Math.round(resIngreso2)) + ").";
			analisis += "\n En el caso del " + format.format(year2) + ", esta en un critico estado porque las personas en promedio pueden comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB2)) + "), pero no les queda dinero para nada mas.";
			analisis += "\n   Se puede decir que gran parte de la poblacion del " + format.format(year2) +"  no viven en pobreza extrema. Sin embargo, el " + format.format(year1) +  " los ciudadanos estarian solamente sobreviviendo, indicando un mal desarrollo humano.";
		}else if (resIngreso1 == resCostoCB1 && resIngreso2 == resCostoCB2) {
			analisis += "\n   esta en un critico estado porque las personas en promedio pueden comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB2)) + "), pero solo estarian sobreviviendo, ya que el ingreso promedio es de (Q. " + format.format(Math.round(resIngreso2)) + ").";
			analisis += "\n En el caso del " + format.format(year2) + ", esta en un critico estado porque las personas en promedio pueden comprar la canasta basica (Q. " + format.format(Math.round(resCostoCB2)) + "), pero solo estarian sobreviviendo, ya que el ingreso promedio es de (Q. " + format.format(Math.round(resIngreso2)) + ").";
			analisis += "\n   Se puede decir que gran parte de la poblacion en ambos casos solo sobreviven para alimentarse, pero no logran destacar en un desarrollo humano positivo";
		}
		
		 
	// ambiente
		analisis += "\n\n - En cuanto al estado del medio ambiente, se puede decir que ";
		if (resMuertes1 > resMuertesA1) {
			analisis += "\n   esta en buen estado por que hay mas muertes normales (" + format.format(resMuertes1) + ") que por causa del medio ambiente (" + format.format(resMuertesA1) + ").";
			analisis += "\n   Siendo estas solo el " + format.format(Math.round(100*resMuertesA1/resMuertes1)) + "% de las defunciones totales.";
			
		} else if (resMuertes1 < resMuertesA1) {
			
			analisis += "\n   esta en muy mal estado por que hay mas muertes a causa del ambiente (" + format.format(resMuertesA2) + ") que por causa natural (" + format.format(resMuertes1) + ").";
			analisis += "\n   Siendo la diferencia entre estas de " + format.format((resMuertesA1-resMuertes1)) + " defunciones.";
			
		} else {
		
			analisis += "\n   esta en un estado critico por que la cantidad de personas que mueren a causa del ambiente (" + format.format(resMuertesA1) + ") iguala a la cantidad de personas que mueren por causa natural (" + format.format(resMuertes1) + ").";
		}
		
		
	// conclusion
		analisis += "\n";
		
		return analisis;
		
	}
}











