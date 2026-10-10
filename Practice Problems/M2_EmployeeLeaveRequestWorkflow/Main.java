public class Main {
    public static void main(String[] args) {
        LeaveRequest john = new LeaveRequest(new FullTimeEmployee("John"), "Jan 1-5", 5);
        john.review(true, "Alice");
        LeaveRequest jane = new LeaveRequest(new PartTimeEmployee("Jane"), "Feb 10-11", 2);
        jane.review(false, "Bob");
        john.setStatus(LeaveRequest.Status.PENDING);
    }
}
