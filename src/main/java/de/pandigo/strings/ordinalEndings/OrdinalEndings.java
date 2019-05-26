package de.pandigo.strings.ordinalEndings;

public class OrdinalEndings {

    private static OrdinalEndingsImpl ordinalEndings = new OrdinalEndingsImpl();

    public static void main(String[] args) {
        System.out.println("0 -> " + ordinalEndings.numberToOrdinal(0));
        System.out.println("1 -> " + ordinalEndings.numberToOrdinal(1));
        System.out.println("2 -> " + ordinalEndings.numberToOrdinal(2));
        System.out.println("3 -> " + ordinalEndings.numberToOrdinal(3));
        System.out.println("4 -> " + ordinalEndings.numberToOrdinal(4));
        System.out.println("9 -> " + ordinalEndings.numberToOrdinal(9));
        System.out.println("10 -> " + ordinalEndings.numberToOrdinal(10));
        System.out.println("11 -> " + ordinalEndings.numberToOrdinal(11));
        System.out.println("12 -> " + ordinalEndings.numberToOrdinal(12));
        System.out.println("13 -> " + ordinalEndings.numberToOrdinal(13));
        System.out.println("14 -> " + ordinalEndings.numberToOrdinal(14));
        System.out.println("22 -> " + ordinalEndings.numberToOrdinal(22));
        System.out.println("112 -> " + ordinalEndings.numberToOrdinal(112));
        System.out.println("122 -> " + ordinalEndings.numberToOrdinal(122));
    }
}
