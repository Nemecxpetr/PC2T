/* t��da pro vyj�mku p�i zn�mce mimo dovolen� rozsah
 */

@SuppressWarnings("serial")
public class MarkOutOfBoundsException extends Exception {
	public MarkOutOfBoundsException(String err) {
		super(err);
	}
}