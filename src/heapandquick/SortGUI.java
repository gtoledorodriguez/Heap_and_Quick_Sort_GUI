package heapandquick;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import heapandquick.Session;

public class SortGUI extends JFrame implements ActionListener {
	// height of the frame
	private static final int DEFAULT_HEIGHT = 584;
	// width of the frame.
	private static final int DEFAULT_WIDTH = 751;
	// creating the panel
	private JPanel panel;
	// These are the buttons (insertion, merge, and reset)
	private JButton btnInsertion;
	private JButton btnMerge;
	private JButton btnReset;
	// Output messages to the user
	private JLabel messageToUser;
	// numbers is the unsorted array of random values
	private JTextArea numbers;
	// numbers2 is where the sorted steps will be shown
	private JTextArea numbers2;
	// numbesr3 will make numbers2 scrollable
	private JScrollPane numbers3;
	// session is the current Session that is running
	private Session session;
	/**
	 * Constructor
	 * @param thisSession is the session that is running on this GUI
	 */
	public SortGUI(Session thisSession) {
		// setting the session
		session = thisSession;
		// setting the GUI to close on exit
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// initializing the display
		initDisplay();
		// repainting the display
		repaint();
	}
	/**
	 * display displays the pane
	 */
	public void display() {
		// Making a new runnable event
		java.awt.EventQueue.invokeLater(new Runnable() {
			// Setting the pane visible
			public void run()
			{
				setVisible(true);
			}
		});
	}
	
	// Setting some colors to be used later
	Color darkGray = new Color(139, 138, 140);
	Color lightGray = new Color(186, 186, 186);
	Color red = new Color(247, 204, 187);
	
	/**
	 * repaint() will repaint the pane every time it is called
	 */
	public void repaint() {
		// This is the message that will be displayed to the user. It is called on the sesion
		messageToUser = new JLabel(session.getMessage());
		// Adding the message to the panel
		panel.add(messageToUser);
		// Setting the font
		messageToUser.setFont(new Font("Tacoma", Font.BOLD, 20));
		// Making it visible
		messageToUser.setOpaque(true);
		// Setting the font color
		messageToUser.setForeground(Color.white);
		// Setting the background color
		messageToUser.setBackground(darkGray);
		// Setting its position
		messageToUser.setBounds(56, 424, 600, 30);
		
		// numbers is set to the random numbers array generated in Session
		//numbers = new JTextArea(session.getNumbers());
		// Adding the array to the panel
		panel.add(numbers);
		// Setting the font
		numbers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		// Making it visible
		numbers.setOpaque(true);
		numbers.setBounds(54, 41, 667, 46);
		// Making it not editable
		numbers.setEditable(false);
		// Setting its position
		
		// lblUnsorted is the label for the unsorted array
		JLabel lblUnsorted = new JLabel("Unsorted: ");
		// Adding the label to the panel
		panel.add(lblUnsorted);
		// Setting the font
		lblUnsorted.setFont(new Font("Tahoma", Font.PLAIN, 13));
		// Setting the position
		lblUnsorted.setBounds(54, 10, 100, 41);
		
		// Making the empty numbers2 textArea
		numbers2 = new JTextArea();
		// Adding the textArea to the panel
		panel.add(numbers2);
		// Setting its position
		numbers2.setBounds(56, 99, 600, 281);
		// Making it not editable
		numbers2.setEditable(false);
		
		// Making the scrollable pane
		numbers3 = new JScrollPane(numbers2);
		// Adding it to the panel
		panel.add(numbers3);
		// Setting its position
		numbers3.setBounds(78, 99, 557, 281);
		
		// Packing to make everything visible
		pack();
	}
	/**
	 * initDisplay() displays the initial display
	 */
	private void initDisplay() {
		// panel is the frame
		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
		// Setting the layout and preferred size
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		
		// Making the reset button
		btnReset = new JButton("Reset");
		// Addint the action listener
		btnReset.addActionListener(new ActionListener() {
			// setting the event to be performed
			public void actionPerformed(ActionEvent e) {
				// getting the new random unsorted array
				//numbers.setText(session.getNumbers());
				// emptying the TextArea
				numbers2.setText("");
				// getting the new message to the user
				messageToUser.setText(session.getMessage());
			}
		});
		// Making the reset button invisible in the initial display
		btnReset.setVisible(false);
		// Setting its position
		btnReset.setBounds(314, 544, 85, 21);
		// Setting the font color
		btnReset.setForeground(darkGray);
		// Setting the background color
		btnReset.setBackground(red);
		// Addint the button to the panel
		panel.add(btnReset);
		
		// Making the insertion button
		btnInsertion = new JButton();
		// Addint a listener
		btnInsertion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Upon clicking the insertion button, the reset button becomes visible
				btnReset.setVisible(true);
			}
		});
		// Setting the text
		btnInsertion.setText("Insertion");
		// Adding it to the panel
		panel.add(btnInsertion);
		// Setting its position
		btnInsertion.setBounds(239, 464, 100, 30);
		// Setting the font color
		btnInsertion.setForeground(darkGray);
		// Setting the background color
		btnInsertion.setBackground(red);
		// Adding the action listener
		btnInsertion.addActionListener(new ActionListener() {
			// The event to be performed
			public void actionPerformed(ActionEvent evt) {
				// sortedSeq is the ArrayList containing an array that represents each step in the insertion sort
				// It is calculated in session
				//ArrayList<int[]> sortedSeq = session.insertion();
				// s is the display string
				String s = "";
				// This runs through the sortedSeq array
				/*
				for (int i = 0; i < sortedSeq.size(); i++) {
					int[] n = sortedSeq.get(i);
					// Adding each array
					for (int j = 0; j < sortedSeq.get(i).length; j++) {
						// Adding each value of each array 
						s = s + String.valueOf(n[j]);
					}
					// New line after each array
					s = s +"\n";
					// Setting the text
					numbers2.setText(s);
				}	
				*/
				// Updating the message to the user
				messageToUser.setText(session.getMessage());
			}
		});
		
		btnMerge = new JButton();
		btnMerge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ArrayList sortedSeq = session.merge();
				String s = "";
				/*
				for(int i = 0; i<sortedSeq.size(); i++) {
					s = s + sortedSeq.get(i);
					//System.out.println("I: " + i);
				}*/
				//System.out.println("sortedSeq.size()-1: " + (sortedSeq.size()-1));
				//s = s + "\n\nSorted Array: \n" + sortedSeq.get(sortedSeq.size()-1);
				numbers2.setText(s);
				//ArrayList<String> msAL2 = session.merge();
				messageToUser.setText(session.getMessage());
			}
		});
		btnMerge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnReset.setVisible(true);
			}
		});
		btnMerge.setText("Merge");
		btnMerge.setForeground(darkGray);
		btnMerge.setBackground(red);
		btnMerge.setBounds(366, 464, 100, 30);
		panel.add(btnMerge);
		
		// Adding the panel to the content pane
		getContentPane().add(panel);
		getRootPane().setDefaultButton(btnInsertion);
		// Setting the panel visible
		panel.setVisible(true);
	}
	public void actionPerformed(ActionEvent evt) {
		// repaint the panel
		repaint();
	}
	
}
