package com.epam.brest;

import com.epam.brest.files.CSVFileReader;
import com.epam.brest.model.ReadDataState;
import com.epam.brest.model.Status;
import com.epam.brest.model.StatusType;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //result = weight * pricePerKg + length * pricePerKm;

        Map<Integer, BigDecimal> pricePerKgMap = new CSVFileReader().readData("price_weight.csv");
        Map<Integer, BigDecimal> pricePerKmMap = new CSVFileReader().readData("price_length.csv");

        try (Scanner scanner = new Scanner(System.in)) {
            Status currentStatus = new ReadDataState(scanner, pricePerKgMap, pricePerKmMap);
            while (currentStatus.getType() != StatusType.EXIT) {
                System.out.println("Current system status: " + currentStatus.getType());
                currentStatus = currentStatus.handle();
            }
        }
    }
}