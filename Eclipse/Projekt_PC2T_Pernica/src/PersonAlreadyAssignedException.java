/* t��da pro vyj�mku p�i pr�m�ru == 0
 */

@SuppressWarnings("serial")
public class PersonAlreadyAssignedException extends Exception {
	public PersonAlreadyAssignedException(String err) {
		super(err);
	}
}
	