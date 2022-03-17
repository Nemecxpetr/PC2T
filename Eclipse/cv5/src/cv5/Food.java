package cv5;

public class Food extends Goods{
	private int expiration;
	
	public Food(String name, double prize, int expiration) {
		super(name, prize);
		this.expiration=expiration;
	}
	public int getExpiration() {
		return expiration;
	}
	public void setExpiration(int expiration) {
		this.expiration = expiration;
	}
    @Override
    public String getUnit() {
        if (expiration == 1) {
            return " den";
        }
        else if (expiration > 1 && expiration < 5) {
            return " dny";
        }
        else {
            return " dnù";
        }
    }
	
	
}
