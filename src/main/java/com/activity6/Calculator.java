package com.activity6;

public class Calculator {
    private double numOne = 0;
    private double numTwo = 0;
    private double result = 0;

    public static void main(String[] args) {
        ScannerService scanner = new ScannerService();
        
        Calculator calculator = new Calculator();

        calculator.SetNumOne(scanner.getDouble("Enter first number: "));
        calculator.SetNumTwo(scanner.getDouble("Enter second number: "));

        System.out.println("--- Results ---");

        calculator.PerformOperation(1);
        calculator.PerformOperation(2);
        calculator.PerformOperation(3);
        calculator.PerformOperation(4);
    }

    private void DisplayResult(String OperationSymbol){
        System.out.println(this.numOne + " " + OperationSymbol + " " + this.numTwo + " = " + this.result);
    }

    private void PerformOperation(int operation) {
        String validationResult = ValidateOperation(operation);

        if (validationResult != null) {
            System.out.println(validationResult);
            throw new IllegalArgumentException(validationResult);
        }

        switch (operation) {
            case 1:
                result = numOne + numTwo;
                DisplayResult("+"); 
                break;
            case 2:
                result = numOne - numTwo;
                DisplayResult("-");
                break;
            case 3:
                result = numOne * numTwo;
                DisplayResult("*"); 
                break;
            case 4:
                if (numTwo != 0) {
                    result = numOne / numTwo;
                } else {
                    System.out.println("Cannot divide by zero.");
                }
                DisplayResult("/");
                break;
            default:
                System.out.println("Invalid operation selected.");
        }
    }

    private String ValidateOperation(int operation) {
        if (operation < 1 || operation > 4) {
            return "Invalid operation selected.";
        }
        
        return null;
    }

    public String ValidateNumber(double number) {
        if (number < 0) {
            return "Negative numbers are not allowed.";
        }

        if (Double.isNaN(number) || Double.isInfinite(number)) {
            return "Invalid number, try again..";
        }

        return null;
    }

    private void SetNumOne(double numOne) {
        String validationMessage = ValidateNumber(numOne);
        if (validationMessage != null) {
            System.out.println(validationMessage);
            throw new IllegalArgumentException(validationMessage);
        }

        this.numOne = numOne;
    }

    private void SetNumTwo(double numTwo) {
        String validationMessage = ValidateNumber(numTwo);
        if (validationMessage != null) {
            System.out.println(validationMessage);
            return;
        }

        this.numTwo = numTwo;
    }

    public double GetResult(){
        return result;
    }
}
