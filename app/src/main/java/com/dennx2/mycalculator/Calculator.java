package com.dennx2.mycalculator;

import java.util.ArrayList;

public class Calculator {
    String numberString="0";
    String detailsString="";
    long intNumber;
    double realNumber;

    ArrayList<String> calcMethods = new ArrayList<>();
    ArrayList<Long> inputs = new ArrayList<>();

    long resultInt = 0;
    double resultDouble = 0.0;
    boolean isResultInt = true;

    boolean isIntNumber=true;
    boolean numHasRadixPoint=false;
    long memoryInt=0;
    double memoryDouble=0.0;
    boolean isIntMemory=true;

    public Calculator() {
    }

//    public void processNumber(int i) {
//        if(numberString.length()<12) {  // limit of 12 digits
//            intNumber = intNumber * 10 + i;
//            numberString = String.valueOf(intNumber);
//            detailsString = "Clicked: "+i;
//        }
//        else
//            detailsString="The number is too long..";
//    }

    public void processNumber(String s) {
        numHasRadixPoint = numberString.contains(".");
        if(numberString.length()<12) {  // limit of 12 digits
            if (s == "." && numHasRadixPoint) {  // limit only one . input
            }
            else if (!numHasRadixPoint && s ==".") {
                numberString += s;
            }
            else if (numHasRadixPoint) {
                numberString += s;
                isIntNumber = false;
                realNumber = Double.parseDouble(numberString);
                numberString = String.valueOf(realNumber);
            }
            else {
                numberString += s;
                isIntNumber = true;
                intNumber = Long.parseLong(numberString);
                numberString = String.valueOf(intNumber);
            }
            detailsString = "Clicked: "+ s;
        }
        else
            detailsString="The number is too long..";
    }

    public void basicCalculation(String calcMethod) {

        if (numberString != "") {
            calcMethods.add(calcMethod);

            if (calcMethods.size() == 1) {
                if (isIntNumber) {
                    resultInt = intNumber;
                }
                else {
                    resultDouble = realNumber;
                    isResultInt = false;
                }
            }
            else if (calcMethods.size() > 1) {
                if (isResultInt) {
                    if (isIntNumber) {
                        switch (calcMethods.get(0)) {
                            case "add": resultInt += intNumber; break;
                            case "sub": resultInt -= intNumber; break;
                            case "mul": resultInt *= intNumber; break;
                            case "div": resultInt /= intNumber; break;
                        }
                        detailsString = String.valueOf(resultInt);
                    }
                    else {
                        switch (calcMethods.get(0)) {
                            case "add": resultDouble = resultInt + realNumber; break;
                            case "sub": resultDouble = resultInt - realNumber; break;
                            case "mul": resultDouble = resultInt * realNumber; break;
                            case "div": resultDouble = resultInt / realNumber; break;
                        }
                        isResultInt = false;
                        detailsString = String.valueOf(resultDouble);
                    }
                }
                else {
                    if (isIntNumber) {
                        switch (calcMethods.get(0)) {
                            case "add": resultDouble += intNumber; break;
                            case "sub": resultDouble -= intNumber; break;
                            case "mul": resultDouble *= intNumber; break;
                            case "div": resultDouble /= intNumber; break;
                        }
                    }
                    else {
                        switch (calcMethods.get(0)) {
                            case "add": resultDouble += realNumber; break;
                            case "sub": resultDouble -= realNumber; break;
                            case "mul": resultDouble *= realNumber; break;
                            case "div": resultDouble /= realNumber; break;
                        }
                    }
                    detailsString = String.valueOf(resultDouble);
                }
                calcMethods.remove(0);
            }
            numberString = "";
        }
    }


    public void clearClicked() {
        numberString="0";
        detailsString="";
        intNumber=0;
        realNumber=0.0;
        resultInt = 0;
        resultDouble = 0.0;
        isResultInt = true;
        calcMethods.clear();
        isIntNumber=true;
        numHasRadixPoint=false;
    }

    public void equalClicked() {
        basicCalculation("");

        if (isResultInt) {
            numberString = String.valueOf(resultInt);
        }
        else {
            numberString = String.valueOf(resultDouble);
        }

        intNumber=0;
        realNumber=0.0;
        isIntNumber=true;
        detailsString = "";
        calcMethods.clear();
    }

    public void memClearClicked() {
        memoryInt = 0;
        memoryDouble = 0.0;
        isIntMemory = true;
        detailsString = "Memory: " + memoryInt;
    }

