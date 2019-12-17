import java.util.Scanner;

public class Juego {
  public static void main(String[] args) {
    String opcion;    //valor de entrada introducido
    Scanner s = new Scanner(System.in);
    //int[] full = {1,2,3,4,5,6,7,8};
    
    int[] arr = new int[4];
    int[] n =new int[4];;
    
    int intentos=5;
    String salida="";

    int tengo=0;
    int orden=0;
    String solucion="";

    
    //genera el numero aleatorio con todos los digitos diferentes
        
    arr[0]= (int)(Math.random()*7)+1;
    do {
      arr[1]= (int)(Math.random()*7)+1;
    } while (arr[1]==arr[0]);
    do {
      arr[2]= (int)(Math.random()*7)+1;
    } while (arr[2]==arr[1] || arr[2]==arr[0]);
    do {
      arr[3]= (int)(Math.random()*7)+1;
    } while (arr[3]==arr[2] || arr[3]==arr[1] || arr[3]==arr[0]);


    for (int i=0; i<4; i++) {
      //System.out.print(arr[i]);
      solucion=solucion+arr[i];
    }
    System.out.println(solucion);


    System.out.printf("\nMASTERMIND.\n");
    System.out.println("Adivinar un numero de 4 cifras diferentes (1-8). T: numero correcto, O: posicion correcta.");
    System.out.println("Para salir, pulse \'s\'");
    System.out.printf("%-4s", "????");



    do {
      System.out.print(" - Introduzca numero: "); 
      //num1 = s.nextInt();
      //num2 = s.nextInt();
      //num3 = s.nextInt();
      //num4 = s.nextInt();
      //s.nextLine();

      opcion = System.console().readLine();
      
      //n=Integer.parseInt(opcion);
      if (!opcion.equals("s")) {        //mete la entrada en un array
        for (int i=0; i<4; i++) {
          n[i]=(int)opcion.charAt(i)-48;
        }
      
      }
      
      //n[0]=num1;
      //n[1]=num2;
      //n[2]=num3;
      //n[3]=num4;

      for (int i=0; i<4; i++) {     //comprueba los que tengo 
        for (int j=0; j<4; j++) {
          if (arr[i]==n[j]) {
            tengo++;
          }  
        }
      }

      for (int i=0; i<4; i++) {     //comprueba si estan en orden
        if (arr[i]==n[i]) {
          orden++;
        }
      }



      if (orden==0 && tengo!=0) {         //update de la salida
        for (int i=0; i<tengo; i++) {
          salida = salida+"T";
        }
      } 
        
      if (orden>0 && orden==tengo) {
        for (int i=0; i<orden; i++) {
          salida = salida+ "O";
        }
      } 
        
      if (orden>0 && orden<tengo) {
        for (int i=0; i<orden; i++) {
          salida = salida+ "O";
        }
        for (int i=0; i<(tengo- orden); i++) {
          salida = salida+ "T";
        }
      }
           


      if (orden==4) {                     //comprueba si ganas
        System.out.println("ganaste");
        opcion="s";
      }

      if (!opcion.equals("s")) { 
        System.out.printf("%-4s", salida);
      }

      
      salida="";        //reinicia variables
      orden=0;
      tengo=0;
      intentos--;


    } while (!opcion.equals("s") && intentos>0);
  }
}