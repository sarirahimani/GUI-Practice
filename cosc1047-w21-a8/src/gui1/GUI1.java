package gui1;
/*@author Sahara Karima Mosin Rahimani.

 This GUI computes the statistics of numbers that the user inputs.
 The GUI has a text field and a button to add doubles. It has
 a label for the input and the output and it also has a panel
 for the layout organization. Each time a number is entered 
 the label displays the current max, min and average of the numbers.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI1 extends JFrame implements ActionListener {

	//ActionListener is part of Event-Driven programming
	//The GUI is always listening for events.
	//The GUI is in a permanent loop of listen - respond - listen
	
	//widgets - textfields, buttons, labels, textarea, panel
	
	//data fields
	private JLabel numLabel, outLabel;
	private JTextField input;
	private JPanel panel;
	private JButton calc;
	private int count;
	private double sum;
	private double avg;
	private double max;
	private double min;
	
	public GUI1() {
		
		//create widgets, add action listeners and initialize the variables.
		numLabel = new JLabel("Enter a number:");
		outLabel = new JLabel("");
		
		calc=new JButton("Calculate!");
		calc.addActionListener(this);
		
		input = new JTextField(15);
		input.addActionListener(this);
		
		panel = new JPanel();
		
		sum=0;
		count=0;
		avg=0;
		max=0;
		min=0;
		
		//set panel layout
		panel.setLayout(new GridLayout(4,1) );
		
		//place panel and widgets
		panel.add(numLabel);
		panel.add(input);
		panel.add(calc);
		panel.add(outLabel);
		add(panel);

	}
	//if an action occurs it gets input and it calculates the average, gets max and min.
	public void actionPerformed(ActionEvent actEvent) {
		String num = input.getText();
		double number=Double.parseDouble(num);
		
		if(count==0) {
			max=number;
			min=number;
		}
		
		count++;
		
		sum = sum+number;
		avg=sum/count;
		
		if(number>max) {
			max=number;
		}if(number<min) {
			min=number;
		}
		
		outLabel.setText("The max is: "+max+". The min is: "+min+". The avg is: "+avg);
		
		
	}
	
	

	public static void main(String[] args) {

		//call to the contructor to create the object
		GUI1 gui = new GUI1();
		
		//GUI behaviours
		gui.setVisible(true); //can see the GUI
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //this is what the x button 
		gui.setSize(500,250);  //default size of GUI in pixels, width,height
		gui.setTitle("Here is GUI1");  //title on the Windows
		//gui.setResizable(false);
	}



}

