

import java.util.Scanner;

/**
 * ALGORITMO Calcular la serie -3^0 + 1^1/5 - 7^1 + 2^1/11 - 13^3 + 5^1/17 - 19^8 + 13^1/23+..
 * */
public class Serie {

	public static void main(String[] args) {
//		Declaraciones
		Scanner l = new Scanner(System.in);
//		Varibles
		int limite;
		boolean esPrimo;
		int contador;
		int primero;
		int segundo;
		int fibo;
		int genNum;
		int signo;
		double suma;
//		Captura de datos
		System.out.println("Ingrese el # de terminos: ");
		limite=l.nextInt();
//		calculos	
		contador=0; primero=0; segundo=1; fibo=0; genNum=2; signo=-1; suma=0;
		while (contador < limite) {
			//Primos
			genNum=genNum+1;
			int contadorPri = 2;
			esPrimo=true;
			while ((esPrimo) && (contadorPri!=genNum)){
			    if (genNum % contadorPri == 0){
			    		esPrimo = false;
			    }
			    contadorPri++;
			}
			
			if(esPrimo==true){
				contador = contador +1;
				if(contador ==1){
					fibo=primero;
				}
				else if(contador ==2 ){
					fibo = primero + segundo;
				}
				else{
					fibo = primero + segundo;
					primero = segundo;
					segundo =fibo;
				}
				if(signo==-1){//Exponente
					System.out.printf("%d^%d\n", genNum*signo,fibo);
					suma = suma + Math.pow(genNum, fibo);
				}else{ //Radical
					suma = suma + Math.pow(fibo, 1.0/genNum);
					System.out.printf("%d^1/%d\n", fibo*signo,genNum);
				}
				signo = signo * -1;	
			}
		}
		System.out.printf("S = %f", suma);
	}
}

