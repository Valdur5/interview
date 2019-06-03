package de.pandigo.tasks.strings.longestCharSequence;

import java.util.*;

public class LongestCharSequences {

    public static void main(String[] args) {

        // This input string should produce 3 sub strings
        // abaabccaabbbacb    ddeffffed     xzyyzxzzxy
        String inputString = "abaabccaabbbacbddeffffedxzyyzxzzxy";

        // The input as an String array.
        String[] inputChars = inputString.split("");

        // A set to keep track which characters are still open
        Set<String> pendingCharacters = new HashSet<>();

        // The result list of sub strings.
        List<String> subStringResult = new ArrayList<>();

        // A varibale to keep track where we need to
        int startIndex = 0;

        // Step 1 parse the last character occurrence into a hash map O(n)
        Map<String, Integer> lastCharacterPositionMap = new HashMap<>();
        for(int i = 0; i < inputChars.length; i++) {
            lastCharacterPositionMap.put(inputChars[i], i);
        }

        // Step 2 go over the string and decide where to create substrings.
        for(int i = 0; i < inputChars.length; i++) {
            String currentChar = inputChars[i];
            if(lastCharacterPositionMap.get(currentChar) == i) {
                // We reached the last character
                pendingCharacters.remove(currentChar);
                if (pendingCharacters.isEmpty()) {
                    subStringResult.add(inputString.substring(startIndex, i+1));
                    startIndex = i+2;
                }
            } else {
                // If it is not the last character of this time add it to the pendingCharacter set so we know
                // that this character still needs to be closed.
                pendingCharacters.add(currentChar);
            }

        }

        subStringResult.forEach(System.out::println);


    }
}
