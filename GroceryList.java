import java.util.Arrays;
import java.util.Scanner;

public class GroceryList {
    private static String[] items = new String[50];
    private static int count = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Grocery List Menu ===");
            System.out.println("1. Add item");
            System.out.println("2. Display items");
            System.out.println("3. Search item");
            System.out.println("4. Update item");
            System.out.println("5. Delete item");
            System.out.println("6. Count items");
            System.out.println("7. Sort items alphabetically");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: addItem(); break;
                case 2: displayItems(); break;
                case 3: searchItem(); break;
                case 4: updateItem(); break;
                case 5: deleteItem(); break;
                case 6: countItems(); break;
                case 7: sortItems(); break;
                case 0: System.out.println("Exiting program."); break;
                default: System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
    }

    private static void addItem() {
        if (count >= items.length) {
            System.out.println("Grocery list is full!");
            return;
        }
        System.out.print("Enter item to add: ");
        String item = scanner.nextLine();
        items[count] = item;
        count++;
        System.out.println(item + " added to the list.");
    }

    private static void displayItems() {
        if (count == 0) {
            System.out.println("Grocery list is empty.");
            return;
        }
        System.out.println("\nYour Grocery List:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + items[i]);
        }
    }

    private static void searchItem() {
        System.out.print("Enter item to search: ");
        String item = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (items[i].equalsIgnoreCase(item)) {
                System.out.println(item + " found at position " + (i + 1));
                found = true;
                break;
            }
        }
        if (!found) System.out.println(item + " not found in the list.");
    }

    private static void updateItem() {
        System.out.print("Enter item to update: ");
        String item = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (items[i].equalsIgnoreCase(item)) {
                System.out.print("Enter new item name: ");
                items[i] = scanner.nextLine();
                System.out.println("Item updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) System.out.println(item + " not found in the list.");
    }

    private static void deleteItem() {
        System.out.print("Enter item to delete: ");
        String item = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (items[i].equalsIgnoreCase(item)) {
                for (int j = i; j < count - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[count - 1] = null;
                count--;
                System.out.println(item + " removed from the list.");
                found = true;
                break;
            }
        }
        if (!found) System.out.println(item + " not found in the list.");
    }

    private static void countItems() {
        System.out.println("Total items in the list: " + count);
    }

    private static void sortItems() {
        if (count == 0) {
            System.out.println("Grocery list is empty.");
            return;
        }
        String[] sortedItems = Arrays.copyOf(items, count);
        Arrays.sort(sortedItems, String.CASE_INSENSITIVE_ORDER);
        System.out.println("\nSorted Grocery List:");
        for (int i = 0; i < sortedItems.length; i++) {
            System.out.println((i + 1) + ". " + sortedItems[i]);
        }
    }
}
