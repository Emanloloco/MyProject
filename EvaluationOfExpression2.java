package evaluation.of.expression;

import java.util.Scanner;
import java.util.Stack;

public class EvaluationOfExpression {

    // Method to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/'|| c == '%' || c == '^';
    }

    // Method to get the precedence of operators
    private static int precedence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        }
        if (c == '*' || c == '/' || c == '%') {
            return 2;
        }
        if (c == '^')
            return 3;
        return -1;
    }

    // Infix to Postfix Conversion
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c); // Add operands (letters/numbers) to postfix expression
            } else if (c == '(') {
                stack.push(c); // Push '(' onto the stack
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()); // Pop until '(' is found
                }
                stack.pop(); // Discard '('
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop()); // Pop operators based on precedence
                }
                stack.push(c); // Push current operator to stack
            }
        }

        // Pop any remaining operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    // Infix to Prefix Conversion (Fixed)
    public static String infixToPrefix(String infix) {
        // Step 1: Reverse the infix expression and swap '(' and ')'
        StringBuilder reversedInfix = new StringBuilder();
        for (int i = infix.length() - 1; i >= 0; i--) {
            char c = infix.charAt(i);
            if (c == '(') {
                reversedInfix.append(')');
            } else if (c == ')') {
                reversedInfix.append('(');
            } else {
                reversedInfix.append(c);
            }
        }

        // Step 2: Convert the modified reversed infix to postfix
        String reversedPostfix = infixToPostfix(reversedInfix.toString());

        // Step 3: Reverse the postfix expression to get the final prefix expression
        return new StringBuilder(reversedPostfix).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean loopBreaker = true;

        while (loopBreaker) {
            // Ask the user for an infix expression
            System.out.print("Enter an infix expression: ");
            String infix = scanner.nextLine();

            System.out.println("Type '1' to convert it to prefix and '2' to convert it to postfix");
            String operationX = scanner.nextLine();
            System.out.println();
            
            switch (operationX) {
                case "1":
                    String prefix = infixToPrefix(infix); // Convert infix to prefix
                    System.out.println("Prefix: " + prefix);
                    break;
                case "2":
                    String postfix = infixToPostfix(infix); // Convert infix to postfix
                    System.out.println("Postfix: " + postfix);
                    break;
            }

            boolean validInput = true;
            
            System.out.println();

            while (validInput) {
                System.out.println("Would you like to convert another expression? Yes or No?");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("No")) {
                    System.out.println("The program is terminated!");
                    validInput = false;
                    loopBreaker = false;
                } else if (choice.equalsIgnoreCase("Yes")) {
                    validInput = false;
                    loopBreaker = true;
                } else {
                    System.out.println("You enter an invalid input!");
                }
            } System.out.println();
        }
    }
}
