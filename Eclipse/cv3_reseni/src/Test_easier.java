import java.util.Scanner;

//@author Pavol Harar

public class Test_easier {
	
	private static int getInt(Scanner input) {
		try
		{
		   input.hasNextInt();
		   int x = input.nextInt();
		   input.nextLine();
		   return x;
		   
		}catch(Exception e)
		{
			System.out.println("Prosím zadávejte jenom èíssla:");
			input.nextLine();
			return getInt(input);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BPC1 a = new BPC1();
		BPC2 b = new BPC2();
		BPIS c = new BPIS();
		
		// PREDMET BPC1
		
		System.out.println(a.getName() + " | Zadejte bodové hodnocení­ cvièení­ (max.20):");
		do{	
			a.setTutorialPoints(getInt(input));
		} while (a.problem);
		
		System.out.println(a.getName() + " | Zadejte bodové hodnocení­ závìreèné zkoušky (max.80):");
		do{	
			a.setFinalExamPoints(getInt(input));
		} while (a.problem);
		
		
		// PREDMET BPC2
		
		System.out.println(b.getName() + " | Zadejte bodové hodnocení­ projektu (max.30):");
		do{	
			b.setProjectPoints(getInt(input));
		} while (b.problem);
		
		System.out.println(b.getName() + " | Zadejte bodové hodnocení­ pùlsemestrální­ zkoušky (max.20):");
		do{	
			b.setHalfExamPoints(getInt(input));
		} while (b.problem);
		
		System.out.println(b.getName() + " | Zadejte bodové hodnocení­ závìreèné zkoušky (max.50):");
		do{	
			b.setFinalExamPoints(getInt(input));
		} while (b.problem);
		
		
		// PREDMET BPIS
		
		System.out.println(c.getName() + " | Zadejte bodové hodnocení­ pøedmìtu (max.100):");
		do{	
			c.setPoints(getInt(input));
		} while (c.problem);
		
		a.getEval();
		b.getEval();
		c.getEval();
		
		System.out.println("Konec programu");
		
		input.close();
	}


}
