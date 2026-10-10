import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        HotelBookingService service = new HotelBookingService();
        Customer a = new Customer("Customer A"), b = new Customer("Customer B"), c = new Customer("Customer C");
        Room standard = new StandardRoom("101"), deluxe = new DeluxeRoom("201");
        LocalDate start = LocalDate.of(2026, 1, 1), end = LocalDate.of(2026, 1, 5);
        System.out.println("Standard Room 101 is " + (service.isAvailable(standard, start, end) ? "available" : "not available") + " from " + start + " to " + end + ".");
        Reservation r = service.reserve(a, standard, start, end, LocalDate.of(2025, 12, 25));
        service.reserve(b, standard, LocalDate.of(2026, 1, 3), LocalDate.of(2026, 1, 7), LocalDate.of(2025, 12, 25));
        r.cancel(LocalDate.of(2025, 12, 20));
        service.reserve(c, deluxe, LocalDate.of(2026, 2, 10), LocalDate.of(2026, 2, 12), LocalDate.of(2026, 2, 1));
    }
}
