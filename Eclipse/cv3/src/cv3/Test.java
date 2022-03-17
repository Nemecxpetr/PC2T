package cv3;

import java.util.Scanner;
import java.util.Vector;

public class Test {

	public static void main(String[] args) {
		
		Vector<Subject> vector = new Vector<Subject>();
		
		
		try (// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in)){
			
			//Setting in points from BPC1
			System.out.println("BPC1");
			BPC1 petr = new BPC1();			
			System.out.println("Set activity points (max 20): ");
			petr.setActivityPoints(sc.nextDouble());
			System.out.println("Set exam points (max 80): ");
			petr.setExamPoints(sc.nextDouble());
			
			vector.add(petr);
			
			
			System.out.println("Now you will type in information about class BPC2.");
			BPC2 petr1 = new BPC2();
			System.out.println("Set project points (max 30): ");
			petr1.setProjectPoints(sc.nextDouble());
			System.out.println("Set points from half semester test (max 20): ");
			petr1.setHalfExamPoints(sc.nextDouble());
			System.out.println("Set final exam points (max 50): ");
			petr1.setFinalExamPoints(sc.nextDouble());
			
			vector.add(petr1);
			
			BPIS petr2 = new BPIS();
			System.out.println("Does Alex has credit? (true/false) ");
			petr2.setCredit(sc.nextBoolean()); 
			
			vector.add(petr2);
						
			System.out.flush();
			
			System.out.println("TEST RESULTS");
			for(Subject s : vector) {
				System.out.println("Subject:"+s.getName());
				System.out.println("Points:"+s.getPoints());
				System.out.println("Evaluation:"+s.getEval());

			}
		}
		
	}

}
