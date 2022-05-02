package main;

import javax.swing.UIManager;

import main.calculator.Calculator;

public class App {
	public static void main(String[] args){
	
	try {
        UIManager.setLookAndFeel(UIManager. getSystemLookAndFeelClassName());
    } catch (Exception e) { e.printStackTrace(); }
	
    new Calculator("Kalkulaèka");


	}
}
