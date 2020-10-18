package businessLayer;


import dataAccessLayer.Status;
import dataAccessLayer.Task;
import dataAccessLayer.User;

public class Services {

    private static User loggedUser;
    TaskService taskService = new TaskService();
    UserService userService = new UserService();
    Task task = new Task();

    public Services() {
        loggedUser = LogIn.myUSer;
    }

    //pt main
    public void viewAllTasks() {
        System.out.println("The tasks are: ");
        taskService.findAll(task).stream().map(Task::getTaskName).forEach(System.out::println);
    }

    //pt main
    public void assignTask() {
        viewTaskWhichAreNotAssigned();
        Task assignedTask = insertedTaskFromUnassignedTasks();
        if (assignedTask != null) {
            System.out.println("The task " + assignedTask.getTaskName() + " has been assigned");
            loggedUser.getTasks().add(assignedTask);
            assignedTask.setStatus(Status.IN_PROGRESS);
            taskService.updateObject(assignedTask);
            userService.updateObject(loggedUser);
        } else {
            System.out.println("The task you inserted does not exist");
            assignTask();
        }
    }

    public void viewTaskWhichAreNotAssigned() {
        System.out.println("The tasks which are not assigned to anyone are: ");
        taskService.findAll(task).stream().filter(t -> t.getUser() == null).map(t -> t.getTaskName()).forEach(System.out::println);
    }

    public Task insertedTaskFromUnassignedTasks() {
        System.out.println("Insert the task name you want to be assigned to: ");
        String insertedTask = ScannerUtils.getTextfromConsole();
        Task assignedTask = null;
        for (Task taskElement : taskService.findAll(task)) {
            if (insertedTask.equals(taskElement.getTaskName())) {
                assignedTask = taskElement;
            }
        }
        return assignedTask;
    }

    //pt main
    public void viewStatusOfAllTasks() {
        for (Task taskElement : taskService.findAll(task)) {
            System.out.println("Task " + taskElement.getTaskName() + " has the status " + taskElement.getStatus());
        }
    }

    //pt main
    public void viewTasksAssignedToAUser() {
        System.out.println("The tasks you are assigned to are: ");
        loggedUser.getTasks().stream().map(Task::getTaskName).forEach(System.out::println);
    }

    public Task insertedTaskOfLoggedUser() {
        System.out.println("Insert the task name for which you want to change the status: ");
        String insertedTask = ScannerUtils.getTextfromConsole();
        Task foundTask = null;
        for (Task taskElement : loggedUser.getTasks()) {
            if (insertedTask.equals(taskElement.getTaskName())) {
                foundTask = taskElement;
            }
        }
        return foundTask;
    }

    public void viewStatusOfTasksAssignedToLoggedUser() {
        System.out.println("The status of your tasks are: ");
        for (Task taskElement : loggedUser.getTasks()) {
            System.out.println("Task " + taskElement.getTaskName() + " has the status " + taskElement.getStatus());
        }
    }

    //pt main
    public void changeStatusOfInsertedTask() {
        viewStatusOfTasksAssignedToLoggedUser();
        Task selectedTask = insertedTaskOfLoggedUser();
        if (selectedTask != null) {
            System.out.println("Press 1 to change the status into in progress");
            System.out.println("Press 2 to change the status into finished");
            int insertedValue = ScannerUtils.getNumberFromConsole();
            if (insertedValue == 1) {
                selectedTask.setStatus(Status.IN_PROGRESS);
                taskService.updateObject(selectedTask);
                System.out.println("The status has been changed into IN_PROGRESS");
            } else if (insertedValue == 2) {
                selectedTask.setStatus(Status.FINISHED);
                taskService.updateObject(selectedTask);
                System.out.println("The status has been changed into FINISHED");
            } else {
                System.out.println("Your inserted value is not correct");
                changeStatusOfInsertedTask();
            }
        } else {
            System.out.println("The task has not been found");
            changeStatusOfInsertedTask();
        }
    }

    public void addTask() {
        System.out.println("Enter the project name you want to add the task into: ");
    }
}
