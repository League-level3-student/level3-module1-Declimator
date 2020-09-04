package _04_HangMan;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	JFrame frame;
	JPanel panel;
	JLabel label;
	public static void main(String[] args) {
		HangMan m = new HangMan();
		m.method();
	}
	public void method() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		frame.add(panel);
		panel.add(label);
		frame.setSize(1080,512);
		frame.setVisible(true);
		String s = JOptionPane.showInputDialog("Enter a number between 1 and 266");
	}
	
}
