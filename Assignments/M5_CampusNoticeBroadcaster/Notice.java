import java.util.Set;
public class Notice {
    private final String title;
    private final Set<String> departments;
    public Notice(String title, Set<String> departments) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Notice title is required.");
        if (departments == null || departments.isEmpty())
            throw new IllegalArgumentException("At least one target department is required.");
        this.title = title; this.departments = Set.copyOf(departments);
    }
    public String getTitle() { return title; }
    public Set<String> getDepartments() { return departments; }
}
