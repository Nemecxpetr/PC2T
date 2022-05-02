import java.util.Comparator;

public class CompareByAverage implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		return Double.compare(s1.getPrumer(), s2.getPrumer());
	}
}
