class HallTicketData {
    String studentName;
    int seatNumber;

    HallTicketData(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class HallTicketMain {
    public static void main(String[] args) {
        HallTicketData priya = new HallTicketData("Priya", 0);
        HallTicketData copy = priya;

        copy.seatNumber = 45;

        HallTicketData separate = new HallTicketData("Priya", 45);

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}