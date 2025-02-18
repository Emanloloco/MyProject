import java.util.Scanner;
import java.util.Stack;

public class EvaluationOfExpression {

    // Method to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Method to get the precedence of operators
    private static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
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

    // Postfix to Infix Conversion
    public static String postfixToInfix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c)); // Push operands onto the stack
            } else if (isOperator(c)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String expression = "(" + operand1 + c + operand2 + ")";
                stack.push(expression); // Combine the operands with operator and push back to stack
            }
        }

        return stack.pop(); // The final element will be the full expression
    }

    // Prefix to Infix Conversion
    public static String prefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();

        // Traverse the prefix expression from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c)); // Push operands onto the stack
            } else if (isOperator(c)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String expression = "(" + operand1 + c + operand2 + ")";
                stack.push(expression); // Combine the operands with operator and push back to stack
            }
        }

        return stack.pop(); // The final element will be the full expression
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asking the user for an infix expression
        System.out.print("Enter an infix expression: ");
        String infix = scanner.nextLine();

        // Converting infix to postfix and prefix
        String postfix = infixToPostfix(infix);
        String prefix = infixToPrefix(infix);

        System.out.println("\nInfix: " + infix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Prefix: " + prefix);

        // Converting postfix and prefix back to infix
        System.out.println("\nPostfix to Infix: " + postfixToInfix(postfix));
        System.out.println("Prefix to Infix: " + prefixToInfix(prefix));

        scanner.close();
    }
}
