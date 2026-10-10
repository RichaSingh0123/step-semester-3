public class Suite extends Room {
    public Suite(String id) { super(id); }
    public double calculatePrice(long nights) { return nights * 220.0; }
}
