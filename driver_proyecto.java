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
		int option = 0, inputYear=0;
	
		
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
			
			
			if (option != 6 && option != 5) {
			
				System.out.println("\n>>> Ingrese el anio para el cual desea hacer el calculo (futuro): ");
		
				try { // progra defensiva para opcion
					inputYear = scan.nextInt();
					scan.nextLine();
			
				} catch (InputMismatchException e) {
		
					scan.nextLine();
					System.out.println("<!> No ingreso un numero...");	
				}

				// progra defensiva para numero de opcion
				while (inputYear < 1950) {
	
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
			}
			
			
			if (option == 1) {
			
				System.out.println(simulador.showPoblacion(inputYear));
				
			} else if (option == 2) {
				
				System.out.println(simulador.showIngresoLaboral(inputYear));
				
			} else if (option == 3) {
				
				System.out.println(simulador.showMuertes(inputYear));
				
			} else if (option == 4) {
				
				System.out.println(simulador.showCostoCanastaBasica(inputYear));
				
			} else if (option == 5) {
				
				// El analizador todavia no ha sido implementado
				option = 6;
				
			}
			
			System.out.println("\n\t\t  Presione ENTER para continuar.");
			scan.nextLine();
		}
		
	System.out.println("\t\t Gracias por usar SimulaGuate :)\n\n\n");
	
	}
}