    public void memRClicked() {
        if (isIntMemory) {
            numberString = String.valueOf(memoryInt);
        }
        else {
            numberString = String.valueOf(memoryDouble);
        }
    }

//    public void memPlusClicked() {
//        if(isIntMemory){
//            if(isIntNumber) {
//                memoryInt += Long.parseLong(numberString);
//                detailsString = "Memory: "+memoryInt;
//            }
//            else {
//                isIntMemory=false;
//                memoryDouble = memoryInt + Double.parseDouble(numberString);
//                detailsString = "Memory: "+memoryDouble;
//            }
//        }
//        else {
//            if(isIntNumber) {
//                memoryDouble += Long.parseLong(numberString);
//            }
//            else {
//                memoryDouble += Double.parseDouble(numberString);
//            }
//            detailsString = "Memory: "+memoryDouble;
//        }
//    }

    public void memPlusClicked() {
        numHasRadixPoint = numberString.contains(".");
        if(isIntMemory){
            if(!numHasRadixPoint) {
                memoryInt += Long.parseLong(numberString);
                detailsString = "Memory: "+memoryInt;
            }
            else {
                isIntMemory=false;
                memoryDouble = memoryInt + Double.parseDouble(numberString);
                detailsString = "Memory: "+memoryDouble;
            }
        }
        else {
            if(!numHasRadixPoint) {
                memoryDouble += Long.parseLong(numberString);
            }
            else {
                memoryDouble += Double.parseDouble(numberString);
            }
            detailsString = "Memory: "+memoryDouble;
        }
    }

//    public void memMinusClicked() {
//        if(isIntMemory){
//            if(isIntNumber) {
//                memoryInt -= Long.parseLong(numberString);
//                detailsString = "Memory: "+ memoryInt;
//            }
//            else {
//                isIntMemory=false;
//                memoryDouble = memoryInt - Double.parseDouble(numberString);
//                detailsString = "Memory: "+ memoryDouble;
//            }
//        }
//        else {
//            if(isIntNumber) {
//                memoryDouble -= Long.parseLong(numberString);
//            }
//            else {
//                memoryDouble -= Double.parseDouble(numberString);
//            }
//            detailsString = "Memory: "+memoryDouble;
//        }
//    }

    public void memMinusClicked() {
        numHasRadixPoint = numberString.contains(".");
        if(isIntMemory){
            if(!numHasRadixPoint) {
                memoryInt -= Long.parseLong(numberString);
                detailsString = "Memory: "+ memoryInt;
            }
            else {
                isIntMemory=false;
                memoryDouble = memoryInt - Double.parseDouble(numberString);
                detailsString = "Memory: "+ memoryDouble;
            }
        }
        else {
            if(!numHasRadixPoint) {
                memoryDouble -= Long.parseLong(numberString);
            }
            else {
                memoryDouble -= Double.parseDouble(numberString);
            }
            detailsString = "Memory: "+memoryDouble;
        }
    }

//    public void percentageClicked() {
//        if (isIntNumber) {
//            isIntNumber = false;
//            realNumber = intNumber/100.0;
//            numberString = intNumber + "%";
//        }
//        else {
//            realNumber = realNumber / 100;
//            numberString = realNumber + "%";
//        }
//    }

    public void percentageClicked() {
        numHasRadixPoint = numberString.contains(".");
        if (!numHasRadixPoint) {

            intNumber = Long.parseLong(numberString);
            realNumber = intNumber/100.0;
        }
        else {
            realNumber = Double.parseDouble(numberString);
            realNumber = realNumber / 100;
        }
        isIntNumber = false;
        numberString = numberString + "%";
        detailsString = String.valueOf(realNumber);
    }

    public void expClicked() {
        if (isIntNumber) {

            realNumber = Math.exp(intNumber);
        }
        else {
            realNumber = Math.exp(realNumber);
        }
        isIntNumber = false;
        numberString = String.valueOf(realNumber);
    }

//    public void piClicked() {
//        if (isIntNumber) {
//            realNumber = intNumber * Math.PI;
//            isIntNumber = false;
//            numberString = intNumber + "\uD835\uDF0B";
//        }
//        else {
//            realNumber = realNumber * Math.PI;
//            numberString = realNumber + "\uD835\uDF0B";
//        }
//        detailsString = String.valueOf(realNumber);
//    }

    public void piClicked() {
        numHasRadixPoint = numberString.contains(".");
        if (!numHasRadixPoint) {
            intNumber = Long.parseLong(numberString);
            realNumber = intNumber * Math.PI;
        }
        else {
            realNumber = Double.parseDouble(numberString);
            realNumber = realNumber * Math.PI;
        }
        isIntNumber = false;
        numberString = numberString + "\uD835\uDF0B";
        detailsString = String.valueOf(realNumber);
    }

}
