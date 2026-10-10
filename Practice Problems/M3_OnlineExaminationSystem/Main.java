import java.util.List;
public class Main {
    public static void main(String[] args) {
        Examination exam = new Examination("Exam A", List.of(
            new MultipleChoiceQuestion("Question 1", "Choose option", 5, "C"),
            new TrueFalseQuestion("Question 2", "Statement", 5, false)));
        Attempt a = new Attempt(new Student("Student 1"), exam);
        a.answer("Question 1", "C");
        a.answer("Question 2", "True");
        a.submit();
        a.answer("Question 1", "A");
    }
}
