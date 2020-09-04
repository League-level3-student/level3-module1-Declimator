package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 *
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	JFrame frame;
	JPanel panel;
	JLabel label;
	String undolist;

	public static void main(String[] args) {
		_02_TextUndoRedo method = new _02_TextUndoRedo();
		method.method();
	}

	public void method() {
		undolist = "";
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setSize(500, 100);
		frame.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		char s = 'a';
		char a = 'a';
		String stringone = "";
		String stringtwo = "";
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if (label.getText().length() == 0) {

			} else {

				a = label.getText().charAt(label.getText().length() - 1);
				stringtwo = undolist;
				undolist = stringtwo + a;
				System.out.println(undolist);
				for (int i = 0; i < label.getText().length() - 1; i++) {
					s = label.getText().charAt(i);
					stringtwo = stringone;
					stringone = stringtwo + s;
				}
				label.setText(stringone);
			}
		} else if (arg0.getKeyCode() == KeyEvent.VK_SHIFT) {
			if (undolist.length() == 0) {

			} else {
				label.setText(label.getText() + undolist.charAt(undolist.length()-1));
				if(undolist.length()==1) {
					undolist = "";
				}
				else {
				for (int i = 0; i < undolist.length()-1; i++) {
					stringtwo += undolist.charAt(i);
				}
				undolist = stringtwo;
				}
				System.out.println(undolist);
			}
		} else {
			label.setText(label.getText() + arg0.getKeyChar());
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}
