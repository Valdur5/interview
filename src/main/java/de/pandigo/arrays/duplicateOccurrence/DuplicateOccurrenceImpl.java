package de.pandigo.arrays.duplicateOccurrence;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateOccurrenceImpl {

    /**
     * The naive solution, the runtime is O(n) for creating the count map and O(n) for filtering.
     * In total the runtime is O(n). The space requirement is O(n) for the input list and O((n/2)+1)
     * for the count map in the worst case. This is the place which allows us to optimize even further.
     *
     * @param numberList the input list.
     * @return the number which has odd occurrence.
     */
    public int findOddDuplicateMap(List<Integer> numberList) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Create a count map to register the occurrence of each number
        numberList.forEach(nr -> countMap.put(nr, countMap.getOrDefault(nr, 0)+1));

        // Filter the count map for odd occurrence of a number.
        // Since the task defines that there is only one number if an odd occurrence we can get safely the first element.
        return countMap.entrySet().stream().filter(e -> e.getValue() % 2 != 0).collect(Collectors.toList()).get(0).getKey();
    }

    /**
     * The optimized solution has still a linear runtime O(n) but the space requirement is better since we don't
     * need to store all even values with their count. We just have a set to track the numbers which are currently
     * odd.
     *
     * @param numberList the input list.
     * @return the number which has odd occurrence.
     */
    public int findOddDuplicateSet(List<Integer> numberList) {
        Set<Integer> oddSet = new HashSet<>();

        // For each number check if the number is already in the odd set.
        numberList.forEach(nr -> {
            if (oddSet.contains(nr)) {
                // If the number is in the odd set we can remove it because now it is even.
                oddSet.remove(nr);
            } else {
                // If the number is not in the odd set we add it since the occurrence is 1 or any odd number.
                oddSet.add(nr);
            }
        });

        // Work around because the set does not have a get method.
        return new ArrayList<>(oddSet).get(0);
    }
}
