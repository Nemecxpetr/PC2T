/* tøída pro vyjímku pøi známce mimo dovolený rozsah
 */

@SuppressWarnings("serial")
public class MarkOutOfBoundsException extends Exception {
	public MarkOutOfBoundsException(String err) {
		super(err);
	}
}