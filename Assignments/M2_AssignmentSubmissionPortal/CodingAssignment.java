import java.time.LocalDate;
public class CodingAssignment extends Assignment {
    public CodingAssignment(String title, double maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }
    @Override public double applyLatePenalty(double marks, long days) {
        return Math.max(0, marks * (1 - 0.10 * days));
    }
}
