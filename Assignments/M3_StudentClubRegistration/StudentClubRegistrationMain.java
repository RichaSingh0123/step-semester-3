import java.util.*;

public class StudentClubRegistrationMain {
    static class Student {
        String rollNumber, name;
        Student(String rollNumber, String name) {
            this.rollNumber = rollNumber;
            this.name = name;
        }
        @Override public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Student)) return false;
            Student other = (Student) obj;
            return rollNumber.equals(other.rollNumber);
        }
        @Override public int hashCode() {
            return Objects.hash(rollNumber);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> members = new LinkedHashSet<>();
        List<String> containsResults = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\\s+", 3);
            if (p.length < 2) continue;
            String operation = p[0];
            String roll = p[1];
            String name = p.length == 3 ? p[2] : "";

            if (operation.equals("ADD")) {
                Student s = new Student(roll, name);
                if (members.add(s)) System.out.println("Added");
                else System.out.println("duplicate rejected");
            } else if (operation.equals("CONTAINS")) {
                containsResults.add("contains: " + members.contains(new Student(roll, name)));
            }
        }

        System.out.println("member count " + members.size());
        for (String result : containsResults) System.out.println(result);
        sc.close();
    }
}
