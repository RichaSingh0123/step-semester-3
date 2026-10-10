public class DeliveryDrone extends Drone implements Trackable {
    private final String id;

    public DeliveryDrone(String id) {
        this.id = id;
    }

    @Override
    public String fly() {
        return id + " flying to delivery destination";
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}
