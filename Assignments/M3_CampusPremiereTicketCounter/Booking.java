import java.util.List;
public class Booking {
    private final Customer customer;
    private final Show show;
    private final List<Seat> seats;
    private boolean cancelled;
    public Booking(Customer customer, Show show, List<Seat> seats) {
        if (seats == null || seats.isEmpty() || seats.size() > 6)
            throw new IllegalArgumentException("A booking must contain 1 to 6 seats.");
        this.customer = customer; this.show = show; this.seats = List.copyOf(seats);
    }
    public List<Seat> getSeats() { return seats; }
    public double total() { return seats.stream().mapToDouble(Seat::getPrice).sum(); }
    public boolean confirm() {
        if (show.reserveSeats(this)) {
            System.out.printf("Booking confirmed for %s: %s. Total: ₹%.2f.%n",
                customer.getName(),
                String.join(", ", seats.stream().map(Seat::getSeatId).toList()), total());
            return true;
        }
        return false;
    }
    public void cancel() {
        if (cancelled) { System.out.println("Booking already cancelled."); return; }
        if (show.isStarted()) { System.out.println("Cannot cancel after the show starts."); return; }
        show.releaseSeats(this); cancelled = true;
        System.out.println(customer.getName() + "'s booking cancelled. Seats " +
            String.join(", ", seats.stream().map(Seat::getSeatId).toList()) + " released.");
    }
}
