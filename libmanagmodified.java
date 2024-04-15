import java.util.Scanner;

interface LibraryOperations {
    void displayBooks();
    void borrowBook(String title) throws BookNotFoundException;
    void returnBook(String title) throws BookNotFoundException;
}

class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

public class LibraryBooks implements LibraryOperations {
    static final int MAX_BOOKS = 100;
    Book[] books;
    int numBooks;

    public class Book {
        String title;
        String author;
        boolean available;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.available = true;
        }
    }

    LibraryBooks() {
        books = new Book[MAX_BOOKS];
        numBooks = 0;
    }

    public void displayBooks() {
        if (numBooks == 0) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Library Books:");
            for (Book book : books) {
                if (book != null) {
                    System.out.println(book.title + " by " + book.author);
                }
            }
        }
    }

    public void borrowBook(String title) throws BookNotFoundException {
        for (Book book : books) {
            if (book != null && book.title.equalsIgnoreCase(title)) {
                if (book.available) {
                    book.available = false;
                    System.out.println("Borrowed: " + book.title);
                    return;
                } else {
                    throw new BookNotFoundException("Book '" + title + "' is not available for borrowing.");
                }
            }
        }
        throw new BookNotFoundException("Book '" + title + "' not found in the library.");
    }

    public void returnBook(String title) throws BookNotFoundException {
        for (Book book : books) {
            if (book != null && book.title.equalsIgnoreCase(title)) {
                book.available = true;
                System.out.println("Returned: " + book.title);
                return;
            }
        }
        throw new BookNotFoundException("Book '" + title + "' not found in the library.");
    }

    void addBook(Book book) {
        if (numBooks < MAX_BOOKS) {
            books[numBooks++] = book;
            System.out.println("Book Added: " + book.title);
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryBooks library = new LibraryBooks();

        library.addBook(library.new Book("Book1", "Author1"));
        library.addBook(library.new Book("Book2", "Author2"));
        library.addBook(library.new Book("Book3", "Author3"));

        char choice;
        do {
            System.out.println("\nLibrary Menu");
            System.out.println("1. Display all books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int menuChoice;
            while (true) {
                try {
                    menuChoice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            try {
                switch (menuChoice) {
                    case 1:
                        library.displayBooks();
                        break;
                    case 2:
                        System.out.print("Enter the title of the book you want to borrow: ");
                        String borrowTitle = scanner.nextLine();
                        library.borrowBook(borrowTitle);
                        break;
                    case 3:
                        System.out.print("Enter the title of the book you want to return: ");
                        String returnTitle = scanner.nextLine();
                        library.returnBook(returnTitle);
                        break;
                    case 4:
                        System.out.println("Thank you for using the Library.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (BookNotFoundException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Do you want to perform another operation? Enter Y/N: ");
            choice = scanner.nextLine().charAt(0);

        } while (Character.toUpperCase(choice) == 'Y');

        System.out.println("Exiting the Library.");
        scanner.close();
    }
}

