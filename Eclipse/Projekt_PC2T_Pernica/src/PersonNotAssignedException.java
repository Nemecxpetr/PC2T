/* tøída pro vyjímku pøi prùmìru == 0
 */

@SuppressWarnings("serial")
public class PersonNotAssignedException extends Exception {
	public PersonNotAssignedException(String err) {
		super(err);
	}
}
	