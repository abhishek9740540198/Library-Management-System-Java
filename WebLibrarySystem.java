import java.util.ArrayList;
import java.util.Scanner;

class WebBook {
    int id;
    String title;
    String author;

    WebBook(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}

public class WebLibrarySystem {
    static ArrayList<WebBook> library = new ArrayList<>();
    static int nextId = 1;
    static Scanner scanner = new Scanner(System.in);

    static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter author: ");
        String author = scanner.nextLine().trim();

        if (!title.isEmpty() && !author.isEmpty()) {
            library.add(new WebBook(nextId++, title, author));
            System.out.println("Book \"" + title + "\" by " + author + " added successfully!");
        } else {
            System.out.println("Please enter both the title and author.");
        }
    }

    static void displayBooks() {
        if (library.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("ID\tTitle\t\tAuthor");

        for (WebBook book : library) {
            System.out.println(book.id + "\t" + book.title + "\t\t" + book.author);
        }
    }

    static void searchBook() {
        System.out.print("Enter book title to search: ");
        String query = scanner.nextLine().trim().toLowerCase();

        for (WebBook book : library) {
            if (book.title.toLowerCase().equals(query)) {
                System.out.println("Found: \"" + book.title + "\" by " + book.author);
                return;
            }
        }

        System.out.println("Book not found.");
    }

    static void deleteBook() {
        System.out.print("Enter ID of book to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).id == id) {
                WebBook removed = library.remove(i);
                System.out.println("Book \"" + removed.title + "\" deleted successfully!");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            choice = Integer.parseInt(scanner.nextLine());

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
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
