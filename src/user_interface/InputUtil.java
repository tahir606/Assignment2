package user_interface;

import java.util.Scanner;

public class InputUtil {

    private static Scanner keyboard = new Scanner(System.in);

    public static String inputString(String prompt) {
        System.out.println(prompt);
        String input = keyboard.next();
        return input;
    }

    public static String inputString(String prompt, String[] validValues) {
        String input;
        while (true) {
            System.out.println(prompt);
            input = keyboard.next();
            for (int i = 0; i < validValues.length; i++) {
                if (input.equals(validValues[i])) {
                    return input;
                }
            }
            System.out.println("Invalid Entry Try Again");
        }
    }

    public static int inputInt(String prompt) {
        System.out.println(prompt);
        int input = keyboard.nextInt();
        return input;
    }

    public static int inputInt(String prompt, int min, int max) {
        while (true) {
            System.out.println(prompt);
            try {
                int input = keyboard.nextInt();
                if (input > max) {
                    System.out.println("ERROR: Integer is greater than " + max);
                    continue;
                }
                if (input < min) {
                    System.out.println("ERROR: Integer is less than " + min);
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.println("ERROR: Invalid Integer");
                continue;
            }
        }
    }

    public static double inputDouble(String prompt) {
        System.out.println(prompt);
        double input = keyboard.nextDouble();
        return input;
    }

    public static double inputDouble(String prompt, int min, int max) {
        while (true) {
            System.out.println(prompt);
            try {
                double input = keyboard.nextDouble();
                if (input > max) {
                    System.out.println("ERROR: Integer is greater than " + max);
                    continue;
                }
                if (input < min) {
                    System.out.println("ERROR: Integer is less than " + min);
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.println("ERROR: Invalid Integer");
                continue;
            }
        }
    }

}
