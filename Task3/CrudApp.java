package Task3;

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private int id;
    private String name;
    private String description;

    public Task(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Name: " + name + ", Description: " + description;
    }
}

public class CrudApp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int taskIdCounter = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== Task Manager ====");
            System.out.println("1. Create Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    createTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private static void createTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        Task task = new Task(taskIdCounter++, name, description);
        tasks.add(task);
        System.out.println("Task created successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private static void updateTask() {
        System.out.print("Enter task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.print("Enter new task name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new task description: ");
                String newDescription = scanner.nextLine();
                task.setName(newName);
                task.setDescription(newDescription);
                System.out.println("Task updated successfully!");
                return;
            }
        }
        System.out.println("Task ID not found.");
    }

    private static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                System.out.println("Task deleted successfully!");
                return;
            }
        }
        System.out.println("Task ID not found.");
    }
}
