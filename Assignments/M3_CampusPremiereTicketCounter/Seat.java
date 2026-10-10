public abstract class Seat {
    private final String seatId;
    public Seat(String seatId) { this.seatId = seatId; }
    public String getSeatId() { return seatId; }
    public abstract double getPrice();
}
