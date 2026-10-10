public abstract class Question {
    private final String id;
    private final String prompt;
    private final int points;
    public Question(String id, String prompt, int points) {
        this.id = id; this.prompt = prompt; this.points = points;
    }
    public String getId() { return id; }
    public String getPrompt() { return prompt; }
    public int getPoints() { return points; }
    public abstract boolean isCorrect(String answer);
}
