/* tøída pro vyjímku pøi prùmìru == 0
 */

@SuppressWarnings("serial")
public class AverageNotSetException extends Exception {
	public AverageNotSetException(String err) {
		super(err);
	}
}
	