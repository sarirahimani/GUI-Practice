package gui2;
/*@author Sahara Karima Mosin Rahimani


 This GUI has three text fields, one for
 the initial amount of a savings account,
 one for the annual interest rate and one 
 for a number of years. It has a “Calculate!”
 button and a read-only text area to display 
 the balance per year. It has 3 labels to 
 prompt the user for input one for the 
 initial amount, one for the interest rate 
 and one for the number of years.
It has 3 panels for layout organization. 

From what is entered from the user the program calculates the interest
( interest = initial amount(1 + rate *time)). 
The output for proper two-digit money display for that it uses String.format(). 
If the format of the input is not appropriate or is negative it shows an error
by using JOptionPane.
 */
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;


public class GUI2 extends JFrame implements ActionListener {

	//ActionListener is part of Event-Driven programming
	//The GUI is always listening for events.
	//The GUI is in a permanent loop of listen - respond - listen
	
	//widgets - textfields, buttons, labels, textarea, panel
	
	//data fields
	private JLabel balLabel,intLabel,timeLabel;
	private JTextField balInput,intInput,timeInput;
	private JPanel inPanel,outPanel, mainPanel;
	private JButton calc;
	private JTextArea output;
	
	private double time;
	private double rate;
	private double interest;
	private double balance;
	public GUI2() {
		//create widgets, add action listeners and initialize variables
		balLabel = new JLabel("Enter your initial balance:");
		intLabel = new JLabel("Interest rate:");
		timeLabel = new JLabel("Time:");
		
		calc=new JButton("Calculate!");
		calc.addActionListener(this);
		
		balInput = new JTextField(15);
		balInput.addActionListener(this);
		
		intInput = new JTextField(15);
		intInput.addActionListener(this);
		
		timeInput = new JTextField(15);
		timeInput.addActionListener(this);
		//set panel layouts
		inPanel = new JPanel();
		inPanel.setLayout(new GridLayout(4,1));
	
		outPanel = new JPanel();
		outPanel.setLayout(new FlowLayout());
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		output=new JTextArea(10,30);
		
		time=0;
		rate=0;
		interest=0;
		balance=0;
		
	
		//place panels and widgets
		inPanel.add(balLabel);
		inPanel.add(balInput);
		inPanel.add(intLabel);
		inPanel.add(intInput);
		inPanel.add(timeLabel);
		inPanel.add(timeInput);
		inPanel.add(calc);
		
		outPanel.add(new JScrollPane(output));
	
		mainPanel.add(inPanel);
		mainPanel.add(outPanel);
		this.add(mainPanel);
		
	}
	/*if an action occurs it gets input 
	 and calculates interest and if an 
	 error occurs and error message is displayed.*/
	public void actionPerformed(ActionEvent actEvent) {
			try {
				String  initialBal= balInput.getText();
				balance=Double.parseDouble(initialBal);
				
				String  intRate= intInput.getText();
				rate=Double.parseDouble(intRate);
				
				String yrs= timeInput.getText();
				time=Double.parseDouble(yrs);
				
				if(balance<0 || time<0 || rate<0) {
					JOptionPane.showMessageDialog(null, "Negative numbers are not a valid input");
				}else {
					
					output.append(String.format("Initial balance: %.2f \n",balance));
					for(double i=1;i<=time;i++) {
						interest=(1+(i*rate))*balance;
						output.append(String.format("Interest: %.2f in year %.0f \n", interest,i)); 
					}
				}
				
				}catch(NumberFormatException numFormEx) {
					JOptionPane.showMessageDialog(null, "Not valid input");
				}
}
	
	

	public static void main(String[] args) {

		//call to the contructor to create the object
		GUI2 gui = new GUI2();
		
		//GUI behaviours
		gui.setVisible(true); //can see the GUI
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //this is what the x button 
		gui.setSize(500,350);  //default size of GUI in pixels, width,height
		gui.setTitle("Here is GUI2");  //title on the Windows
		//gui.setResizable(false);
	}



}
