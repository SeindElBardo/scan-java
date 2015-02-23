package myScanner;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Mi clase Scan es una evolución de Scanner, a menudo es necesario evaluar los valores que escriben los usuarios,
 * no siempre vale cualquier cosa o más bien, no siempre el usuario pone lo que debe poner, y cuando él la caga, el programa
 * explota.
 * Scan evalua todos los valores y además ahorra las chorripoyadas del scanner sc = new blablablabla.
 * Dudo que sea más optimo, pero sera mucho más limpio y comodo de picar.
 * Nota: Usar esta clase anula poder meter varios datos a capon.
 */
public class Scan {
	static boolean controlling = true;//Permite a scan pedir entrada hasta que sea correcta
	static Scanner sc;//Variable auxiliar donde comprobaremos que el dato es correcto antes de devolverlo
	
    public static void rango (double aux, double min, double max)throws ExceptionIntervalo{//Para comprobar los rangos y que no me metan ni cosas raras ni numeros invalidos
        if((aux<min)||(aux>max)){
            throw new ExceptionIntervalo();
        }
    }
    
    public static boolean esAcotadoI (int num, int minimo){
    	return(num>=minimo);
    }
    
    public static boolean esAcotadoM (int num, int maximo){
    	return(num<=maximo);
    }
    
    public static boolean dEsAcotadoI (double num, double minimo, boolean infimo){
    	if(num>minimo){
    		return true;
    	}
    	else if(num==minimo && infimo){
    		return true;
    	}
    	return false;
    }
    
    public static boolean dEsAcotadoM (double num, double maximo, boolean supremo){
    	if(num<maximo){
    		return true;
    	}
    	else if(num==maximo && supremo){
    		return true;
    	}
    	return false;
    }

    //Ints
    public static int nextInt (){//Scanea ints de forma segura
    	int aux = 0;
		while (controlling){						
			try{
				sc = new Scanner(System.in);
				aux = sc.nextInt();
				return aux;			
			}
			catch(InputMismatchException ex){
				System.out.println("El número debe ser un entero, introduce un número correcto");
			}
		}
		
		return aux;
    }
    
    public static int nextIntAcotadoI (int minimo){//Scanea un int acotado inferiormente siempre coge la cota
    	int num = 0;
    	while(controlling){
        	num = nextInt();
        	if(esAcotadoI(num, minimo)){
        		return num;
        	}
        	else{
        		System.out.println("El número esta por debajo de la cota, mete un número correcto");
        	}
    	}
    	return num;
    }
    
    public static int nextIntAcotadoM (int maximo){
    	int num = 0;
    	while(controlling){
        	num = nextInt();
        	if(esAcotadoM(num, maximo)){
        		return num;
        	}
        	else{
        		System.out.println("El número esta por encima de la cota, mete un número correcto");
        	}
    	}
    	return num;
    }
    
    public static int nextInt_Intervalo (int min, int max){//Scanea ints en un intervalo
    	int num = 0;
		while (controlling){		
			try{
				sc = new Scanner(System.in);
				num = sc.nextInt();
				rango(num, min, max);				
				return num;		
			}
			catch(InputMismatchException ex){
				System.out.println("Creia que sabias lo que era un número entero");
				System.out.println("Intentalo otra vez anda");
			}
			catch(ExceptionIntervalo ex){
				System.out.println("Si tu respuesta esta en el intervalo lógico de mi pregunta estaria genial");
			}
		}
		return num;
    }
    
    
    /*ROTO
    public static double nextDouble_Intervalo(double min, double max, boolean infimo, boolean supremo){//Scanea doubles en un intervalo
    	double aux = 0;

		while (controlling){
			
			
			try{
				Scanner sc = new Scanner(System.in);
				aux = sc.nextDouble();
				rango(aux, min, max);
				return aux;
			
			
			}
			catch(InputMismatchException ex){
				System.out.println("Creia que sabias lo que era un número entero");
				System.out.println("Intentalo otra vez anda");
			}
			catch(ExceptionIntervalo ex){
				System.out.println("Si tu respuesta esta en el intervalo lógico de mi pregunta estaria genial");
			}
			
		}
		return aux;
    }
    
	*/

    //Doubles
    public static double nextDouble (){//Scanea Doubles de forma segura
    	double num = 0;
		while (controlling){			
			try{
				sc = new Scanner(System.in);
				num = sc.nextDouble();
				return num;			
			}
			catch(InputMismatchException ex){
				System.out.println("Creia que sabias lo que era un número real");
				System.out.println("Intentalo otra vez anda");
			}
		}
		return num;
    }

    public static double nextDoubleAcotadoI (double minimo, boolean infimo){//Scanea un double acotado inferiormente. HACER PARA SUPERIOr, INTERVALO ACOTADO Y LO MISMO PARA INTS
    	double num = 0;
    	while(controlling){
        	num = nextDouble();
        	if(dEsAcotadoI(num, minimo, infimo)){
        		return num;
        	}	
        	else{
        		System.out.println("El número esta por debajo de la cota, mete un número correcto");
        	}
    	}
    	return num;
    }
    
    public static double nextDoubleAcotadoM (double maximo, boolean supremo){//Scanea un double acotado inferiormente. HACER PARA SUPERIOr, INTERVALO ACOTADO Y LO MISMO PARA INTS
    	double num = 0;
    	while(controlling){
        	num = nextDouble();
        	if(dEsAcotadoM(num, maximo, supremo)){
        		return num;
        	}	
        	else{
        		System.out.println("El número esta por debajo de la cota, mete un número correcto");
        	}
    	}
    	return num;
    }    
    
    //Strings
    //ESTE METODO HABRIA QUE MODIFICARLO PARA QUE RECOGIERA CUALQUIER COSA DEL ARRAY
    public static char charConcreto (char [] aceptados){//Recoge un char y lo acepta solo si pertenece al array de aceptados
    	char respuesta;
    	while(controlling){
        	respuesta = next().charAt(0);
        	for(int ii = 0; ii<aceptados.length; ii++){
        		if(respuesta == aceptados[ii]){
        			return aceptados[ii];
        		}
        		
        	}
        	System.out.println("Tu caracter no es válida, introduce una entrada correcta por favor");
    	}
    	return aceptados[0];
    }
    
    public static boolean preguntaSN (String pregunta){//hace una pregunta de si o no, 's' es si, y cualquier otra cosa no.
    	System.out.println(pregunta + "s/n");
    	if(nextStringConcreto("s", false)){
    		return true;
    	}
    	return false;
    }
    
    public static String next (){//Recoger un String facilmente
    	sc = new Scanner(System.in);
		String respuesta = sc.next();
		return respuesta;
    }
    
    public static String nextText (){//Recoger un texto facilmente
    	sc = new Scanner(System.in);
		String respuesta = sc.nextLine();
		return respuesta;
    }
    
    public static String[] nextMultiple (){//Recoger varios Strings. Este metodo puede dar problemas si pretendes usarlo repetidamente en un mismo array
    	String aux = nextText();
    	String delimitadores= " ";
    	String[] palabrasSeparadas = aux.split(delimitadores);
    	return palabrasSeparadas;
    }
    
    public static boolean nextStringConcreto (String a, boolean importanMayus){
    	if(importanMayus){
    		return(next().equals(a));
    	}
		return(next().equalsIgnoreCase(a));
    }	

}
