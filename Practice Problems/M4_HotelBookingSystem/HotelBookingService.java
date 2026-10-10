import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class HotelBookingService {
    private final List<Reservation> reservations = new ArrayList<>();
    public boolean isAvailable(Room room, LocalDate start, LocalDate end) {
        return reservations.stream().noneMatch(r -> r.getRoom().getRoomId().equals(room.getRoomId()) && r.overlaps(start, end));
    }
    public Reservation reserve(Customer customer, Room room, LocalDate start, LocalDate end, LocalDate deadline) {
        if (!isAvailable(room, start, end)) {
            System.out.println(room.getClass().getSimpleName() + " " + room.getRoomId() + " is not available from " + start + " to " + end + ".");
            return null;
        }
        Reservation r = new Reservation(customer, room, start, end, deadline);
        reservations.add(r);
        System.out.println("Reservation confirmed for " + customer.getName() + ", " + room.getClass().getSimpleName() +
            " " + room.getRoomId() + " (" + start + "-" + end + "). Price: $" + String.format("%.2f", r.price()) + ".");
        return r;
    }
}
