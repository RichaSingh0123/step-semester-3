import java.util.*;
import java.util.regex.*;

public class ClassMarksGridMain {
    static class StudentMarks {
        String name;
        int[] marks;
        StudentMarks(String name, int[] marks) { this.name = name; this.marks = marks; }
        int total() { return marks[0] + marks[1] + marks[2]; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<StudentMarks> students = new ArrayList<>();
        Pattern pattern = Pattern.compile("^\\s*(\\S+)\\s*\\[\\s*(-?\\d+)\\s*,\\s*(-?\\d+)\\s*,\\s*(-?\\d+)\\s*\\]\\s*$");

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            Matcher m = pattern.matcher(line);
            if (!m.matches()) {
                System.out.println("Invalid input: " + line);
                continue;
            }
            students.add(new StudentMarks(m.group(1), new int[] {
                Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3)), Integer.parseInt(m.group(4))
            }));
        }

        if (students.isEmpty()) {
            System.out.println("No student records");
            sc.close();
            return;
        }

        int[] subjectTotals = new int[3];
        StudentMarks topper = students.get(0);
        System.out.print("Totals ");
        for (int i = 0; i < students.size(); i++) {
            StudentMarks s = students.get(i);
            subjectTotals[0] += s.marks[0];
            subjectTotals[1] += s.marks[1];
            subjectTotals[2] += s.marks[2];
            if (s.total() > topper.total()) topper = s;
            if (i > 0) System.out.print(", ");
            System.out.print(s.name + " " + s.total());
        }

        System.out.printf("%naverages %.2f, %.2f, %.2f%n",
            subjectTotals[0] / (double) students.size(),
            subjectTotals[1] / (double) students.size(),
            subjectTotals[2] / (double) students.size());
        System.out.println("topper " + topper.name + " (" + topper.total() + ")");
        sc.close();
    }
}
