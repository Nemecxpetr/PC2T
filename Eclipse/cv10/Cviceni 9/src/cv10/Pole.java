package cv10;

import java.util.Scanner;
import static java.lang.Float.MAX_VALUE;

public class Pole {

	// Konstruktor s velikosti pole
	Pole(int velikost)
	{
		mojeHranoly=new Hranol[velikost];
		sc=new Scanner(System.in);
	}
	
	// vlozeni hranolu do pole na prvni volnou pozici
	void zadejHranol(){
		boolean drevena=false;
		float delka=0;
		float vyska=0;
		
		System.out.println("Zadejte delku podstavy hranolu");
		while(!sc.hasNextFloat())
		{
			sc.next();
		}
		delka=sc.nextFloat();
		System.out.println("Zadejte vysku hranolu");
		while(!sc.hasNextFloat())
		{
			sc.next();
		}
		vyska=sc.nextFloat();
		System.out.println("Je drevena?");
		// TODO 06 hasNextFloat nahrazeno hasNextBoolean
		while(!sc.hasNextBoolean())
		{
			sc.next();
		}
		drevena=sc.nextBoolean();
		// TODO 09 > nahrazeno >=
		if (Hranol.getPocetHranolu()>=mojeHranoly.length) 
		{
			System.out.println("Pole uz je zaplneno");
			return;
		}
		
		// TODO 07 zápis nového hranolu
		mojeHranoly[Hranol.getPocetHranolu()] = new Hranol(delka,vyska,drevena);
		

	}
	
	// vypis objemu vsech hranolu
	void vypoctiObjem()
	{
		for (int i=0;i<Hranol.getPocetHranolu();i++)
			// TODO 08 místo vypostiObjem bylo vypoctiObsah + výpis o kolikátý hranol jde (vypisovalo "i.")
			System.out.println("Objem "+ (i+1) + ". hranolu je " + mojeHranoly[i].vypoctiObjem());		
	}
	
	// vypis obsahu podstavy vsech hranolu
	void vypoctiObsahPodstavy()
	{
		for (int i=0;i<Hranol.getPocetHranolu();i++)
			// TODO 11 místo vypoctiObsah bylo vypostiObjem + výpis o kolikátý hranol jde (vypisovalo "i."
			System.out.println("Obsah podstavy "+ (i+1) + ". hranolu je " +mojeHranoly[i].vypoctiObsah());
			// System.out.println("Povrch " + i + ". hranolu je " + mojeHranoly[i].vypoctiPovrch());
	}
	
	// nalezeni indexu nejmensiho hranolu
	int najdiNejmensiObjem()
	{
		float min= MAX_VALUE;									
		int idx=0;										
		for (int i=0;i<Hranol.getPocetHranolu();i++)
		{
			if (mojeHranoly[i].vypoctiObjem()<min){
				min=mojeHranoly[i].vypoctiObjem();
				idx=i;
			}
		}
		return idx;
	}
	
	// zjisteni celkoveho poctu drevenych kostek
	int zjistiPocetDrevenych(){
		int pocetDrevenych=0;
		// TODO 10 místo "i=1" "i=0" i<=mojeHranoly.length, i++, zeDreva==true
		for (int i=0;i<mojeHranoly.length;i++)					
		{
			if (mojeHranoly[i].zeDreva==true)				
				pocetDrevenych++;
		}
		return pocetDrevenych;
	}

	private Scanner sc;
	private Hranol [] mojeHranoly;
}
