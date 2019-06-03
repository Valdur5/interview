package de.pandigo.tasks.arrays.sumInList;

import java.util.List;

public class SumInList {

    private static FastImplementation fastImplementation = new FastImplementation();

    public static void main(String[] args) {
        List<Pair> pairList = fastImplementation.contains(new int[]{1, 4, 5, 11, -2}, 9);
        pairList.forEach(p -> System.out.println(p.getNumber1() + " "+ p.getNumber2()));
    }
}
