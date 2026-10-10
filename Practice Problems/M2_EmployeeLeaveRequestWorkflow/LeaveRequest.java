public class LeaveRequest {
    public enum Status { PENDING, APPROVED, REJECTED }
    private final Employee employee;
    private final String dates;
    private Status status = Status.PENDING;
    public LeaveRequest(Employee employee, String dates, int days) {
        if (!employee.canRequestLeave(days)) throw new IllegalArgumentException("Leave request violates policy.");
        this.employee = employee; this.dates = dates;
        System.out.println("Leave request submitted for " + employee.getName() + " (" + dates + "). Status: Pending.");
    }
    public void review(boolean approve, String reviewer) {
        if (status != Status.PENDING) {
            System.out.println("Cannot change leave request status from " + status + ".");
            return;
        }
        status = approve ? Status.APPROVED : Status.REJECTED;
        System.out.println(employee.getName() + "'s leave request (" + dates + ") " +
            (approve ? "approved" : "rejected") + " by " + reviewer + ". Status: " + status + ".");
    }
    public void setStatus(Status requested) {
        if (status != Status.PENDING || requested == Status.PENDING) {
            System.out.println("Cannot change leave request status from " + status + " to " + requested + ".");
            return;
        }
        status = requested;
    }
}
