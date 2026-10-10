public class WashingMachine {
    private final String id;
    private WashCycle activeCycle;
    public WashingMachine(String id) { this.id = id; }
    public String getId() { return id; }
    public boolean isFree() { return activeCycle == null; }

    public boolean startWash(Student student, WashType type) {
        if (!isFree()) {
            System.out.println("Machine " + id + " is currently busy.");
            return false;
        }
        activeCycle = new WashCycle(student, this, type);
        System.out.printf("%s wash started on %s for %s (%d min). Charge: ₹%.2f.%n",
            type.getName(), id, student.getName(), type.getDurationMinutes(), type.getCharge());
        return true;
    }

    public void completeCycle() {
        if (activeCycle == null) {
            System.out.println(id + " has no active cycle.");
            return;
        }
        System.out.println(id + " cycle completed.");
        activeCycle = null;
        System.out.println(id + " is now free.");
    }
}
