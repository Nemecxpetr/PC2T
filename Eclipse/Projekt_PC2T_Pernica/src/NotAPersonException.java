/* t��da pro vyj�mku p�i pr�m�ru == 0
 */

@SuppressWarnings("serial")
public class NotAPersonException extends Exception {
	public NotAPersonException(String err) {
		super(err);
	}
}
	