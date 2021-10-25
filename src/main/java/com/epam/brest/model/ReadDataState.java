package com.epam.brest.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import static com.epam.brest.model.StatusType.*;

public class ReadDataState extends AbstractStatus{

    public static final int NUMBER_OF_USER_DATA = 2;

    public ReadDataState(Scanner scanner, Map<Integer, BigDecimal> pricePerKgMap, Map<Integer, BigDecimal> pricePerKmMap) {
        this.scanner = scanner;
        this.pricePerKgMap = pricePerKgMap;
        this.pricePerKmMap = pricePerKmMap;
    }

    @Override
    public Status handle() {
        if (userData.size() < NUMBER_OF_USER_DATA) {
            /**
             * When collection get one import significance - we get first message,
             * when collection get second import significance - we get second message
            */
            System.out.println(message.get(userData.size()));
            String inputValue = scanner.next();
            if (inputValue.equalsIgnoreCase("q")) {
                return new ExitState();
            } else if (isCorrectValue(inputValue)) {
                userData.add(new BigDecimal(inputValue));
            }
        } else {
            return new CalcState(scanner, pricePerKgMap, pricePerKmMap);
        }
        return this;
    }

    private boolean isCorrectValue(String inputValue) {
        try {
            BigDecimal enteredValue = new BigDecimal(inputValue);
            /** Check a number with a minus */
            return enteredValue.doubleValue() > 0;
            /** Second way: return enteredValue.doubleValue() > 0 ? true : false */
        } catch (NumberFormatException e) {
            System.out.println("Incorrect value: " + inputValue);
        }
        return false;
    }

    @Override
    public StatusType getType() {
        return READ_DATA;
    }
}
