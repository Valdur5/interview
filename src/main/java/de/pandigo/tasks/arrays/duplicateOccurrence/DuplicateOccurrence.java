package de.pandigo.tasks.arrays.duplicateOccurrence;

import java.util.Arrays;

public class DuplicateOccurrence {

    private static DuplicateOccurrenceImpl duplicateOccurrence = new DuplicateOccurrenceImpl();

    public static void main(String [] args) {
        System.out.println("Solution with MAP, Result should be 6, Result: "+duplicateOccurrence.findOddDuplicateMap(Arrays.asList(1, 1, 4, 5, 4, 5, 6 ,4, 4)));

        System.out.println("Solution with SET, Result should be 6, Result: "+duplicateOccurrence.findOddDuplicateSet(Arrays.asList(1, 1, 4, 5, 4, 5, 6 ,4, 4)));

    }
}
