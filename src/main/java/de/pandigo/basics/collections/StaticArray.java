package de.pandigo.basics.collections;

import java.util.Arrays;

public class StaticArray {

    public static void main(String[] args) {

        // ============== INIT ==============

        String[] tenElementStringArray = new String[10]; // It needs a size without it is an error.
        int[] unsortedIntArray = new int[] {1, 5, 2, 4, 1, 4, 10, 1}; // It can be initialized with values and without a size.
        int[] nullArray = null; // Can be initialized as null as well.

        // ============== ASSIGN AND READ AND LENGTH ==============

        // Array length operation
        for(int i = 0; i < tenElementStringArray.length; i++) {
            // Assign value
            tenElementStringArray[i] = "Number " + i;
        }

        // Read value
        System.out.println(tenElementStringArray[5]);

        // ============== EDGE CASES ==============

        try {
            // Access out of the defined size
            System.out.println(tenElementStringArray[10]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index array[10] produces IndexOutOfBoundsException");
        }

        try {
            // Null check still exists for those kind of arrays.
            System.out.println(nullArray.length);
        } catch (NullPointerException e) {
            System.out.println("Can be also null.");
        }

        // ============== SORTING ==============

        // Dual-Pivot Quicksort, normal performance O(n log n)
        Arrays.sort(unsortedIntArray);

        // Array length operation
        for(int i = 0; i < unsortedIntArray.length; i++) {
            // Output the sorted values
            System.out.println(unsortedIntArray[i]);
        }

        // ============= EXTEND THE ARRAY SIZE =============

        // One option is Arrays.copyOf() method.
        tenElementStringArray = Arrays.copyOf(tenElementStringArray, 20);
        // Now the access to the address 10 does not thrown an exception anymore, it just returns null (the value of field 10).
        System.out.println("Element on address 10 after resizing: "+tenElementStringArray[10]);

        // Another approache is the System.arraycopy method, this allows us to be more specific about the array copy.
        int[] targetArray = new int[16]; // define the target array (extended in size).
        // Copy from the unsortedIntArray from position 0 to the targetArray from position 4, unsortedIntArray.length
        // amount of elements.
        System.arraycopy(unsortedIntArray, 0, targetArray, 4, unsortedIntArray.length);
        // Display the new array, the values start from position 4 - means 4 zeros are outputted before the values start.
        for(int i = 0; i < targetArray.length; i++) {
            System.out.println(targetArray[i]);
        }
    }
}
