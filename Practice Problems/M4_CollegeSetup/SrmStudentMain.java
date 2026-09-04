public class SrmStudentMain {

    static class SrmStudent {
        private static String collegeName;
        private static String academicYear;
        private String studentName;

        static {
            collegeName = "SRM Institute of Science and Technology";
            academicYear = "2026-2027";
            System.out.println("College info loaded");
        }

        public SrmStudent(String studentName) {
            this.studentName = studentName;
        }

        public void printConfirmation() {
            System.out.println("Student record created: " + studentName);
        }
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        createStudentBatch(names);
    }

    private static void createStudentBatch(String[] names) {
        for (String name : names) {
            SrmStudent student = new SrmStudent(name);
            student.printConfirmation();
        }
    }
}
