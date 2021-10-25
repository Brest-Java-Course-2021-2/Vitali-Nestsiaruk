package com.epam.brest.selector;

import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Algorithm of getting Data from CSV Files
 * Method @selectPriceValue return value from interval of numbers in CSV Files
 */
public class PriceSelector {
    public BigDecimal selectPriceValue(Map<Integer, BigDecimal> valueMap, BigDecimal targetValue) {
        SortedSet<Integer> sortedKeys = new TreeSet<>(valueMap.keySet());
        Integer resultKey = sortedKeys.first();
        for (Integer key : sortedKeys) {
            if (resultKey >= targetValue.doubleValue()) {
                break;
            }
            resultKey = key;
        }
        BigDecimal resultValue = valueMap.get(resultKey);
        System.out.println("Value: " + targetValue + " -> " + resultValue);
        return resultValue;
    }
}
