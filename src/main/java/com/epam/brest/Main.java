package com.epam.brest;

import com.epam.brest.calc.CalcImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // result = weight * pricePerKg + length * pricePerKm;
        // scanner
        // prop / json / csv

        BigDecimal weight, pricePerKg, length, pricePerKm;

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                weight = getValueFromConsole(scanner, "Entered weight:");
                pricePerKg = getValueFromConsole(scanner, "Entered pricePerKg:");
                length = getValueFromConsole(scanner, "Entered length:");
                pricePerKm = getValueFromConsole(scanner, "Entered pricePerKm:");
                System.out.println("Result: " + new CalcImpl().handle(weight, pricePerKg, length, pricePerKm));
                System.out.println("Enter 'q' for exit or 'c' to continue:");
            } while (!scanner.hasNext("q"));

        }
    }

    private static BigDecimal getValueFromConsole(Scanner scanner, String outputMessage) {
        BigDecimal enteredValue;
        System.out.print(outputMessage);
        enteredValue = scanner.nextBigDecimal();
        return enteredValue;
    }

}