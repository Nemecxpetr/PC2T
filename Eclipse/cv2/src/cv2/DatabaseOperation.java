package cv2;

import java.util.Scanner;

public class DatabaseOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database [] arrayDatabase = new Database[3];
		
		try (Scanner sc = new Scanner(System.in)) {
			for(int i=0;i<arrayDatabase.length;i++)
			{
				System.out.println("Enter username:"  );
				String name = sc.next();
				System.out.println("Enter birth date:");
				String date = sc.next(); 
				arrayDatabase[i]= new Database(name, date);
			}
			System.out.println("Set max assignment:"  );
			
			Database.setMaxAssignment(sc.nextDouble());
			
			for(;;){
				System.out.println("Type database index:");
				double index = sc.nextDouble();
				if (index>arrayDatabase.length) {
					System.out.println("ERROR: Index is too high.");
					System.out.println("Try different index:"	  );
					index = sc.nextDouble();
				}
				
				System.out.println("Set new assignment:");
				double newAssignment = sc.nextDouble();
				arrayDatabase[(int) index].newAssignment(newAssignment);
				System.out.println("Name:" 		 + arrayDatabase[(int) index].getPersonName());
				System.out.println("Birth date:" + arrayDatabase[(int) index].getBirthDate() );
				System.out.println("Assignment:" + arrayDatabase[(int) index].getAssignment());
				
				if(arrayDatabase[(int) index].newAssignment(newAssignment)){
				}
				else {
					System.out.println("You have reached the maximum set value for assignment.");	

				}
				
			}
		}
	}	
}
