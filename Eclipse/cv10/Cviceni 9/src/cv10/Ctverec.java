package cv10;

class Ctverec {

	protected float hrana;
	// vypocet obsahu ctverce
	int vypoctiObsah(){					
		return (int)(hrana*hrana);		
	}
	// zjisteni delky hrany ctverce
	float getHrana(){					
		return hrana;
	}
	// nastaveni delky hrany ctverce
	void setHrana(float delka){			
		hrana=delka;
	}
	// konstruktor se zadanim delky hrany ctverce
	Ctverec(float hrana){	
		//TODO 01 hrana changed to this.hrana
		this.hrana=hrana;	
	}
}
