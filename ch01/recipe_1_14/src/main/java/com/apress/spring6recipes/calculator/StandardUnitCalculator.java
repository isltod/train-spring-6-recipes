package com.apress.spring6recipes.calculator;

import org.springframework.stereotype.Component;

@Component
public class StandardUnitCalculator implements UnitCalculator{

    @Override
    public double kilogramToPounds(double kilogram) {
        var pound = kilogram * 2.2;
        System.out.printf("%f kilogram = %f pound\n", kilogram, pound);
        return pound;
    }

    @Override
    public double kilometerToMiles(double kilometer) {
        var miles = kilometer * 0.621371;
        System.out.printf("%f kilometer = %f miles\n", kilometer, miles);
        return miles;
    }
}
