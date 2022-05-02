package cz.vutbr.feec.dbconnection.db.Student;

import java.time.LocalDate;


import cz.vutbr.feec.dbconnection.db.AbstractStudent;
/**
 * 
 * @author Petr Nìmec (221480)
 *
 */
public class Technic extends AbstractStudent{
/**
 * 
 * @param name
 * @param surname
 * @param birthdate
 */
	public Technic(String name, String surname, LocalDate birthdate) {
		super(1, name, surname, birthdate);
		this.setLeapYear();
	}

	private boolean isLeapYear;

	/**
	 * Sets the special student ability to determine if the year of their birth is a leap year
	 * @see java.time.LocalDate
	 */
	public void setLeapYear() {
		this.isLeapYear=Technic.this.getBirthdate().isLeapYear();
	}

	public boolean getLeapYear() {
		return isLeapYear;
	}
}