/* tøída pro vyjímku pøi prùmìru == 0
 */

@SuppressWarnings("serial")
public class NotATeacherException extends Exception {
	public NotATeacherException(String err) {
		super(err);
	}
}
	