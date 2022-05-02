package cz.vutbr.feec.dbconnection.db.Student;

import java.time.LocalDate;

import cz.vutbr.feec.dbconnection.db.AbstractStudent;
import cz.vutbr.feec.dbconnection.db.enums.zodiac.Zodiac;
/**
 * 
 * @author Petr Nìmec (221480)
 *
 */
public class Comb extends AbstractStudent{
/**
 * 
 * @param obor
 * @param name
 * @param surname
 * @param birthdate
 */
	public Comb(int obor, String name, String surname, LocalDate birthdate) {
		super (obor=3, name, surname, birthdate);
		this.setLeapYear();
	}
	public Comb(String name, String surname, LocalDate birthdate) {
		super (3, name, surname, birthdate);
		this.setLeapYear();
	}

	private boolean isLeapYear;	
	private Zodiac zodiac; 

	public void setLeapYear() {
		this.isLeapYear=Comb.this.getBirthdate().isLeapYear();
	}

	public boolean getLeapYear() {
		return isLeapYear;
	}

	public Zodiac getZodiac() {
		return zodiac;
	}

	public void setZodiac() {
		int day = Comb.this.getBirthdate().getDayOfMonth();
		int month = Comb.this.getBirthdate().getMonthValue();
		switch(month) {
		case 1:
			if(day<20) {zodiac=Zodiac.CAPRICORN;}
			else {		zodiac=Zodiac.AQUARIUS;}
			break;
		case 2:
			if(day<19) {zodiac=Zodiac.AQUARIUS;}
			else {		zodiac=Zodiac.PISCES;}
			break;
		case 3:
			if(day<21) {zodiac=Zodiac.PISCES;}
			else {		zodiac=Zodiac.ARIES;}
			break;
		case 4:
			if(day<20) {zodiac=Zodiac.ARIES;}
			else {		zodiac=Zodiac.TAURUS;}
			break;
		case 5:
			if(day<21) {zodiac=Zodiac.TAURUS;}
			else {		zodiac=Zodiac.GEMINI;}
			break;
		case 6:
			if(day<21) {zodiac=Zodiac.GEMINI;}
			else {		zodiac=Zodiac.CANCER;}
			break;
		case 7:
			if(day<23) {zodiac=Zodiac.CANCER;}
			else {		zodiac=Zodiac.LEO;}
			break;
		case 8:
			if(day<23) {zodiac=Zodiac.LEO;}
			else {		zodiac=Zodiac.VIRGO;}
			break;
		case 9:
			if(day<23) {zodiac=Zodiac.VIRGO;}
			else {		zodiac=Zodiac.LIBRA;}
			break;
		case 10:
			if(day<23) {zodiac=Zodiac.LIBRA;}
			else {		zodiac=Zodiac.SCORPIO;}
			break;
		case 11:
			if(day<22) {zodiac=Zodiac.SCORPIO;}
			else {		zodiac=Zodiac.SAGITTARIUS;}
			break;
		case 12:
			if(day<22) {zodiac=Zodiac.SAGITTARIUS;}
			else {		zodiac=Zodiac.CAPRICORN;}
			break;
		}
	}
}
