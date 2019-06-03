package de.pandigo.tasks.reversePolishNotation;

public class ReversePolishNotation {

    private static ReversePolishNotationImpl reversePolishNotation = new ReversePolishNotationImpl();

    public static void main(String [] args) {
        // This represents 5 + ((1+2)*4) - 3 = 14
        System.out.println(reversePolishNotation.evaluate("5 1 2 + 4 * + 3 -"));
    }
}
