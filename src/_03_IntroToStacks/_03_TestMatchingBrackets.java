package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		int n = 0;
		Stack<String> stack = new Stack<String>();
		String z = "";
		for(int i = 0; i < b.length(); i++) {
			z += b.charAt(i);
			stack.push(z);
			z = "";
		}
		System.out.println(stack);
		while(!stack.isEmpty()) {
			if(stack.peek().equals("{")) {
				stack.pop();
				n-=1;
			}
			else if(stack.peek().equals("}")){
				n+=1;
				stack.pop();
			}
			if(n < 0) {
				return false;
			}
		}
		if(n == 0) {
			return true;
		}
		return false;
	}

}