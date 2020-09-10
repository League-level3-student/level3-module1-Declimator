package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan {
	JFrame frame;
	JPanel panel;
	JLabel label;
	String word;
	String word3;
	String wrong = " ";
	String right = " ";
	String visual = " ";
	int remaining;
	int lives = 3;
	Stack<String> wordslist = new Stack<String>();
	Utilities u = new Utilities();

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
		frame.setSize(300, 100);
		frame.setVisible(true);
		Start();
		getString();
		while (wordslist.isEmpty() != true || remaining > 0) {
			if (remaining == 0) {
				visual = " ";
				right = " ";
				wrong = " ";
				getString();
			}
			guess(JOptionPane.showInputDialog("guess a letter"));
			if (lives == 0) {
				int j = JOptionPane.showConfirmDialog(null, "GAME OVER! Play Again?");
				if(j == 0) {
					Start();
				}
				break;
			}
		}
		if (lives > 0) {
			System.out.println("YOU WIN!");
		}
	}

	public void getString() {
		word = wordslist.pop();
		System.out.println(word);
		remaining = word.length();
		for (int i = 0; i < word.length(); i++) {
			visual = visual + "_ ";
			label.setText(visual);
		}
	}

	public void guess(String guess) {
		if (wrong.contains(guess) || right.contains(guess)) {
			JOptionPane.showMessageDialog(null, "You already guessed that.");
		} else {
			if (word.contains(guess)) {
				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) == guess.charAt(0)) {
						visual = visual.substring(0, 2 * i + 1) + word.charAt(i) + visual.substring(2 * i + 2);
						remaining--;
					}
				}
				right = right + " " + guess;
				label.setText(visual);
			} else {
				wrong = wrong + " " + guess;
				lives--;
				JOptionPane.showMessageDialog(null, "Incorrect, Lives Remaining: " + lives);
			}
		}
	}
	public void Start() {
		String s = JOptionPane.showInputDialog("Enter a number between 1 and 266");
		int words = Integer.parseInt(s);
		for (int i = 0; i < words; i++) {
			word3 = u.readRandomLineFromFile("dictionary.txt");
			while (wordslist.contains(word3)) {
				word3 = u.readRandomLineFromFile("dictionary.txt");
			}
			wordslist.push(word3);
		}
	}
}
