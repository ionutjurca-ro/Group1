package businessLayer;

import dataAccessLayer.User;

public class LogIn {
    public static User myUSer;
    private static UserService userService = new UserService();
    private static User user = new User();

    public static void logIn() {
        User foundUser = insertedUser();
        if (foundUser != null) {
            System.out.println("You logged in successfully");
            myUSer = foundUser;
        } else {
            System.out.println("The username or password are not correct");
            logIn();
        }
    }

    public static User insertedUser() {
        System.out.println("Insert username: ");
        String insertedUsername = ScannerUtils.getTextfromConsole();
        System.out.println("Insert password: ");
        String insertedPassword = ScannerUtils.getTextfromConsole();
        User foundUser = null;
        for (User userElement : userService.findAll(user)) {
            if (insertedUsername.equals(userElement.getUsername()) && insertedPassword.equals(userElement.getPassword())) {
                foundUser = userElement;
            }
        }
        return foundUser;
    }
}
