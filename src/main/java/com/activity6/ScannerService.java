package com.activity6;

import java.util.Scanner;

public class ScannerService {
    // one scanner instance for the whole application!
    private final Scanner scanner;

    public ScannerService() {
        scanner = new Scanner(System.in);
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }


    public double getDouble(String prompt) {
        try {
            System.out.println(prompt);
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number, try again..");
            nfe.getMessage();
            
        }
        return 0;
    }

    public int getOperation(){
        System.out.println("Select operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        return Integer.parseInt(scanner.nextLine());
    }

    public void closeScanner() {
        System.out.println("closing scanner..");
    }
}