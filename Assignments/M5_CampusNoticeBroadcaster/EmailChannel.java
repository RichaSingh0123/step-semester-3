public class EmailChannel implements NotificationChannel {
    public String getName() { return "Email"; }
    public void send(Student student, String message) {
        System.out.println("[Email → " + student.getName() + "] " + message);
    }
}
