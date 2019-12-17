import java.util.Scanner;

import funciones.Master;

public class MasterCodigo {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String dificultad;
    int longitud = 0;
    int intentos = 1;
    int[] numAdivina;
    int num;
    String[] salida;
    boolean salir = false;
    
    System.out.println("\n┌─────────────────────────┐"); 
    System.out.println("│ Bienvenido a MasterMind │");
    System.out.println("└─────────────────────────┘\n"); 
    
    // Establece la dificultad
    do {      
      System.out.println("- Facil (adivinar 4 numeros del 1 al 8) ");
      System.out.println("- Medio (adivinar 6 numeros del 1 al 8) ");
      System.out.println("- Dificil (adivinar 8 numeros del 1 al 8) ");
      System.out.print("Elige la dificultad (\'s\' para salir): ");
      dificultad = s.next();
      
      if (!dificultad.equals("s")) {
        longitud = funciones.Master.estableceLongitud(dificultad);
        if (longitud < 0) {
          System.out.println("\nOpcion introducida incorrecta. Vuelve a " + "introducir la dificultad.");
	      }
      } 
    } while (longitud < 0 && !dificultad.equals("s"));
    
    System.out.println("- \033[31mT\033[37m: Indica que tengo ese numero.");
    System.out.println("- \033[32mP\033[37m: Indica que tengo ese numero en posicion correcta.");
    
    if (!dificultad.equals("s")) {
      // Genera un número aleatorio con longitud en función de la dificultad
      numAdivina = funciones.Master.arrayAleatorios(longitud);
      
      /* Imprime el número para comprobar que va bien el programa
      for(int n: numAdivina) {
	     System.out.print(n);
      } */
      System.out.println();
	
      // Pinta tantos ? como longitud del número
      for (int i = 0; i < longitud; i++) {
	      System.out.print("\033[33m?\033[37m");
      }
      
      do {
	      // Comprueba si el número introducido es correcto
	      salir = false;
	      do {
	        System.out.print(" - Introduce un numero (para salir introduce un " + "numero negativo): ");
	        num = s.nextInt();
	        
	        if (num > 0 && !funciones.Master.compruebaNum(num, longitud)) {
	          System.out.print("Numero incorrecto.");
	        } 
	      } while (!funciones.Master.compruebaNum(num, longitud) && num > 0);
      

	      System.out.println();
	
	      // Comprueba si el número introducido es igual al que tenemos que 
	      // adivinar
	      if (funciones.Master.arrayIguales(numAdivina, num)) {
	        System.out.println("Enhorabuena, has ganado!!!");
	        salir = true;
	      } else if (intentos == 5) {
	        salir = true;
	        System.out.println("Lo siento, has perdido. El numero era: ");
	        funciones.Master.imprimeArrayInt(numAdivina);
	      } else if (num < 0) {
	        salir = true;
	        System.out.println("Saliendo...");
	      } else {
	        salida = funciones.Master.adivinado(numAdivina, num);
	        funciones.Master.imprimeArrayString(salida);
	      }
	
	      intentos++;
      } while (!salir);
      
    }
  }
}
