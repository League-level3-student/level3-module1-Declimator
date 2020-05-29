package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> stack = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		Double x;
		for(int i = 0; i < 100; i++) {
			x = (double) new Random().nextInt();
			stack.push(x);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String y = JOptionPane.showInputDialog("Enter two numbers between 0 and 100");
		int y2 = Integer.parseInt(y);
		String z = JOptionPane.showInputDialog("Enter two numbers between 0 and 100");
		int z2 = Integer.parseInt(z);
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		for(int i = 0; i < stack.capacity(); i++) {
			System.out.println(i);
			if(y2>=z2) {
				if(stack.get(i)>= y2 && stack.get(i) <= z2) {
					System.out.println(stack.pop());
				}
				else {
					stack.pop();
				}
			}
			else if (y2<z2){
				if(stack.get(i)>= z2 && stack.get(i) <= y2) {
					System.out.println(stack.pop());
				}
				else {
					stack.pop();
				}
			}
		}
		
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
