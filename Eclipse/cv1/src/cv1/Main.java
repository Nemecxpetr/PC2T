package cv1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Type a number: ");
		try (Scanner sc = new Scanner(System.in)) {
			if(sc.hasNextInt()) {				//pro test cisla
				int number = sc.nextInt();		//pro vycteni cisla				
				System.out.println("Your number is " + number);					//dva zpùsoby vypisování do konzole
				System.out.printf("The number %d is divided by 1 \n", number);
				boolean isPrime = true;
				for (int i = 2; i < number; i++) {
					if(number%i==0) {
						isPrime = false;
						System.out.printf("Number %d is divisor of number %d \n", i, number);
					}
				}
				System.out.printf("Number %d is a prime number: %b \n", number, isPrime);
			}else {
				System.out.println("The provided input was not a number. The program will end. \n");
			}
		}		
	}
	
}
