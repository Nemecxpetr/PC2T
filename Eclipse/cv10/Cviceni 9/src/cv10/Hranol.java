package cv10;

public class Hranol extends Ctverec{ //TODO 02 fixed to Ctverec

	// konstruktor se zadanim delky hrany, vysky a materialu
	Hranol(float podstava,float vyska, boolean drevena){
		//TODO 03 add super(podstava)
		super(podstava);
		this.hrana=vyska;
		zeDreva=drevena;
		pocetHranolu++;
	}
	
	// vypocet objemu hranolu
	float vypoctiObjem() {
		 // TODO 12 hrana pøepsána na výšku -> hrana*hrana nahrazeno vypoctiObsah
		return this.hrana*vypoctiObsah();	
	}
	
	// nastaveni materialu
	void setDreveny(boolean dreveny){
		zeDreva=dreveny;
	}
	
	// zjisteni materialu
	boolean jeDreveny(){
		return zeDreva;
	}
	
	// zjisteni celkoveho poctu existujicich kostek
	static int getPocetHranolu(){
		return pocetHranolu;
	}
	
	// zjisteni vysky hranolu
	@Override
	float getHrana(){					
		return this.hrana;
	}
	// nastaveni vysky hranolu
	@Override
	void setHrana(float delka){			
		this.hrana=delka;
	}
		
	private float hrana;
	boolean zeDreva;
	//TODO 04 change pocetHranolu to static
	//TODO 05 add initial value to pocetHranolu=0
	static int pocetHranolu=0;	
	
	
}
