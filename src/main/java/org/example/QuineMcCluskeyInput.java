package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuineMcCluskeyInput {

    public static int getNumberOfVariables() {
        Scanner scanner = new Scanner(System.in);
        int numVariables = 0;
        while (numVariables < 1 || numVariables > 4) {
            System.out.print("Enter the number of variables (1-4): ");
            if (scanner.hasNextInt()) {
                numVariables = scanner.nextInt();
                if (numVariables < 1 || numVariables > 4) {
                    System.out.println("Please enter a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); // Clear invalid input
            }
        }
        return numVariables;
    }

    public static List<Integer> getMinterms(int numVariables) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> minterms = new ArrayList<>();
        int maxMinterm = (int) Math.pow(2, numVariables) - 1;
        System.out.println("Enter the minterms (0-" + maxMinterm + "). Enter -1 to finish:");
        while (true) {
            System.out.print("Enter minterm: ");
            if (scanner.hasNextInt()) {
                int minterm = scanner.nextInt();
                if (minterm == -1) {
                    break;
                } else if (minterm >= 0 && minterm <= maxMinterm) {
                    minterms.add(minterm);
                } else {
                    System.out.println("Please enter a valid minterm between 0 and " + maxMinterm + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid minterm.");
                scanner.next(); // Clear invalid input
            }
        }
        return minterms;
    }


}