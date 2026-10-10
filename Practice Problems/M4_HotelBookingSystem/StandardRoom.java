public class StandardRoom extends Room {
    public StandardRoom(String id) { super(id); }
    public double calculatePrice(long nights) { return nights * 80.0; }
}
