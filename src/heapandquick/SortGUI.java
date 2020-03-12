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

public class SortGUI extends JFrame implements ActionListener{
	// height of the frame
	private static final int DEFAULT_HEIGHT = 584;
	// width of the frame.
	private static final int DEFAULT_WIDTH = 751;
	// creating the panel
	private JPanel panel;
	// These are the buttons (insertion, merge, and reset)
	private JButton btnHeap;
	private JButton btnQuick;
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
		session.randomNumbers();
		numbers = new JTextArea(session.getNumbersString());
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
		// Adding the action listener
		btnReset.addActionListener(new ActionListener() {
			// setting the event to be performed
			public void actionPerformed(ActionEvent e) {
				// getting the new random unsorted array
				//numbers.setText(session.getNumbers());
				// emptying the TextArea
				session.randomNumbers();
				numbers.setText(session.getNumbersString());
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
		// Adding the button to the panel
		panel.add(btnReset);
		
		// Making the insertion button
		btnHeap = new JButton();
		// Adding a listener
		btnHeap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Upon clicking the insertion button, the reset button becomes visible
				btnReset.setVisible(true);
			}
		});
		// Setting the text
		btnHeap.setText("Heap");
		// Adding it to the panel
		panel.add(btnHeap);
		// Setting its position
		btnHeap.setBounds(239, 464, 100, 30);
		// Setting the font color
		btnHeap.setForeground(darkGray);
		// Setting the background color
		btnHeap.setBackground(red);
		// Adding the action listener
		btnHeap.addActionListener(new ActionListener() {
			// The event to be performed
			public void actionPerformed(ActionEvent evt) {
				// s is the display string
				String s = HeapSort.heapsort(session.getNumbers());
				// This runs through the sortedSeq array
				
				numbers2.setText(s);
				// Updating the message to the user
				messageToUser.setText(session.getMessage());
			}
		});
		
		btnQuick = new JButton();
		btnQuick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// s is the display string
				String s = "";
				QuickSort qs = new QuickSort(session.getNumbers());
				long sTime = System.nanoTime();
				qs.sort();
				long eTime = System.nanoTime();
				s = qs.toString()+"\nTotal Time: " + (eTime-sTime) + "ns";
				numbers2.setText(s);
				// Updating the message to the user
				messageToUser.setText(session.getMessage());
			}
		});
		btnQuick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnReset.setVisible(true);
			}
		});
		btnQuick.setText("Quick");
		btnQuick.setForeground(darkGray);
		btnQuick.setBackground(red);
		btnQuick.setBounds(366, 464, 100, 30);
		panel.add(btnQuick);
		
		// Adding the panel to the content pane
		getContentPane().add(panel);
		getRootPane().setDefaultButton(btnHeap);
		// Setting the panel visible
		panel.setVisible(true);
	}
	public void actionPerformed(ActionEvent evt) {
		// repaint the panel
		repaint();
	}
	
}
