import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;    //Event
import java.awt.event.ActionListener; //ActionListener interface
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;            //For creating JFrame
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;       //For creating Scroll Pane
import javax.swing.JSpinner;          //For changing font
import javax.swing.JTextArea;         //For creating TextArea
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;


public class TextEditor extends JFrame implements ActionListener {
	
	//This section is creating required objects for this project
	JButton button;
	JTextArea textArea = new JTextArea();                   //Declaring TextArea object
	JScrollPane scrollPane = new JScrollPane(textArea);		//Declaring JScrollPane object
	JSpinner fontSizeSpinner = new JSpinner();
	JLabel fontLabel = new JLabel("Font: ");                //For labeling a short string or an icon
	JButton fontColorButton = new JButton("Color");         //For changing text color
	String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();  
	JComboBox fontBox = new JComboBox(fonts);        //Creating JComBox object for a lists of font family name
	JMenuBar menuBar = new JMenuBar();               //Creating Menu Bar for a menu of items
	JMenu fileMenu = new JMenu();                    //A menu name which would appears always
	JMenuItem openItem = new JMenuItem("Open");      //Menu Items 
	JMenuItem saveItem = new JMenuItem("Save");      //Menu Items 
	JMenuItem exitItem = new JMenuItem("Exit");      //Menu Items 
	//End of object creating section
	
	
	//Constructor
	public TextEditor() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Default Constructor
		this.setTitle("Text Editor");						 //Default Constructor
		this.setSize(500, 500);								 //Default Constructor
		this.setLayout(new FlowLayout());					 //Flow Layout which is row by row components Layout
		this.setLocationRelativeTo(null);                    //To appear in the middle of the screen
		this.setVisible(true);                  			 //Making JFram visible
	  //this.add(textArea);
		this.add(menuBar);                                   //Adding MenuBar
	    this.add(fontLabel);
	    this.add(fontSizeSpinner);
	    this.add(fontColorButton);
	    this.add(fontBox);
	    this.add(scrollPane);
	    //End of constructor section
	    
		
	    // - - - - Text Area - - - -
	  //textArea.setPreferredSize(new Dimension(450, 450));  //Setting text area size
		textArea.setLineWrap(true);                          
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 20)); //Setting Font, and size
		//End of text area section
		
		
		// - - - - ScrollPane - - - -
		scrollPane.setPreferredSize(new Dimension(450, 450));
		scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//End of scroll pane section
		
		
		// - - - - Spinner for changing font - - - -
		fontSizeSpinner.setPreferredSize(new Dimension(50, 25));
		fontSizeSpinner.setValue(20);  							  //Initially set the font size 20
		fontSizeSpinner.addChangeListener(new ChangeListener() {  
			public void stateChanged(ChangeEvent e) {
				textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN,(int)fontSizeSpinner.getValue()));
			}
		});
		//End of spinner section
		
		
		// - - - - JButton for changing color in text - - - - 
		fontColorButton.addActionListener(this);              //Adding actionListener to this button
		//End of button section
		
		
		// - - - - Font box for changing box - - - - 
		fontBox.addActionListener(this); 
		fontBox.setSelectedItem("Arial");                     //Setting default font as "Arial"
		//End of ComboBox section
		
		
		// - - - - Menu Bar Section - - - -
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		
		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);
	}
	


	//An abstract of ActionListener for handling the event
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//If action is a button, do the following thing
		if(e.getSource() == fontColorButton) {                
			JColorChooser colorChooser = new JColorChooser();
			Color color = colorChooser.showDialog(null, "Choose a color", Color.black.BLACK);
			textArea.setForeground(color);
		}
		
		//If action is fontBox, do the following thing
		if(e.getSource() == fontBox) {    
			textArea.setFont(new Font((String)fontBox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
		}
		
		//If action is over a menu bar, do the following things
		//If action is open file
		if(e.getSource() == openItem) {
			JFileChooser fileChooser = new JFileChooser();      //Creating JFileChooser object
			fileChooser.setCurrentDirectory(new File("."));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
			fileChooser.setFileFilter(filter);
			
			int response = fileChooser.showOpenDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				Scanner fileIn = null;
				try {
					fileIn = new Scanner(file);
					if(file.isFile()) {
						while(fileIn.hasNextLine()) {
							String line = fileIn.nextLine() + "\n";
							textArea.append(line);
						}
					}
				}
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				finally {
					fileIn.close();
				}
				
			}
		}
		
		//If action is save file
        if(e.getSource() == saveItem) {
        	JFileChooser fileChooser = new JFileChooser();      //Creating JFileChooser object
			fileChooser.setCurrentDirectory(new File("."));
			
			int response = fileChooser.showSaveDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file;
				PrintWriter fileOut = null;
				
				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					fileOut = new PrintWriter(file);
					fileOut.println(textArea.getText());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					fileOut.close();
				}
			}
		}
        
        //If action is exit file
        if(e.getSource() == exitItem) {
			System.exit(0);
		}
	}

}
