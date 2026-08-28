class PlacementRecordData {
    String studentName;
    String company;
    double packageLpa;

    PlacementRecordData(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class PlacementRecordMain {
    public static void main(String[] args) {
        PlacementRecordData[] records = {
            new PlacementRecordData("Ravi", "TCS", 4.5),
            new PlacementRecordData("Anitha", "Zoho", 6.2),
            new PlacementRecordData("Karthik", "Infosys", 4.0)
        };

        for (PlacementRecordData record : records) {
            record.printRecord();
        }
    }
}