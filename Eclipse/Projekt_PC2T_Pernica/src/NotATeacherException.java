/* t��da pro vyj�mku p�i pr�m�ru == 0
 */

@SuppressWarnings("serial")
public class NotATeacherException extends Exception {
	public NotATeacherException(String err) {
		super(err);
	}
}
	