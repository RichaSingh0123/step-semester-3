import java.time.LocalDate;
public class Reservation {
    private final Customer customer;
    private final Room room;
    private final LocalDate start, end, cancellationDeadline;
    private boolean cancelled;
    public Reservation(Customer customer, Room room, LocalDate start, LocalDate end, LocalDate deadline) {
        if (!end.isAfter(start)) throw new IllegalArgumentException("End date must be after start date.");
        this.customer = customer; this.room = room; this.start = start; this.end = end; this.cancellationDeadline = deadline;
    }
    public Room getRoom() { return room; }
    public LocalDate getStart() { return start; }
    public LocalDate getEnd() { return end; }
    public boolean isCancelled() { return cancelled; }
    public double price() { return room.calculatePrice(java.time.temporal.ChronoUnit.DAYS.between(start, end)); }
    public boolean overlaps(LocalDate s, LocalDate e) { return !cancelled && start.isBefore(e) && s.isBefore(end); }
    public void cancel(LocalDate today) {
        if (cancelled) { System.out.println("Reservation already cancelled."); return; }
        if (today.isAfter(cancellationDeadline)) { System.out.println("Cancellation deadline has passed."); return; }
        cancelled = true;
        System.out.println("Reservation for " + customer.getName() + ", " + room.getClass().getSimpleName() +
            " " + room.getRoomId() + " (" + start + "-" + end + ") cancelled successfully.");
    }
    public Customer getCustomer() { return customer; }
}
