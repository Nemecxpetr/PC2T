/* t��da pro vyj�mku p�i pr�m�ru == 0
 */

@SuppressWarnings("serial")
public class AverageNotSetException extends Exception {
	public AverageNotSetException(String err) {
		super(err);
	}
}
	