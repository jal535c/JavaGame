package funciones;

import java.util.Scanner;

public class Master {
  /**
   * Recibe la dificultad del juego y la traduce al tamaño del array
   * 
   * @param dificultad dificultad del juego
   * @return           devuelve tamaño del array correspondiente a la dificultad
   */
  public static int estableceLongitud(String dificultad) {
    int x;
    
    switch (dificultad.toLowerCase()) {
      case "facil": x = 4; break;
      case "medio": x = 6; break;
      case "dificil": x = 8; break;
      default: x = -1;
    }
    
    return x;
  }
  

  /**
   * Genera un array con números aleatorio con el tamaño indicado en el 
   * parámetro.
   * 
   * @param x tamaño del array
   * @return  array con x números aleatorios distintos
   */
  public static int[] arrayAleatorios(int x) {
    boolean repetido;
    int[] n = new int[x];
    
    for (int i = 0; i < x; i++) {
      do {
	      repetido = false;
	      n[i] = (int)(Math.random() * 8) + 1;
	
	      for (int j = 0; j < i; j++) {
	        if (n[i] == n[j]) {
	          repetido = true;
	        }
	      }
      } while (repetido);
    }

    return n;
  }
  

  /**
   * Comprueba si el número introducido es correcto, es decir, si la dificultad
   * es facil tiene que introducir un número de 4 cifras.
   * 
   * @param n número entero
   * @param x tamaño del array 
   * @return  true si el número es correcto o false si tiene más de 4 cifras o 
   * 	      menos
   */
  public static boolean compruebaNum(int n, int x) {
    int longitud = 0;
    
    while (n++ > 0) {
      n /= 10;
      longitud++;
    }
    
    if (x == longitud) {
      return true;
    } else {
      return false;
    }
  }
  

  /**
   * Pasa un número entero pasado como parametro a array.
   * 
   * @param n número que queremos pasar a array
   * @param x número de dígitos de n
   * @return  array con los dígitos de n
   */
  public static int[] intToArray(int n, int x) {
    int[] a = new int[x];
    
    for (int i = x - 1; i >= 0; i--) {
      a[i] = n % 10;
      n /= 10;
    }

    return a;
  }
  

  /**
   * Comprueba si los dígitos del número introducido están en el que tenemos que
   * adivinar. Devuelve T si el número está en el que tenemos que adivinar pero 
   * no está en la posición correcta. P si el número está en la posición 
   * correcta y ? si no está.
   * 
   * @param x[] array de enteros que tenemos que adivinar
   * @param n   número entero que suponemos que es el número a adivinar
   * @return    array con información sobre la posición correcta de los dígitos
   */
  public static String[] adivinado(int[] x, int n) {
    String[] a = new String[x.length];
    int[] num = intToArray(n, x.length);
    
    // Inicializa el array suponiendo que no están los números
    for (int i = 0; i < x.length; i++) {
      a[i] = "?";
    }
    
    // Comprueba si el número introducido está en el número a adivinar
    for (int i = 0; i < x.length; i++) {
      for (int j = 0; j < x.length; j++) {
	      if (x[j] == num[i]) {
	        a[i] = "T";
	      }
      }
    }
    
    // Comprueba si el número introducido tiene los digitos en la posición
    // correcta
    for (int i = 0; i < x.length; i++) {
      if (x[i] == num[i]) {
	      a[i] = "P";
      }
    }
    
    return a;
  }
  

  /**
   * Comprueba si los elemtentos de un array son iguales al de otro
   * 
   * @param numAdivina[] array del número a adivinar
   * @param num          array del número introducido
   * @return 	     	 true o false si es igual o no
   */
  public static boolean arrayIguales(int[] numAdivina, int num ) {
    int[] n = intToArray(num, numAdivina.length);
    boolean igual = true;
    
    for (int i = 0; i < numAdivina.length; i++) {
      if (numAdivina[i] != n[i]) {
	      igual = false;
      } 
    }

    return igual;
  }
  

  /**
   * Imprime un array unidimensional de String.
   * 
   * @param x[] array de String
   * @return    contenido del array
   */
  public static void imprimeArrayString(String[] a) {
    for (String i : a) {
      System.out.print(i);
    }
  }
  

  /**
   * Imprime un array unidimensional de enteros.
   * 
   * @param x[] array de enteros
   * @return    contenido del array
   */
  public static void imprimeArrayInt(int[] a) {
    for (int i : a) {
      System.out.print(i);
    }
  }
}
