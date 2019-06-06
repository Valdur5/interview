package de.pandigo.tasks.stack.reversePolishNotation;

import java.util.Stack;

/**
 * THIS WOULD HAVE BEEN THE BETTER SOLUTION TO THE ReversePolishNotation problem.
 */

public class ReversePolishNotationStackImpl {

    // Regex expression to identify numbers.
    private static final String NUMBER_REGEX = "[0-9]+.*[0-9]*";

    public double evaluate(String expr) {

        // Base case for not processing further.
        if(expr == null || expr.length() == 0){
            return 0;
        }

        Stack<Double> stack = new Stack<>();

        // Create a list of input values to recursivly process.
        String[] values = expr.split(" ");
        for(int i = 0; i < values.length; i++) {
            String token = values[i];
            if(isOperator(token)) {
                Double number1 = stack.pop();
                Double number2 = stack.pop();
                stack.push(calcPrevNumbers(number2, number1, token));
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*");
    }

    // Simple helper method to calculate the result of two values based on an operation
    // that is only given as a String.
    private Double calcPrevNumbers(Double value1, Double value2, String operation) {
        switch(operation) {
            case "+":
                return value1+value2;
            case "*":
                return value1*value2;
            case "/":
                return value1/value2;
            case "-":
                return value1-value2;
        }
        return 0d;
    }
}
