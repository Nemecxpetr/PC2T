import static org.junit.Assert.*;

import org.junit.Test;

public class testStipendium {

	@Test
	public void test() {
		Student student = new Student(0,"Test", "Testovací", "1.1.1980");
		try {
			student.addZnamka(1);
		} catch (MarkOutOfBoundsException e) {
			e.printStackTrace();
		}
		boolean maStipendium = student.maStipendium();
		assertEquals(true, maStipendium);
		
	}

}
