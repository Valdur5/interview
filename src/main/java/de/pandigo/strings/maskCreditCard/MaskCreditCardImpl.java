package de.pandigo.strings.maskCreditCard;

class MaskCreditCardImpl {

    private static final int NO_MASK_FOR_LAST_DIGITS = 4;
    private static final int MINIMAL_LENGTH_TO_START_MASKING = 6;
    private static final String CHARACTERS_TO_MASK = "[0-9]";
    private static final String MASK_CHARACTER = "#";

    public String maskify(String creditCardNumber) {

        // Initial calculation of the length to avoid recalculation of an static variable.
        int creditCardLength = creditCardNumber.length();

        // Too small number criteria.
        if(creditCardLength < MINIMAL_LENGTH_TO_START_MASKING) {
            return creditCardNumber;
        }

        // The input string is not modified, we create a new string to be returned.
        StringBuilder sb = new StringBuilder();

        String[] creditCardNumberAsArray = creditCardNumber.split("");
        // Go through the parts of the number and either mask them or not.
        for(int i=0; i < creditCardLength; i++) {
            if(creditCardNumberAsArray[i].matches(CHARACTERS_TO_MASK)) {
                if(i == 0 || i >= creditCardLength-NO_MASK_FOR_LAST_DIGITS) {
                    sb.append(creditCardNumberAsArray[i]);
                } else {
                    sb.append(MASK_CHARACTER);
                }
            } else {
                sb.append(creditCardNumberAsArray[i]);
            }
        }
        return sb.toString();
    }
}
