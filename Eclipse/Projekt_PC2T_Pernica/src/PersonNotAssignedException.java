/* t��da pro vyj�mku p�i pr�m�ru == 0
 */

@SuppressWarnings("serial")
public class PersonNotAssignedException extends Exception {
	public PersonNotAssignedException(String err) {
		super(err);
	}
}
	