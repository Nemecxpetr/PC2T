import java.util.Comparator;

public class CompareByNoOfStudents implements Comparator<Ucitel>{
	@Override
	public int compare(Ucitel u1, Ucitel u2) {
		return Integer.compare(u1.getStudents().size(), u2.getStudents().size());
	}
}
