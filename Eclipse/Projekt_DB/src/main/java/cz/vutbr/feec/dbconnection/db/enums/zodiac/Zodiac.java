package cz.vutbr.feec.dbconnection.db.enums.zodiac;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

/**
 * 
 * @author Petr Nìmec (221480)
 * 
 */

public enum Zodiac {
		
		CAPRICORN("Capricorn",
				(LocalDate.of(Year.now().getValue(), Month.DECEMBER, 22)),
				(LocalDate.of(Year.now().getValue(), Month.JANUARY, 19)),
				"Serious, independent, disciplined and tenacious"),
		AQUARIUS("Aquarius",
				(LocalDate.of(Year.now().getValue(), Month.JANUARY, 20)),
				(LocalDate.of(Year.now().getValue(), Month.FEBRUARY, 18)),
				"Deep, imaginative, original and uncompromising"),
		PISCES("Pisces",
				(LocalDate.of(Year.now().getValue(), Month.FEBRUARY, 19)),
				(LocalDate.of(Year.now().getValue(), Month.MARCH, 20)),
				"Affectionate, empathetic, wise and artistic"),
		ARIES("Aries",
				(LocalDate.of(Year.now().getValue(), Month.MARCH, 21)),
				(LocalDate.of(Year.now().getValue(), Month.APRIL, 19)),
				"Eager, dynamic, quick and competitive"
				),
		TAURUS("Taurus",
				(LocalDate.of(Year.now().getValue(), Month.APRIL, 20)),
				(LocalDate.of(Year.now().getValue(), Month.MAY, 20)),
				"Strong, dependable, sensual and creative"),
		GEMINI("Gemini",
				(LocalDate.of(Year.now().getValue(), Month.MAY, 21)),
				(LocalDate.of(Year.now().getValue(), Month.JUNE, 20)),
				"Versatile, expressive, curious and kind"),
		CANCER("Cancer",
				(LocalDate.of(Year.now().getValue(), Month.JUNE, 21)),
				(LocalDate.of(Year.now().getValue(), Month.JULY, 22)),
				"Intuitive, sentimental, compassionate and protective"),
		LEO("Leo",
				(LocalDate.of(Year.now().getValue(), Month.JULY, 23)),
				(LocalDate.of(Year.now().getValue(), Month.AUGUST, 22)),
				"Dramatic, outgoing, fiery and self-assured"),
		VIRGO("Virgo",
				(LocalDate.of(Year.now().getValue(), Month.AUGUST, 23)),
				(LocalDate.of(Year.now().getValue(), Month.SEPTEMBER, 22)),
				"Practical, loyal, gentle and analytical"),
		LIBRA("Libra",
				(LocalDate.of(Year.now().getValue(), Month.SEPTEMBER, 23)),
				(LocalDate.of(Year.now().getValue(), Month.OCTOBER, 22)),
				"Social, fair-minded, diplomatic and gracious"),
		SCORPIO("Scorpio",
				(LocalDate.of(Year.now().getValue(), Month.OCTOBER, 23)),
				(LocalDate.of(Year.now().getValue(), Month.NOVEMBER, 21)),
				"Passionate, stubborn, resourceful and brave"),
		SAGITTARIUS("Sagittarius",
				(LocalDate.of(Year.now().getValue(), Month.NOVEMBER, 22)),
				(LocalDate.of(Year.now().getValue(), Month.DECEMBER, 21)),
				"Extroverted, optimistic, funny and generous");
			
	  int year = 2000;
	  private String internalName;
	  private String description;
	  private LocalDate beginning;
	  private LocalDate end;
	  
	  
	  
	  private Zodiac(String internalName, LocalDate beginning, LocalDate end, String description){
		this.internalName=internalName;
	    this.description = description;
	    this.beginning = beginning;
	    this.end = end;
	  }

	public LocalDate getBeginning() {
		return beginning;
	}

	public LocalDate getEnd() {
		return end;
	}

	public String getDescription() {
	    return description;
	  }

	
	public String getInternalName() {
		return internalName;
	}
}
