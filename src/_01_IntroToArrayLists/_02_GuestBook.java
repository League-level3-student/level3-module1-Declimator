package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame;
	JPanel panel;
	JButton button;
	JButton button2;
	JTextField text;
	ArrayList<String> list;
	String input;
	JLabel label;
	public static void main(String[] args) {
		_02_GuestBook guestbook = new _02_GuestBook();
		guestbook.guestbook();
	}

	public void guestbook() {
		frame = new JFrame();
		label = new JLabel();
		panel = new JPanel();
		button = new JButton();
		button2 = new JButton();
		list = new ArrayList<String>();
		frame.add(panel);
		frame.setVisible(true);
		panel.add(button);
		panel.add(button2);
		button.setText("Add Name");
		button2.setText("View Names");
		button.addActionListener(this);
		button2.addActionListener(this);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) {
			input = JOptionPane.showInputDialog("Add a Name");
			list.add(input);
		}
		else if(e.getSource() == button2) {
			for(int i = 0; i < list.size();i++) {
				label.setText(label.getText() + "      " + list.get(i));
			}
			panel.add(label);
			panel.remove(button);
			panel.remove(button2);
			frame.remove(panel);
			frame.add(panel);
			frame.pack();
			System.out.println(label.getText());
			
		}
	}

}

