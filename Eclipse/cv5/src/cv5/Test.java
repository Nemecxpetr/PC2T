package cv5;

//import java.util.Vector;

public class Test {

	public static void main(String[] args) {
		
		//Vector<Goods> vector = new Vector<Goods>();
		
		//int items=4;
		
		//filling the array
		Goods[] goods = new Goods[] {
				new Food("Rohlík", 1.5, 1),  
				new Tool("Klešte", 278, 24), 
				new Food("Chleba", 20.8, 6),
				new Food("Jablko", 51, 20), 	
		};
		
		/*
		goods[0]=new Food("Rohlík", 1.5, 1);
		goods[1]=new Tool("Klešte", 278, 24);
		goods[2]=new Food("Chleba", 20.8, 6);
		goods[3]=new Food("Jablko", 51, 20);
		*/
		
		/*//adding array field to vector do vector
		for(int i=0; i<=items; i++) {
			vector.add(goods[i]);
		}
		*/
		
		//Printing the list
		for(int i=0; i<goods.length; i++) {
			//Is it food or tool?
			if(goods[i] instanceof Food) {
				System.out.println(goods[i].getName()+", cena: "+goods[i].getPrize()+", trvanlivost: "+((Food) goods[i]).getExpiration()+goods[i].getUnit());
			}
			else if(goods[i] instanceof Tool){
				System.out.println(goods[i].getName()+", cena: "+goods[i].getPrize());
			}
		}
	}
}
