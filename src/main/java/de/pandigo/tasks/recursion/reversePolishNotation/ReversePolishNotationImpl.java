package de.pandigo.tasks.recursion.reversePolishNotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePolishNotationImpl {

    // Regex expression to identify numbers.
    private static final String NUMBER_REGEX = "[0-9]+.*[0-9]*";

    public double evaluate(String expr) {

        // Base case for not processing further.
        if(expr == null || expr.length() == 0){
            return 0;
        }

        // Create a list of input values to recursivly process.
        List<String> inputValuesAsList = new ArrayList<>(Arrays.asList(expr.split(" ")));

        // Let the recursion compute the end result.
        return calc(inputValuesAsList);
    }

    public double calc(List<String> inputValues) {
        // Base case, if the list is only 1 element big return it.
        if(inputValues.size() == 1) {
            return Double.parseDouble(inputValues.get(0));
        }
        // If there are more elements contained, go until a not number character is found.
        for(int i = 0; i < inputValues.size(); i++) {
            if(!inputValues.get(i).matches(NUMBER_REGEX)) {
                // When a no number character is found, the previous two numbers are the base for the
                // calculation.
                String result = calcPrevNumbers(inputValues.get(i-2), inputValues.get(i-1), inputValues.get(i));
                // Replace the i-2 value with the new result, so the result stays relevant.
                inputValues.set(i-2, result);
                // Remove the second value and the operator, since we have already the result.
                inputValues.remove(i);
                inputValues.remove(i-1);
                // Pass the modified list in the recursive function.
                return calc(inputValues);
            }
        }
        // If there was no operators in the in put, this case is reached. Here we just return the
        // last value in the list.
        return Double.parseDouble(inputValues.get(inputValues.size()-1));
    }

    // Simple helper method to calculate the result of two values based on an operation
    // that is only given as a String.
    private String calcPrevNumbers(String value1, String value2, String operation) {
        Double value1Double = Double.parseDouble(value1);
        Double value2Double = Double.parseDouble(value2);
        switch(operation) {
            case "+":
                return String.valueOf(value1Double+value2Double);
            case "*":
                return String.valueOf(value1Double*value2Double);
            case "/":
                return String.valueOf(value1Double/value2Double);
            case "-":
                return String.valueOf(value1Double-value2Double);
        }
        return "0";
    }
}
