import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class Main {

	private JFrame frame;
	private JTextField xScore;
	private JTextField oScore;
	private int xCount1 = 0;
	private int oCount1 = 0;
	private String startGame= "X";
	private int bb1 = 10;
	private int bb2 = 10;
	private int bb3 = 10;
	private int bb4 = 10;
	private int bb5 = 10;
	private int bb6 = 10;
	private int bb7 = 10;
	private int bb8 = 10;
	private int bb9 = 10;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private int draw = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}
	
	//Choosing player
	private void choosePlayer() {
		if(startGame.equalsIgnoreCase("X")) {
			startGame = "O";
		}
		else {
			startGame = "X";
		}
	}
	
	
	
	//Judging winner
	private void winningGame() {
		//Player X
		if(bb1 == 1 && bb2 == 1 && bb3 == 1) {
			JOptionPane.showMessageDialog(frame, "Player X won the game" );
			xCount1++;
			xScore.setText(Integer.toString(xCount1));
			resetGame();
		}
		if(bb4 == 1 && bb5 == 1 && bb6 == 1) {
			JOptionPane.showMessageDialog(frame, "Player X won the game" );
			xCount1++;
			xScore.setText(Integer.toString(xCount1));
			resetGame();
		}
		if(bb7 == 1 && bb8 == 1 && bb9 == 1) {
			JOptionPane.showMessageDialog(frame, "Player X won the game" );
			xCount1++;
			xScore.setText(Integer.toString(xCount1));
			resetGame();
		}
		if(bb1 == 1 && bb5 == 1 && bb9 == 1) {
			JOptionPane.showMessageDialog(frame, "Player X won the game" );
			xCount1++;
			xScore.setText(Integer.toString(xCount1));
			resetGame();
		}
		if(bb3 == 1 && bb5 == 1 && bb7 == 1) {
			JOptionPane.showMessageDialog(frame, "Player X won the game" );
			xCount1++;
			xScore.setText(Integer.toString(xCount1));
			resetGame();
		}
		if(bb1 == 1 && bb4 == 1 && bb7 == 1) {
			JOptionPane.showMessageDialog(frame, "Player X won the game" );
			xCount1++;
			xScore.setText(Integer.toString(xCount1));
			resetGame();
		}
		if(bb2 == 1 && bb5 == 1 && bb8 == 1) {
			JOptionPane.showMessageDialog(frame, "Player X won the game" );
			xCount1++;
			xScore.setText(Integer.toString(xCount1));
			resetGame();
		}
		if(bb3 == 1 && bb6 == 1 && bb9 == 1) {
			JOptionPane.showMessageDialog(frame, "Player X won the game" );
			xCount1++;
			xScore.setText(Integer.toString(xCount1));
			resetGame();
		}
		
		//Player 0
		if(bb1 == 0 && bb2 == 0 && bb3 == 0) {
			JOptionPane.showMessageDialog(frame, "Player O won the game" );
			oCount1++;
			oScore.setText(Integer.toString(oCount1));
			resetGame();
		}
		if(bb4 == 0 && bb5 == 0 && bb6 == 0) {
			JOptionPane.showMessageDialog(frame, "Player O won the game" );
			oCount1++;
			oScore.setText(Integer.toString(oCount1));
			resetGame();
		}
		if(bb7 == 0 && bb8 == 0 && bb9 == 0) {
			JOptionPane.showMessageDialog(frame, "Player O won the game" );
			oCount1++;
			oScore.setText(Integer.toString(oCount1));
			resetGame();
		}
		if(bb1 == 0 && bb5 == 0 && bb9 == 0) {
			JOptionPane.showMessageDialog(frame, "Player O won the game" );
			oCount1++;
			oScore.setText(Integer.toString(oCount1));
			resetGame();
		}
		if(bb3 == 0 && bb5 == 0 && bb7 == 0) {
			JOptionPane.showMessageDialog(frame, "Player O won the game");
			oCount1++;
			oScore.setText(Integer.toString(oCount1));
			resetGame();
		}
		if(bb1 == 0 && bb4 == 0 && bb7 == 0) {
			JOptionPane.showMessageDialog(frame, "Player O won the game");
			oCount1++;
			oScore.setText(Integer.toString(oCount1));
			resetGame();
		}
		if(bb2 == 0 && bb5 == 0 && bb8 == 0) {
			JOptionPane.showMessageDialog(frame, "Player O won the game");
			oCount1++;
			oScore.setText(Integer.toString(oCount1));
			resetGame();
		}
		if(bb3 == 0 && bb6 == 0 && bb9 == 0) {
			JOptionPane.showMessageDialog(frame, "Player O won the game");
			oCount1++;
			oScore.setText(Integer.toString(oCount1));
			resetGame();
		}
		if(draw == 9) {
			JOptionPane.showMessageDialog(frame, "No one won the game");
			resetGame();
		}
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(450, 200, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 5, 2, 2));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		b1 = new JButton("");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b1.setText(startGame);
				if(startGame.equalsIgnoreCase("X")) {
					b1.setForeground(Color.RED);
					bb1 = 1;
					draw++;
				}
				else {
					b1.setForeground(Color.BLUE);
					bb1 = 0;
					draw++;
				}
				choosePlayer();
				winningGame();
			}
		});
		panel_3.add(b1, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		b2 = new JButton("");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b2.setText(startGame);
				if(startGame.equalsIgnoreCase("X")) {
					b2.setForeground(Color.RED);
					bb2 = 1;
					draw++;
				}
				else {
					b2.setForeground(Color.BLUE);
					bb2 = 0;
					draw++;
				}
				choosePlayer();
				winningGame();
			}
		});
		panel_4.add(b2, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		b3 = new JButton("");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b3.setText(startGame);
				if(startGame.equalsIgnoreCase("X")) {
					b3.setForeground(Color.RED);
					bb3 = 1;
					draw++;
				}
				else {
					b3.setForeground(Color.BLUE);
					bb3 = 0;
					draw++;
				}
				choosePlayer();
				winningGame();
			}
		});
		panel_2.add(b3, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Player 0");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		xScore = new JTextField();
		xScore.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		xScore.setText("0");
		panel_6.add(xScore, BorderLayout.CENTER);
		xScore.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		b4 = new JButton("");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b4.setText(startGame);
				if(startGame.equalsIgnoreCase("X")) {
					b4.setForeground(Color.RED);
					bb4 = 1;
					draw++;
				}
				else {
					b4.setForeground(Color.BLUE);
					bb4 = 0;
					draw++;
				}
				choosePlayer();
				winningGame();
			}
		});
		panel_7.add(b4, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		b5 = new JButton("");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b5.setText(startGame);
				if(startGame.equalsIgnoreCase("X")) {
					b5.setForeground(Color.RED);
					bb5 = 1;
					draw++;
				}
				else {
					b5.setForeground(Color.BLUE);
					bb5 = 0;
					draw++;
				}
				choosePlayer();
				winningGame();
			}
		});
		panel_5.add(b5, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		b6 = new JButton("");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b6.setText(startGame);
				if(startGame.equalsIgnoreCase("X")) {
					b6.setForeground(Color.RED);
					bb6 = 1;
					draw++;
				}
				else {
					b6.setForeground(Color.BLUE);
					bb6 = 0;
					draw++;
				}
				choosePlayer();
				winningGame();
			}
		});
		panel_13.add(b6, BorderLayout.CENTER);
		
		JPanel panel_15 = new JPanel();
		panel.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Player X");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		panel_15.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JPanel panel_14 = new JPanel();
		panel.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		oScore = new JTextField();
		oScore.setText("0");
		oScore.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		oScore.setColumns(10);
		panel_14.add(oScore, BorderLayout.CENTER);
		
		JPanel panel_12 = new JPanel();
		panel.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		b7 = new JButton("");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b7.setText(startGame);
				if(startGame.equalsIgnoreCase("X")) {
					b7.setForeground(Color.RED);
					bb7 = 1;
					draw++;
				}
				else {
					b7.setForeground(Color.BLUE);
					bb7 = 0;
					draw++;
				}
				choosePlayer();
				winningGame();
			}
		});
		panel_12.add(b7, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		b8 = new JButton("");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b8.setText(startGame);
				if(startGame.equalsIgnoreCase("X")) {
					b8.setForeground(Color.RED);
					bb8 = 1;
					draw++;
				}
				else {
					b8.setForeground(Color.BLUE);
					bb8 = 0;
					draw++;
				}
				choosePlayer();
				winningGame();
			}
		});
		panel_8.add(b8, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		b9 = new JButton("");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b9.setText(startGame);
				if(startGame.equalsIgnoreCase("X")) {
					b9.setForeground(Color.RED);
					bb9 = 1;
					draw++;
				}
				else {
					b9.setForeground(Color.BLUE);
					bb9 = 0;
					draw++;
				}
				choosePlayer();
				winningGame();
			}
		});
		panel_9.add(b9, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetGame();	
			}
		});
		panel_10.add(reset, BorderLayout.CENTER);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm you Want to Exit", "TicTacToe", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		panel_11.add(exit, BorderLayout.CENTER);
	}

	//Game reset
	private void resetGame() {
		b1.setText(null);
		b2.setText(null);
		b3.setText(null);
		b4.setText(null);
		b5.setText(null);
		b6.setText(null);
		b7.setText(null);
		b8.setText(null);
		b9.setText(null);
		bb1 = 10;
		bb2 = 10;
		bb3 = 10;
		bb4 = 10;
		bb5 = 10;
		bb6 = 10;
		bb7 = 10;
		bb8 = 10;
		bb9 = 10;
		draw = 0;
	}
	
}
