package Zbozi;

public class Test {

	public static void main(String[] args) {
		Zbozi[] pole = new Zbozi[4];
		pole[0] = new Potravina("Rohlik", 1.5, 1);
		pole[1]  = new Naradi("Kleste", 278.0, 24);
		pole[2]  = new Potravina("Chleba", 20.8,6);
		pole[3]  = new Potravina("Jablko", 51.0, 20);
				
		for (int i = 0; i < pole.length; i++) {
			if(pole[i] instanceof Potravina)
				System.out.println(pole[i].getJmeno() + " cena: "+pole[i].getCena() + " trvanlivost: "+ ((Potravina)pole[i]).getTrvanlivost() + " " + pole[i].getJednotka());

			else
				System.out.println(pole[i].getJmeno() + " cena: "+pole[i].getCena());
		}
	}
}
