class BookInventoryData {
    String title;
    String author;
    int copiesAvailable;

    BookInventoryData(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }
}

public class BookInventoryMain {
    public static void main(String[] args) {
        BookInventoryData[] books = {
            new BookInventoryData("Clean Code", "Robert C. Martin", 3),
            new BookInventoryData("Effective Java", "Joshua Bloch", 5),
            new BookInventoryData("Refactoring", "Martin Fowler", 0),
            new BookInventoryData("Design Patterns", "GoF", 2)
        };

        for (BookInventoryData book : books) {
            book.printEntry();
        }
    }
}