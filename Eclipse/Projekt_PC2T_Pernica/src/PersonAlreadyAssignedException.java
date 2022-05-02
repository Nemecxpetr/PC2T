/* tøída pro vyjímku pøi prùmìru == 0
 */

@SuppressWarnings("serial")
public class PersonAlreadyAssignedException extends Exception {
	public PersonAlreadyAssignedException(String err) {
		super(err);
	}
}
	