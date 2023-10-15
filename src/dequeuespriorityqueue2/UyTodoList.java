/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dequeuespriorityqueue2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

class Task {
    String description;

    public Task(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
public class UyTodoList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<Task> taskQueue = new LinkedList<>();
        Stack<Task> undoStack = new Stack<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Todo List:");
            for (Task task : taskQueue) {
                System.out.println("- " + task);
            }

            System.out.println("\nOptions:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Undo");
            System.out.println("4. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    Task newTask = new Task(description);
                    taskQueue.offer(newTask);
                    undoStack.push(newTask);
                    break;
                case 2:
                    if (!taskQueue.isEmpty()) {
                        Task removedTask = taskQueue.poll();
                        undoStack.push(removedTask);
                        System.out.println("Removed: " + removedTask);
                    } else {
                        System.out.println("Todo list is empty.");
                    }
                    break;
                case 3:
                    if (!undoStack.isEmpty()) {
                        Task undoneTask = undoStack.pop();
                        taskQueue.remove(undoneTask);
                        System.out.println("Undid: " + undoneTask);
                    } else {
                        System.out.println("Nothing to undo.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
}
