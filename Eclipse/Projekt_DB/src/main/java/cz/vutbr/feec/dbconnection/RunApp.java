package cz.vutbr.feec.dbconnection;

import java.time.LocalDate;
import java.time.Month;
//import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import cz.vutbr.feec.dbconnection.db.AbstractStudent;
import cz.vutbr.feec.dbconnection.db.Student.Comb;
import cz.vutbr.feec.dbconnection.db.Student.Human;
import cz.vutbr.feec.dbconnection.db.Student.Technic;

/**
 * 
 * @author Petr NÏmec (221480)
 *@
 */
public class RunApp {//TODO asi to nestihnu, ale ölo by k tomu dodÏlat hezkÈ GUI

  public static void main(String[] args) {
	  
    Scanner sc = new Scanner(System.in);
    List<AbstractStudent> listOfStudents = createEmptyList();
        
    int choice = 0;
    
   ConsoleInput.switchMenu(choice, sc, listOfStudents);

  }

private static List<AbstractStudent> createEmptyList() {
	
	AbstractStudent s1 = new Technic("Petr", "NÏmec",  LocalDate.of(1999, Month.OCTOBER, 31));
    AbstractStudent s2 = new Technic("Ond¯ej", "KubÌËek",  LocalDate.of(2001, Month.FEBRUARY, 12));
    AbstractStudent s3 = new Human("Alena", "Muchov·",  LocalDate.of(1998, Month.JULY, 6));
    AbstractStudent s4 = new Human("Petra", "Slan·",  LocalDate.of(2002, Month.NOVEMBER, 10));
    AbstractStudent s5 = new Comb("Ivo", "äùastn˝",  LocalDate.of(1980, Month.MAY, 23));
    AbstractStudent s6 = new Comb("Lajla", "Petruci",  LocalDate.of(2005, Month.FEBRUARY, 9));
    AbstractStudent s7 = new Comb("Pavel", "Smrk",  LocalDate.of(1976, Month.JULY, 25));
    return Arrays.asList(s1, s2, s3, s4, s5, s6, s7);
    
}
}
