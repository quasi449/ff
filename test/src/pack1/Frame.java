package pack1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;

public class Frame extends JFrame {

	private JPanel contentPane;
	
	
	static String  selecteditem="";
	static int selectedint=-1;
	
	
	static ArrayList<Player> al= new ArrayList<Player>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Quarterback");
		chckbxNewCheckBox.setBounds(323, 26, 97, 23);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxRunningback = new JCheckBox("Running back");
		chckbxRunningback.setBounds(323, 52, 97, 23);
		chckbxRunningback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(chckbxRunningback);
		
		JCheckBox chckbxWideReciever = new JCheckBox("Wide receiver");
		chckbxWideReciever.setBounds(323, 78, 97, 23);
		chckbxWideReciever.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(chckbxWideReciever);
		
		JCheckBox chckbxKicker = new JCheckBox("Defense");
		chckbxKicker.setBounds(323, 130, 97, 23);
		chckbxKicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(chckbxKicker);
		
		JCheckBox chckbxTightEnd = new JCheckBox("Tight end");
		chckbxTightEnd.setBounds(323, 104, 97, 23);
		chckbxTightEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(chckbxTightEnd);
		
		JCheckBox checkBox = new JCheckBox("Kicker");
		checkBox.setBounds(323, 156, 97, 23);
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(checkBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 307, 506);
		contentPane.add(scrollPane);
		
		final DefaultListModel model = new DefaultListModel();
		
		final JList list = new JList(model);
		
		list.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent arg0) {
			
				int index = list.locationToIndex(arg0.getPoint());
				
				//list.getComponent(index);
				
				Object selected= list.getSelectedValue();
				
				//System.out.println(selected+" at index: "+index);
				selecteditem=selected.toString();
				selectedint=index;
			}
		});
		
		
		
		scrollPane.setViewportView(list);
		
		JButton button1 = new JButton("Player Selected");
		
		
//   PLayer selected button is pushed 		
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				
				
				
				if (selecteditem.length()>0){
					
					System.out.println(selecteditem+" "+selectedint);
				
					//model.remove(0);
					
					
					//model.add(0,title);
				}
				
			
			}
		});
		
	
//   PLayer selected button is pushed 				

		
		button1.setBounds(331, 355, 158, 23);
		contentPane.add(button1);
		
		JButton btnSort = new JButton("Sort");
		btnSort.setBounds(342, 205, 89, 23);
		contentPane.add(btnSort);
		
		
		//Object[] items = {"Aewqd", "Bwed", "Cwedw", "Dwedwed","wedweda","wedweda","wedweda","wedweda","wedweda","wedweda","wedweda","wedweda","wedweda","Dwedwed","Dwedwed","Dwedwed","Dwedwed","Dwedwed","Dwedwed","wedweda","wedweda","wedweda","wedweda","wedweda","wedweda","wedweda","wedweda","wedweda","wedweda","wedweda","wedwedddddddddddddddddddddddddddddddddwed13ed32eqd13wqdwqda"};
		
		Player.parseFile("file.txt");
		
		//ArrayList<String> arr= Player.sort(Frame.al,"wr");
		
		Object[] items=al.toArray();
		
		for (int i=0; i<items.length; i++) {
		    model.add(i, items[i]);
		}
		
		int pos = list.getModel().getSize();
		
		//model.add(0, "RANK  NAME  TEAM  POS  BYE");
	//	model.add(1, "------------------------------------------");
		
		
		
	}
}
