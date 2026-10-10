import java.time.LocalDate;
public abstract class Assignment {
    private final String title;
    private final double maxMarks;
    private final LocalDate dueDate;
    public Assignment(String title, double maxMarks, LocalDate dueDate) {
        this.title = title; this.maxMarks = maxMarks; this.dueDate = dueDate;
    }
    public String getTitle() { return title; }
    public double getMaxMarks() { return maxMarks; }
    public LocalDate getDueDate() { return dueDate; }
    public abstract double applyLatePenalty(double awardedMarks, long lateDays);
}
