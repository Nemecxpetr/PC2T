package cv10;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int velikostPole = 3;
			Pole pole = new Pole(velikostPole);
			for(int i=0; i<velikostPole; i++)
				pole.zadejHranol();
			pole.vypoctiObjem();
			pole.vypoctiObsahPodstavy();
			pole.zjistiPocetDrevenych();
			pole.najdiNejmensiObjem();
			
			System.out.println("Nejmen�i objem m� " + (pole.najdiNejmensiObjem()+1)+". hranol.");
		    System.out.println("Po�et d�ev�n�ch hranol�: "+ pole.zjistiPocetDrevenych());

		    pole.zadejHranol();
		    pole.vypoctiObjem();
		    pole.vypoctiObsahPodstavy();
			
	}

}
