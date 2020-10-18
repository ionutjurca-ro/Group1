package presentationLayer;

import businessLayer.LogIn;
import businessLayer.ScannerUtils;
import businessLayer.Services;


public class Main {

    public static void main(String[] args) {
//        Objects objects = new Objects();
//        objects.createTaskObject();
        // this is something modified third time

        startApp();
    }

    private static void mainMenu() {
        System.out.println();
        System.out.println("Press 1 to view tasks assigned to a user");
        System.out.println("Press 2 to choose a task");
        System.out.println("Press 3 to change status of a task");
        System.out.println("Press 4 to view status of all tasks");
        System.out.println("Press 5 to view all tasks");
        System.out.println("Press 0 to exit");
    }

    private static void startApp() {
        LogIn.logIn();
        Services services = new Services();
        int option = -1;
        while (option != 0) {
            mainMenu();
            option = ScannerUtils.getNumberFromConsole();
            if (option == 1) services.viewTasksAssignedToAUser();
            else if (option == 2) services.assignTask();
            else if (option == 3) services.changeStatusOfInsertedTask();
            else if (option == 4) services.viewStatusOfAllTasks();
            else if (option == 5) services.viewAllTasks();
        }
    }
}
