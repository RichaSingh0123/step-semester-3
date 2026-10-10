public class Contractor extends Employee {
    public Contractor(String name) { super(name); }
    public boolean canRequestLeave(int days) { return days > 0 && days <= 5; }
}
