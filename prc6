import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

public class Library {
    private static final int MAX_BOOKS = 100;
    private Book[] books;
    private int numBooks;

    public Library() {
        this.books = new Book[MAX_BOOKS];
        this.numBooks = 0;
    }

    public void addBook(Book book) {
        if (numBooks < MAX_BOOKS) {
            books[numBooks] = book;
            numBooks++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Cannot add more books. Library is full.");
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book != null && book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    public void lendBook(String title) {
        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("You have borrowed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Sorry, the book is not available.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("You have returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("You did not borrow this book from our library.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("Book1", "Author1"));
        library.addBook(new Book("Book2", "Author2"));
        library.addBook(new Book("Book3", "Author3"));

        int choice;
        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display available books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book you want to borrow: ");
                    scanner.nextLine(); // Consume newline
                    String borrowTitle = scanner.nextLine();
                    library.lendBook(borrowTitle);
                    break;
                case 3:
                    System.out.print("Enter the title of the book you want to return: ");
                    scanner.nextLine(); // Consume newline
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 4:
                    System.out.println("Thank you for using the Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
        scanner.close();
    }
}
