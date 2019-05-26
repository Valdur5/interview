package de.pandigo.strings.maskCreditCard;

public class MaskCreditCard {

    private static MaskCreditCardImpl maskCreditCard = new MaskCreditCardImpl();

    public static void main(String[] args) {
        System.out.println(maskCreditCard.maskify("A123-3123-4123-4123"));
        System.out.println(maskCreditCard.maskify("412528195120518"));
    }
}
