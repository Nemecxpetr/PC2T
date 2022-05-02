import java.util.Comparator;

public class CompareByAlphabet implements Comparator<Osoba> {
	@Override
	public int compare(Osoba o1, Osoba o2) {
		return o1.getPrijmeni().compareToIgnoreCase(o2.getPrijmeni());
	}
}