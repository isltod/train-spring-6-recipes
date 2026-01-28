package com.apress.spring6recipes.calculator;

public record Complex(int real, int imag) {

    @Override
    public String toString() {
        return "(" + real + " + " + imag + "i)";
    }
}
