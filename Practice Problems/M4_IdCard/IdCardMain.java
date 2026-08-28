class IdCardData {
    String name;
    int booksIssued;

    IdCardData(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class IdCardMain {
    public static void main(String[] args) {
        IdCardData ravi = new IdCardData("Ravi", 0);
        IdCardData duplicate = ravi;

        duplicate.booksIssued = 3;

        IdCardData separate = new IdCardData("Ravi", 3);

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}