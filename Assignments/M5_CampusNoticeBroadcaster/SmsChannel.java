public class SmsChannel implements NotificationChannel {
    public String getName() { return "SMS"; }
    public void send(Student student, String message) {
        System.out.println("[SMS → " + student.getName() + "] " + message);
    }
}
