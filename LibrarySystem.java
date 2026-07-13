import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}

public class LibrarySystem {
    static ArrayList<Book> library = new ArrayList<>();
    static int bookCount = 0;
    static Scanner scanner = new Scanner(System.in);

    static void header() {
        System.out.println("\n===================================================");
        System.out.println("               LIBRARY MANAGEMENT SYSTEM           ");
        System.out.println("===================================================");
    }

    static void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Add a Book");
        System.out.println("2. Display All Books");
        System.out.println("3. Search for a Book");
        System.out.println("4. Delete a Book");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addBook() {
        if (bookCount >= 100) {
            System.out.println("\nLibrary is full! Cannot add more books.");
            return;
        }

        scanner.nextLine();

        System.out.print("\nEnter the title of the book: ");
        String title = scanner.nextLine();

        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();

        library.add(new Book(++bookCount, title, author));
        System.out.println("\nBook added successfully!");
    }

    static void displayBooks() {
        if (library.isEmpty()) {
            System.out.println("\nNo books in the library.");
            return;
        }

        System.out.println("\nBooks in the Library:");
        System.out.println("ID\tTitle\t\tAuthor");
        System.out.println("-----------------------------------");

        for (Book book : library) {
            System.out.printf("%d\t%s\t\t%s\n", book.id, book.title, book.author);
        }
    }

    static void searchBook() {
        if (library.isEmpty()) {
            System.out.println("\nNo books in the library to search.");
            return;
        }

        scanner.nextLine();

        System.out.print("\nEnter the title of the book to search: ");
        String searchTitle = scanner.nextLine();

        for (Book book : library) {
            if (book.title.equalsIgnoreCase(searchTitle)) {
                System.out.println("\nBook Found:");
                System.out.println("ID: " + book.id);
                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                return;
            }
        }

        System.out.println("\nBook not found.");
    }

    static void deleteBook() {
        if (library.isEmpty()) {
            System.out.println("\nNo books in the library to delete.");
            return;
        }

        System.out.print("\nEnter the ID of the book to delete: ");
        int deleteId = scanner.nextInt();

        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).id == deleteId) {
                library.remove(i);
                System.out.println("\nBook deleted successfully!");
                return;
            }
        }

        System.out.println("\nBook not found.");
    }

    public static void main(String[] args) {
        int choice;

        do {
            header();
            displayMenu();

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    System.out.println("\nExiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }

            if (choice != 5) {
                System.out.println("\nPress Enter to return to the menu...");
                scanner.nextLine();
                scanner.nextLine();
            }

        } while (choice != 5);

        scanner.close();
    }
}
