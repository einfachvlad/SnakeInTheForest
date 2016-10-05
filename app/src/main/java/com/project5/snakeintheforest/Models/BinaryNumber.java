package com.project5.snakeintheforest.Models;

import java.util.ArrayList;

public class BinaryNumber {
    StringBuffer binaryNumber = new StringBuffer();
    public boolean nextNumber = false;

    public void add(int part) {
        binaryNumber.append(part);
    }

    public boolean isEqualSize(StringBuffer number) {
        return binaryNumber.length() == number.length();
    }

    public void delete() {
        if (binaryNumber.length() != 0)
            binaryNumber.deleteCharAt(binaryNumber.length() - 1);
    }

    public boolean isEqual(StringBuffer number) {
        return binaryNumber.toString().contentEquals(number);
    }

    public void clear() {
        binaryNumber = new StringBuffer();
    }

    public int size() {
        return binaryNumber.length();
    }
}
