public class DeluxeRoom extends Room {
    public DeluxeRoom(String id) { super(id); }
    public double calculatePrice(long nights) { return nights * 130.0; }
}
