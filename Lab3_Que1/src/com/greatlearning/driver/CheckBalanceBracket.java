package com.greatlearning.driver;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Piyush
 * 
 */
// Approach-1.
// Basic Logic:-
// 1. Take Brackets-Input in the form of String
// 2. Convert the String into Character Array and store in Array.
// 3. If the length of array is odd, then brackets incomplete, hence unbalanced ->return false
// 4. Iterate the Array using while loop.
//    (i)  If opening braces encountered -> push into a stack. 
//    (ii) Check if stack is empty -> return false... unbalanced else step->(iii)
//    (iii) If closing braces encountered -> pop and store it in variable
// 5. (a) if pop element is other than combination required -> unbalanced - return false
//    (b) if pop element is combination required -> break -switch statements... continue while loop
// 6. Finally after while loop iteration complete
//       =>(i)  if stack empty -> return true ...Balanced
//       =>(ii) if stack not-empty -> return false ...Unbalanced

public class CheckBalanceBracket {

	// Function to check if bracket is balanced
	boolean checkBracketBalance(String expression) {
		Stack<Character> stack = new Stack<Character>();
		char[] charArray = expression.toCharArray();
		int j = 0;
		int charArrayLength = charArray.length;

		if (charArrayLength % 2 != 0) // no.of String input is odd...
			return false;

		while (j < charArrayLength) {
			char character = charArray[j];
			if (character == '[' || character == '{' || character == '(') {
				stack.push(character);
				j++;
				continue;
			} else if (stack.isEmpty())
				return false;
			else {
				char checkChar;
				switch (character) {
				case '}':
					checkChar = stack.pop();
					if (checkChar == '(' || checkChar == '[') // if pop element not '{'
						return false;
					break;

				case ')':
					checkChar = stack.pop();
					if (checkChar == '{' || checkChar == '[') // if pop element not ')'
						return false;
					break;

				case ']':
					checkChar = stack.pop();
					if (checkChar == '{' || checkChar == '(') // if pop element not '['
						return false;
					break;
				}
			}
			j++;
		}
		// Reach here if stack becomes empty after iterating till last element
		if (stack.isEmpty()) // if stack is empty
			return true;   
		return false;       // if stack is not empty
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		CheckBalanceBracket balanceTree = new CheckBalanceBracket();
		System.out.println("Enter the expression to check for balanced bracket");
		String expression = scanner.next();
		scanner.close();
		boolean checkBrackBalance = balanceTree.checkBracketBalance(expression);
		if (checkBrackBalance) {
			System.out.println("Balanced");
		} else
			System.out.println("Not Balanced");
	}

}
