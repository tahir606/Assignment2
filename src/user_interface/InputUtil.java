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
        System.out.println(prompt);
        String input = keyboard.next();
        return input;
    }

    public static int inputInt(String prompt) {
        System.out.println(prompt);
        int input = keyboard.nextInt();
        return input;
    }

    public static int inputInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int input = keyboard.nextInt();
        return input;
    }

    public static double inputDouble(String prompt) {
        System.out.println(prompt);
        double input = keyboard.nextDouble();
        return input;
    }

    public static double inputDouble(String prompt, int min, int max) {
        System.out.println(prompt);
        double input = keyboard.nextDouble();
        return input;
    }

}
