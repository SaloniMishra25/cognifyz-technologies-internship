package Task5;

import java.io.*;
import java.util.*;

public class TaskManager {
    private static final String FILE_NAME = "tasks.txt";
    private List<Task> tasks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int nextId = 1;

    public static void main(String[] args) {
        TaskManager app = new TaskManager();
        app.loadTasks();  
        app.menu();       
        app.saveTasks();  
    }

    // Main menu for CRUD operations
    public void menu() {
        while (true) {
            System.out.println("\n1. List tasks");
            System.out.println("2. Add task");
            System.out.println("3. Update task");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch(choice) {
                case "1": listTasks(); break;
                case "2": addTask(); break;
                case "3": updateTask(); break;
                case "4": deleteTask(); break;
                case "5": 
                    saveTasks();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    // List all tasks
    private void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task t : tasks) {
            System.out.println(t.id + ". " + t.description);
        }
    }

    // Add new task
    private void addTask() {
        System.out.print("Enter task description: ");
        String desc = scanner.nextLine();
        tasks.add(new Task(nextId++, desc));
        System.out.println("Task added.");
    }

    // Update existing task
    private void updateTask() {
        System.out.print("Enter task ID to update: ");
        int id = readInt();
        Task t = findTask(id);
        if (t == null) {
            System.out.println("Task not found.");
            return;
        }
        System.out.print("Enter new description: ");
        String desc = scanner.nextLine();
        t.description = desc;
        System.out.println("Task updated.");
    }

    // Delete task by ID
    private void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = readInt();
        Task t = findTask(id);
        if (t == null) {
            System.out.println("Task not found.");
            return;
        }
        tasks.remove(t);
        System.out.println("Task deleted.");
    }

    // Helper: find task by ID
    private Task findTask(int id) {
        for (Task t : tasks) {
            if (t.id == id) return t;
        }
        return null;
    }

    
    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

  
    private void loadTasks() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return; 
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int maxId = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":", 2);
                int id = Integer.parseInt(parts[0]);
                String desc = parts.length > 1 ? parts[1] : "";
                tasks.add(new Task(id, desc));
                if (id > maxId) maxId = id;
            }
            nextId = maxId + 1;
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    // Save tasks to file with error handling
    private void saveTasks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task t : tasks) {
                bw.write(t.id + ":" + t.description);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // Task class to hold task data
    static class Task {
        int id;
        String description;
        Task(int id, String description) {
            this.id = id;
            this.description = description;
        }
    }
}

