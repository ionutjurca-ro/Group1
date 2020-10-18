package businessLayer;


import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils {

    private static Scanner input;

    public static Scanner getScanner() {
        if (input == null) {
            input = new Scanner(System.in);
        }
        return input;
    }

    public static String getTextfromConsole() {
        Scanner scanner = getScanner();
        return scanner.next();
    }

    public static int getNumberFromConsole() {
        Scanner scanner = getScanner();
        int value;
        try {
            value = scanner.nextInt();
            return value;
        } catch (InputMismatchException e) {
            System.out.println("Please insert an int value");
            scanner.nextLine();
            return getNumberFromConsole();
        }
    }
}
