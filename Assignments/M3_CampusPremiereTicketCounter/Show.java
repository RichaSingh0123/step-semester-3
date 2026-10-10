import java.util.HashSet;
import java.util.Set;
public class Show {
    private final String time;
    private final Set<String> bookedSeatIds = new HashSet<>();
    private boolean started;
    public Show(String time) { this.time = time; }
    public String getTime() { return time; }
    public boolean isStarted() { return started; }
    public void startShow() { started = true; }
    public boolean reserveSeats(Booking booking) {
        for (Seat seat : booking.getSeats()) {
            if (bookedSeatIds.contains(seat.getSeatId())) {
                System.out.println("Seat " + seat.getSeatId() + " is already booked for this show.");
                return false;
            }
        }
        for (Seat seat : booking.getSeats()) bookedSeatIds.add(seat.getSeatId());
        return true;
    }
    public void releaseSeats(Booking booking) {
        for (Seat seat : booking.getSeats()) bookedSeatIds.remove(seat.getSeatId());
    }
}
