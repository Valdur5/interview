package de.pandigo.sumInList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FastImplementation {

    public List<Pair> contains(int [] arrayToCheck, int sum) {

        List<Pair> validPairs = new ArrayList<>();

        if(arrayToCheck != null) {
            Set<Integer> complementArray = new HashSet<>();

            for (int i = 0; i < arrayToCheck.length; i++) {
                int complement = sum - arrayToCheck[i];

                if(complementArray.contains(arrayToCheck[i]))
                {
                    validPairs.add(new Pair(complement, arrayToCheck[i]));
                }
                complementArray.add(complement);
            }
        }
        return validPairs;
    }

}
