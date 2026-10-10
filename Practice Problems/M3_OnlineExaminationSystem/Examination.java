import java.util.List;
public class Examination {
    private final String title;
    private final List<Question> questions;
    public Examination(String title, List<Question> questions) {
        this.title = title; this.questions = List.copyOf(questions);
    }
    public String getTitle() { return title; }
    public List<Question> getQuestions() { return questions; }
}
