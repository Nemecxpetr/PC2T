package cv5;

public class Tool extends Goods{
	private int warranty;
;
	public Tool(String name, int prize, int warranty) {
		super(name, prize);
		this.warranty=warranty;
	}

	public int getWarant() {
		return warranty;
	}

	public void setWarant(int zaruka) {
		this.warranty = zaruka;
	}

    @Override
    public String getUnit() {
        if (warranty == 1) {
            return " m�s�c";
        }
        else if (warranty > 1 && warranty < 5) {
            return " m�s�ce";
        }
        else {
            return " m�s�c�";
        }
    }

}
