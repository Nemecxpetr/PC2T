package Priklad;

import java.util.Scanner;

public class DatabaseOperation {
	public static void main(String [] argv)
	{
		int pocetOsob=3;
		Database[] databazeOsob=new Database[pocetOsob];
		Scanner sc=new Scanner(System.in);
		for (int i=0;i<pocetOsob;i++)
		{
			System.out.print("Zadejte jmeno osoby c." + (i+1) + ":");
			String jmeno=sc.next();
			while(true)
			{		
				System.out.print("rok narozeni:");
				if (sc.hasNextInt())
					break;
				sc.next();
			}
			int rocnik=sc.nextInt();
			databazeOsob[i]=new Database(jmeno,rocnik);
		}
		
		while(true)
		{
			System.out.print("Zadejte maximalni vysi uvazku: ");
			if (sc.hasNextFloat())
			{
				Database.setMaximalniUvazek(sc.nextFloat());
				break;
			}
			sc.next();
		}
		
		while(true)
		{
			System.out.print("Zadejte cislo osoby a vysi uvazku: ");
			if (!sc.hasNextInt())
			{
				System.out.println("Nezadali jste spravne cislo osoby!!!");
				sc.next();
				continue;
			}
			int cislo=sc.nextInt()-1;
			if (cislo<0||cislo>=pocetOsob)
			{
				System.out.println("Cislo osoby mimo rozsah databze");
				continue;
			}
			if (!sc.hasNextFloat())
			{
				System.out.println("Nezadali jste spravne vysi uvazku!!!");
				sc.next();
				continue;
			}
			float uvazek=sc.nextFloat();
			System.out.print(databazeOsob[cislo].getJmeno() +" "+ databazeOsob[cislo].getRocnik());
			if (databazeOsob[cislo].pridejUvazek(uvazek))
				System.out.println(" uvazek zvysen na " + databazeOsob[cislo].getUvazek());
			else
				System.out.println(" uvazek nelze zvysit");
		}
	}
	
}
