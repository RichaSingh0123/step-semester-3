public class AppChannel implements NotificationChannel {
    public String getName() { return "App"; }
    public void send(Student student, String message) {
        System.out.println("[App → " + student.getName() + "] " + message);
    }
}
