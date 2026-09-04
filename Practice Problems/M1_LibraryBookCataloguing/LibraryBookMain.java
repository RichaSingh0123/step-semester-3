public class LibraryBookMain {

    static class LibraryBook {
        private String title;
        private String isbn;
        private boolean catalogued;

        public LibraryBook(String title, String isbn) {
            this.title = title;
            this.isbn = isbn;
            this.catalogued = true;
        }

        public LibraryBook(String title) {
            this(title, "PENDING");
        }

        public void printStatus() {
            System.out.println(title + " | " + isbn + " | Catalogued: " + catalogued);
        }
    }

    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};

        processBooks(titles, isbns);
    }

    private static void processBooks(String[] titles, String[] isbns) {
        for (int index = 0; index < titles.length; index++) {
            LibraryBook book;

            if (isbns[index].isEmpty()) {
                book = new LibraryBook(titles[index]);
            } else {
                book = new LibraryBook(titles[index], isbns[index]);
            }

            book.printStatus();
        }
    }
}
