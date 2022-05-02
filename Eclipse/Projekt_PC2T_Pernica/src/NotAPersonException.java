/* tøída pro vyjímku pøi prùmìru == 0
 */

@SuppressWarnings("serial")
public class NotAPersonException extends Exception {
	public NotAPersonException(String err) {
		super(err);
	}
}
	