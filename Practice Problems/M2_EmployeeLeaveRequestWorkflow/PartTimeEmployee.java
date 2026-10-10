public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name) { super(name); }
    public boolean canRequestLeave(int days) { return days > 0 && days <= 15; }
}
