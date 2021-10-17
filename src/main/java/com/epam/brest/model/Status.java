package com.epam.brest.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Status {

    /** List contains two messages-instructions for consumer */
    List<String> message = new ArrayList<>(Arrays.asList("Please enter weight: ", "Please enter length: "));

    /** List contains two elements */
    List<BigDecimal> userData = new ArrayList<>();

    /** This method is processes data */
    Status handle();

    /** It's a ENUM status: READ_DATA, CALC, EXIT */
    StatusType getType();
}
