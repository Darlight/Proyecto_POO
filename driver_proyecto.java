// Universidad del Valle de Guatemala
// Proyecto POO
// Grupo 6
// Luis Quezada 18028
// Mario Perdomo 18029
// Andree Toledo 18439
// Josue Sagastume 18173
// Martin Ortega 18029

// Driver del Proyecto

import java.util.*;

public class driver_proyecto {

	public static void main(String args[]) {
	
		// Variables
		Scanner scan = new Scanner(System.in);
		Sistema simulador = new Sistema();
		int option = 0, inputYear=0, inputYear2 = 0;
		String analizeConf = "";
	
		
		try { Thread.sleep(2*500); } catch (Exception e) { System.out.println(">>> ERROR: " + e); }
		
		
		System.out.println("\n___________________________________________________________________");
		System.out.println("\n\n\t\t    BIENVENIDO A SimulaGuate");
		System.out.println("\n___________________________________________________________________");
		
		System.out.println("\n\t\t  Presione ENTER para iniciar.");
		scan.nextLine();
		
		try { Thread.sleep(500); } catch (Exception e) { System.out.println(">>> ERROR: " + e); }
		
		System.out.println("  Este es un simulador para datos de Guatemala futuros. \n  Esta basado en datos estadisticos reales para poder hacer estas predicciones.");
		System.out.println("  Este proyecto puede ser bastante util para indicar como \n  sera el futuro de Guatemala y evaluar su sostenibilidad.");
		System.out.println("  Solo es necesario que usted ingrese el anio para el que desea la prediccion, y listo!");
		
		System.out.println("\n>>> Cargando menu...");
		
		try { Thread.sleep(4000); } catch (Exception e) { System.out.println(">>> ERROR: " + e); }
		
		
		while (option != 6) {
		
			System.out.println("\n______________________________________________________\n");
			System.out.println("\t\tMenu de Opciones\n");
			System.out.println("\t1. Calcular Poblacion Total");
			System.out.println("\t2. Calcular Ingreso Mensual Promedio");
			System.out.println("\t3. Calcular Defunciones");
			System.out.println("\t4. Calcular Costo Canasta Basica");
			System.out.println("\t5. Usar Analizador");
			System.out.println("\t6. Salir");
			System.out.println("\n______________________________________________________");
		
			System.out.println("\n>>> Ingrese la opcion que desea ejecutar: ");
		
			try { // progra defensiva para opcion
				option = scan.nextInt();
				scan.nextLine();
			
			} catch (InputMismatchException e) {
		
				scan.nextLine();
				System.out.println("<!> No ingreso un numero...");	
			}

			// progra defensiva para numero de opcion
			while (option < 1 || option > 6) {
	
				System.out.println("<!> No ingreso una opcion valida...");
				System.out.println("\n>>> Ingrese la opcion que desea ejecutar: ");
			
				try {
					option = scan.nextInt();
					scan.nextLine();
			
				} catch (InputMismatchException e) {
			
					scan.nextLine();
					System.out.println("<!> No ingreso un numero...");	
				}
			}
			
			
			if (option != 6) {
			
				System.out.println("\n>>> Ingrese el anio para el cual desea hacer el calculo (futuro): ");
		
				try { // progra defensiva para opcion
					inputYear = scan.nextInt();
					scan.nextLine();
			
				} catch (InputMismatchException e) {
		
					scan.nextLine();
					System.out.println("<!> No ingreso un numero...");	
				}

				// progra defensiva para numero de opcion
				while (inputYear < 2009) {
	
					System.out.println("<!> No ingreso una opcion valida...");
					System.out.println("\n>>> Ingrese el anio para el cual desea hacer el calculo: ");
			
					try {
						inputYear = scan.nextInt();
						scan.nextLine();
			
					} catch (InputMismatchException e) {
			
						scan.nextLine();
						System.out.println("<!> No ingreso un numero...");	
					}
				}
				
				
				if (option == 5) { // para verificar si quiere analizar 1 o 2 anios
					
					System.out.println("\n>>> Desea analizar/comparar con otro anio? Ingrese 'si' o 'no': ");
					
					analizeConf = scan.nextLine();
					
					if (analizeConf.equals("si")) {
						
						
						System.out.println("\n>>> Ingrese el segundo anio para el cual desea hacer el calculo (futuro): ");
		
						try { // progra defensiva para opcion
							inputYear2 = scan.nextInt();
							scan.nextLine();
			
						} catch (InputMismatchException e) {
		
							scan.nextLine();
							System.out.println("<!> No ingreso un numero...");	
						}

						// progra defensiva para numero de opcion
						while (inputYear2 < 2009) {
	
							System.out.println("<!> No ingreso una opcion valida...");
							System.out.println("\n>>> Ingrese el anio para el cual desea hacer el calculo: ");
			
							try {
								inputYear2 = scan.nextInt();
								scan.nextLine();
			
							} catch (InputMismatchException e) {
			
								scan.nextLine();
								System.out.println("<!> No ingreso un numero...");	
							}
						}
					} else {
						
						System.out.println(">>> ok!\n\n");
					}
					
				}
			}
			
			
			
			if (option == 1) {
			
				System.out.println(simulador.showPoblacion(inputYear)); // show poblacion
				
			} else if (option == 2) {
				
				System.out.println(simulador.showIngresoLaboral(inputYear));  // show ingreso mensual promedio por persona
				
			} else if (option == 3) {
				
				System.out.println(simulador.showMuertes(inputYear)); // muertes totales 
				
			} else if (option == 4) {
				
				System.out.println(simulador.showCostoCanastaBasica(inputYear)); // costo anual de la canasta basica
				
			} else if (option == 5) {
				
				System.out.println("\n________________________________________________________________\n\n\t   Bienvenido al analizador de SimulaGuate");
				
				if (analizeConf.equals("si")) { // para cuando se van a analizar 2 anios
					
					System.out.println("\n>>> Usted a ingresado el anio " + inputYear + " y " + inputYear2 + " para realizar el calculo y analisis...");
					System.out.println(">>> Espere un momento... \n   el analizador esta realizando los calculos.");
				
					try { Thread.sleep(5000); } catch (Exception e) { System.out.println(">>> ERROR: " + e); } // para que el usuario pueda leer
				
					System.out.println("\n\n\n\n\n\n\n\n\n\n\t\t\t    ANALISIS" + simulador.showAnalisis(inputYear, inputYear2));
					
					
				} else { // cuando solo se va analizar un anio
					
					System.out.println("\n>>> Usted a ingresado el anio " + inputYear + " para realizar el calculo.");
					System.out.println(">>> Espere un momento... \n   el analizador esta realizando los calculos.");
				
					try { Thread.sleep(5000); } catch (Exception e) { System.out.println(">>> ERROR: " + e); } // para que el usuario pueda leer
				
					System.out.println("\n\n\n\n\n\n\n\n\n\n\t\t\t    ANALISIS" + simulador.showAnalisis(inputYear));
				}
			}
			
			if (option != 6) {
				
				System.out.println("\n\t\t  Presione ENTER para continuar.");
				scan.nextLine();
			}
		}
		
	System.out.println("\t\t Gracias por usar SimulaGuate :)\n\n\n");
	
	}
}
