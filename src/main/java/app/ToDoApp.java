package app;

import java.util.List;
import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TodoList list = new TodoList();

        while (true) {
            System.out.println("\n--- TO-DO (In-Memory) ---");
            System.out.println("1) Add item");
            System.out.println("2) Delete item");
            System.out.println("3) View items");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Write the to-do: ");
                    String text = sc.nextLine();
                    list.add(text);
                    System.out.println("Added.");
                    break;
                case "2":
                    List<TodoItem> items = list.all();
                    if (items.isEmpty()) { System.out.println("Nothing to delete."); break; }
                    print(items);
                    System.out.print("Number to delete: ");
                    try {
                        int pos = Integer.parseInt(sc.nextLine().trim());
                        System.out.println(list.deleteByPosition(pos) ? "Deleted." : "Invalid number.");
                    } catch (NumberFormatException e) {
                        System.out.println("Please type a number.");
                    }
                    break;
                case "3":
                    List<TodoItem> all = list.all();
                    if (all.isEmpty()) System.out.println("No items yet.");
                    else print(all);
                    break;
                case "0":
                    System.out.println("Bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Not a valid option.");
            }
        }
    }

    private static void print(List<TodoItem> items) {
        System.out.println("\nYour to-dos:");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, items.get(i).getText());
        }
    }
}
