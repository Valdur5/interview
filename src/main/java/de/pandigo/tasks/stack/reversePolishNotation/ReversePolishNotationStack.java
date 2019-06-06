package de.pandigo.tasks.stack.reversePolishNotation;

public class ReversePolishNotationStack {

    private static ReversePolishNotationStackImpl reversePolishNotation = new ReversePolishNotationStackImpl();

    public static void main(String [] args) {

        // This represents 5 + ((1+2)*4) - 3 = 14
        System.out.println(reversePolishNotation.evaluate("5 1 2 + 4 * + 3 -"));

        // The stack would do:
        // 5
        // 5 1
        // 5 1 2
        // 5 3 (+)
        // 5 3 4
        // 5 12 (*)
        // 17 (+)
        // 17 3
        // 14 (-)
    }
}
