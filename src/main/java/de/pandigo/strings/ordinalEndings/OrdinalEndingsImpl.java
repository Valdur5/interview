package de.pandigo.strings.ordinalEndings;

import java.util.LinkedHashMap;
import java.util.Map;

public class OrdinalEndingsImpl {

    public String numberToOrdinal( Integer number ) {

        // Edge case for 0
        if(number == 0) {
            return String.valueOf(number);
        }

        // We are not intressted in the integer value of the number therefore we get the
        // String value and work with this value.
        String numberAsString = String.valueOf(number);

        // A list which preserves the input order is used therefore the order can be used
        // to ensure that the 11 is evaluated before the 1.
        Map<String, String> endingLookupMap = new LinkedHashMap<>();

        // Filling the lookup map with the possible endings.
        endingLookupMap.put("11","th");
        endingLookupMap.put("12","th");
        endingLookupMap.put("13","th");
        endingLookupMap.put("1","st");
        endingLookupMap.put("2","nd");
        endingLookupMap.put("3","rd");

        // Looping through the possible endings.
        for(Map.Entry<String, String> lookupEntry : endingLookupMap.entrySet()) {
            if(numberAsString.equals(lookupEntry.getKey()) || numberAsString.endsWith(lookupEntry.getKey())) {
                return numberAsString+lookupEntry.getValue();
            }
        }

        // In case the number is not defined in the lookup we return "th" ending.
        return numberAsString+"th";
    }

}
