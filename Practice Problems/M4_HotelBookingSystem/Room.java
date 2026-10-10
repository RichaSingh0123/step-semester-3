public abstract class Room {
    private final String roomId;
    public Room(String roomId) { this.roomId = roomId; }
    public String getRoomId() { return roomId; }
    public abstract double calculatePrice(long nights);
}
