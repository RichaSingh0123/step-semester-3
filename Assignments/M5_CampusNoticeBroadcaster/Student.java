import java.util.List;
public class Student {
    private final String name, department;
    private final List<NotificationChannel> channels;
    public Student(String name, String department, List<NotificationChannel> channels) {
        this.name = name; this.department = department; this.channels = List.copyOf(channels);
    }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public List<NotificationChannel> getChannels() { return channels; }
}
