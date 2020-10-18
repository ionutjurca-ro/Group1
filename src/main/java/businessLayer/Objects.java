package businessLayer;

import dataAccessLayer.Project;
import dataAccessLayer.Task;
import dataAccessLayer.Type;
import dataAccessLayer.User;

import java.util.Arrays;
import java.util.List;

public class Objects {

    private ProjectService projectService = new ProjectService();
    private TypeService typeService = new TypeService();
    private UserService userService = new UserService();
    private TaskService taskService = new TaskService();


    public void createTaskObject() {
        List<Type> types = createTypeObject();
        List<User> users = createUserObject();
        Project project = createProjectObject();

        Task task1 = new Task();
        task1.setTaskName("seeding");
        task1.setType(types.get(0));
        task1.setProject(project);
        task1.setUser(users.get(0));
        taskService.addObject(task1);

        Task task2 = new Task();
        task2.setTaskName("harvesting");
        task2.setType(types.get(0));
        task2.setProject(project);
        task2.setUser(users.get(1));
        taskService.addObject(task2);

        Task task3 = new Task();
        task3.setTaskName("promotingProducts");
        task3.setType(types.get(1));
        task3.setProject(project);
        taskService.addObject(task3);

        Task task4 = new Task();
        task4.setTaskName("findingBuyers");
        task4.setType(types.get(1));
        task4.setProject(project);
        task4.setUser(users.get(2));
        taskService.addObject(task4);

        Task task5 = new Task();
        task5.setTaskName("creatingStock");
        task5.setType(types.get(2));
        task5.setProject(project);
        taskService.addObject(task5);

        Task task6 = new Task();
        task6.setTaskName("shipping");
        task6.setType(types.get(2));
        task6.setProject(project);
        taskService.addObject(task6);
    }

    public Project createProjectObject() {
        Project project = new Project();
        project.setProjectName("Food Farm");
        project.setDescription("Welcome to our farm");
        project.setStartDate(java.sql.Date.valueOf("2020-08-23"));
        project.setEndDate(java.sql.Date.valueOf("2020-11-20"));
        projectService.addObject(project);
        return project;
    }

    public List<Type> createTypeObject() {
        Type type1 = new Type();
        type1.setTypeName("Production");
        typeService.addObject(type1);

        Type type2 = new Type();
        type2.setTypeName("Marketing");
        typeService.addObject(type2);

        Type type3 = new Type();
        type3.setTypeName("Transport");
        typeService.addObject(type3);

        return Arrays.asList(type1, type2, type3);
    }

    public List<User> createUserObject() {
        User user1 = new User();
        user1.setFirstName("Catalin");
        user1.setLastName("Ardelean");
        user1.setUsername("cata");
        user1.setPassword("cata");
        userService.addObject(user1);

        User user2 = new User();
        user2.setFirstName("George");
        user2.setLastName("Enescu");
        user2.setUsername("geo");
        user2.setPassword("geo");
        userService.addObject(user2);

        User user3 = new User();
        user3.setFirstName("Vasile");
        user3.setLastName("Alecsandri");
        user3.setUsername("vasi");
        user3.setPassword("vasi");
        userService.addObject(user3);

        return Arrays.asList(user1, user2, user3);
    }

}
