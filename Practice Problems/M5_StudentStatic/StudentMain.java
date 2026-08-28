class StudentData {
    String name;
    double attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    StudentData(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class StudentMain {
    public static void main(String[] args) {
        new StudentData("Ravi", 92.5);
        new StudentData("Anitha", 88.0);

        StudentData.printCollegeInfo();
    }
}