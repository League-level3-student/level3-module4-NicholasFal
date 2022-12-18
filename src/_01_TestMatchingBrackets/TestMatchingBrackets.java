package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack<Character> myStack = new Stack<Character>();
    	for(int i = 0; i < b.length(); i++) {
    		if(b.charAt(i) == '{') {
    			myStack.push('{');
    		} else if(b.charAt(i) == '}' && !myStack.isEmpty()) {
    			myStack.pop();
    		}
    	}
        boolean idk = false;
    	if(myStack.empty()) {
        	idk = true;
        }
    	return idk;
    }
}