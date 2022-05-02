package main.calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Calculator extends JFrame {

	JButton btnAdd, btnSubtract, btnEquals;
    JButton numBtn[];
    JLabel output;
    String previous, current, operator;
    
    public void updateOutput() {
        output.setText(current);
    }
    
    public void selectOperator(String newOperator) {
        // if no number is entered yet
        if (current.isEmpty()) {
            operator = newOperator;
            return;
        }

        if (!previous.isEmpty()) {
            calculate();
        }

        operator = newOperator;
        previous = current;
        current = "";
    }
    
    public void calculate() {
        if (previous.length() < 1 || current.length() < 1) {
            return;
        }
        double result = 0.0;
        double num1 = Double.parseDouble(previous);
        double num2 = Double.parseDouble(current);
        switch (operator) {
           case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            default:
                break;
        }
        current = String.valueOf(result);
        operator = null;
        previous = "";
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        	
            JButton selectedBtn = (JButton) e.getSource();
            //Number buttons
            for (JButton btn : numBtn) {
                if (selectedBtn == btn) {
                	current += btn.getText();
                    updateOutput();
                }
            }
            //Add button
            if (selectedBtn == btnAdd) {
                selectOperator(btnAdd.getText());
            }
            //Subtract button
            else if (selectedBtn == btnSubtract) {
                selectOperator(btnSubtract.getText());
            } 
            //Equals button
            else if (selectedBtn == btnEquals) {
                calculate();
            }
            updateOutput();
        }
    }
	
	public Calculator(String title){
		
		// Initializing the calculator operands
        current = "";
        previous = "";    
        
		//set up frame
		JFrame mojeOkno=new JFrame();
		mojeOkno.setSize(350,178);
		mojeOkno.setTitle(title);
		mojeOkno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//button panel
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout( 3,  4));
		
		//Set up text field	
		output = new JLabel();
		output.setText("Výsledek ...");
		output.setHorizontalAlignment(SwingConstants.RIGHT);
		
		// Instantiate action listeners
        ButtonHandler buttonHandler = new ButtonHandler();
		
		// Initialize, style, and add action listeners to number buttons
        numBtn = new JButton[11];
        
        for (int i = 0; i < numBtn.length - 1; i++) {
            numBtn[i] = new JButton(String.valueOf(i));
            numBtn[i].addActionListener(buttonHandler);
            p1.add(numBtn[i]);
        }
				    	
		btnAdd=new JButton("+");
		btnAdd.addActionListener(buttonHandler);
		p1.add(btnAdd);
		    	
		btnSubtract=new JButton("-");
		btnAdd.addActionListener(buttonHandler);
		p1.add(btnSubtract);

		
		btnEquals=new JButton("=");
		btnEquals.addActionListener(buttonHandler);
			/*TitledBorder b1=new TitledBorder(" ");
		    	p1.setBorder(b1);*/
				
			//Position all components
			mojeOkno.setLayout(new BorderLayout());
			mojeOkno.getContentPane().add(output,BorderLayout.NORTH);
			mojeOkno.getContentPane().add(p1,BorderLayout.CENTER);
			mojeOkno.getContentPane().add(btnEquals,BorderLayout.SOUTH);
			mojeOkno.setVisible(true);		
	}
}
