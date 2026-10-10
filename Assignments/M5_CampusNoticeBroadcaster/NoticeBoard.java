import java.util.List;
public class NoticeBoard {
    private final List<Student> students;
    public NoticeBoard(List<Student> students) { this.students = List.copyOf(students); }
    public void post(Notice notice) {
        System.out.println("Notice '" + notice.getTitle() + "' posted to " +
            String.join(", ", notice.getDepartments()) + ".");
        for (Student student : students) {
            if (notice.getDepartments().contains(student.getDepartment())) {
                for (NotificationChannel channel : student.getChannels()) {
                    channel.send(student, notice.getTitle());
                }
            }
        }
    }
}
