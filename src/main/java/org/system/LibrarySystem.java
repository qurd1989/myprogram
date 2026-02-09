package org.system;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.Scanner;


public class LibrarySystem {

    @Getter
    @AllArgsConstructor
    static class Book {
        private final String title;
        private final String author;
        private  int quantity;

        public void addQuantity(int amount) {
            this.quantity += amount;
        }

        public boolean borrowQuantity(int amount) {
            if (amount <= quantity) {
                this.quantity -= amount;
                return true;
            }
            return false;
        }
    }
    private static String normalizeTitle(String title) {
        return title.trim().toLowerCase();
    }
    private static int readPositiveInt(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            try{
                int value  = Integer.parseInt(input);
                if (value <= 0) {
                    System.out.println("Error: Please enter a positive integer.");
                }else  {
                    return value;
                }
            }catch (NumberFormatException e){
                System.out.println("Error: Invalid input. Please enter a positive integer.");
            }
        }
    }
    private static int readMenuChoice(Scanner scanner) {
        while (true) {
            System.out.println("Choose an option (1-4):");
            String input = scanner.nextLine().trim();
            try{
                int choice = Integer.parseInt(input);
                if(choice < 1 || choice > 4){
                    System.out.println("Error: Please enter a number between 1 and 4.");
                }else {
                    return choice;
            }
        }catch (NumberFormatException e){
            System.out.println("Error: Invalid input. Please enter a number between 1 and 4.");
            }
        }
    }
    private static String readNonEmptyString(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please try again.");
            } else {
                return input;
            }
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ;
            var library = new java.util.HashMap<String, Book>();

            boolean running = true;

            while (running) {
                System.out.println("\n===== Library System Menu =====");
                System.out.println("1. Add Book");
                System.out.println("2. Borrow Book");
                System.out.println("3. Return Book");
                System.out.println("4. Exit");
                int choice = readMenuChoice(sc);
                switch (choice) {
                    case 1 -> {
                        String title = readNonEmptyString(sc, "Enter book title:");
                        String author = readNonEmptyString(sc, "Enter book author:");
                        int quantity = readPositiveInt(sc, "Enter quantity to add:");

                        String key = normalizeTitle(title);
                        if (library.containsKey(key)) {
                            library.get(key).addQuantity(quantity);
                            System.out.println("Updated quantity of existing book.");
                        } else {
                            library.put(key, new Book(title, author, quantity));
                            System.out.println("Added new book to the library.");
                        }
                    }
                    case 2 -> {
                        String title = readNonEmptyString(sc, "Enter book title to borrow:");
                        int borrowQuantity = readPositiveInt(sc, "Enter quantity to borrow:");
                        String key = normalizeTitle(title);
                        if (!library.containsKey(key)) {
                            System.out.println("Error: Book not found in the library.");
                        } else {
                            Book book = library.get(key);
                            if (book.borrowQuantity(borrowQuantity)) {
                                System.out.println("Successfully borrowed " + borrowQuantity + " copies of \"" + book.getTitle() + "\".");
                                System.out.println("Remaining quantity: " + book.getQuantity());
                            } else {
                                System.out.println("Error: Not enough copies available to borrow. Current quantity: " + book.getQuantity());
                            }
                        }
                    }
                    case 3 -> {
                        String title = readNonEmptyString(sc, "Enter book title to return:");
                        int returnQuantity = readPositiveInt(sc, "Enter quantity to return:");
                        String key = normalizeTitle(title);
                        if (!library.containsKey(key)) {
                            System.out.println("Error: Book not found in the library.");
                        } else {
                            Book book = library.get(key);
                            book.addQuantity(returnQuantity);
                            System.out.println("Successfully returned " + returnQuantity + " copies of \"" + book.getTitle() + "\".");
                            System.out.println("Current quantity: " + book.getQuantity());
                        }
                    }
                    case 4 -> {
                        System.out.println("Exiting the library system. Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid input. Please try again.");
                }
            }
        }
    }
}
