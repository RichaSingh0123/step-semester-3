public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name) { super(name); }
    public boolean canRequestLeave(int days) { return days > 0 && days <= 30; }
}
