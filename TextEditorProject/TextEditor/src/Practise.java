import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  //For receiving event

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;          //For button image
import javax.swing.JButton;            //For button
import javax.swing.JFrame;             //For blank frame
import javax.swing.JLabel;             

//Extends JFrame for GUI program & Implements ActionListener for handling events
public class Practise extends JFrame implements ActionListener{
	
	JButton button1 = new JButton();   //Creating JButton Object
	ImageIcon icon = new ImageIcon("/Users/htoomyataung/Desktop/icon.png");  //Creating ImageIcon Object
	ImageIcon icon2 = new ImageIcon("/Users/htoomyataung/Desktop/icon.png");
	JLabel label = new JLabel();
	
	//Constructor
	Practise(){
		//JFrame default constructor
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500, 500);      //Frame size
		this.setVisible(true);       //Frame show
		this.add(button1);           //Adding JButton in JFrame
		this.add(label);
		
		
		//Button 
        button1.setText("Click me");							 //Setting button name
        button1.setFocusable(false);                      
        button1.setFont(new Font("Comic Sans", Font.BOLD, 25));  //Setting Font, Feature and Size
        button1.setBounds(300,300,300,300);						 //Setting button size
        button1.setIcon(icon);                                   //Setting button icon
        button1.setHorizontalTextPosition(JButton.CENTER);		 //Setting text in the center of the button Horizontally
        button1.setVerticalTextPosition(JButton.BOTTOM);		 //Setting text at the bottom of the button Vertically
        button1.setForeground(Color.cyan);						 //Text color
        button1.setBackground(Color.RED);				     //Background color
        button1.addActionListener(this);                         //Register the component(button) with the Listener
        //button1.addActionListener(e -> Action) //Lambda Expression
        
        //Label
        label.setIcon(icon2);
        label.setBounds(300,300,300,300);
        label.setVisible(false);
        
	}
	
	//Abstract method of actionListener class
	//This method is invoked whenever user click on the registered component
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1) {
			label.setVisible(true);
		}
	}
}
