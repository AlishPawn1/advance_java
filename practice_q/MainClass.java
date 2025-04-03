package practice_q;

public class MainClass {
    public MainClass() {
        try {
            new Create_table();
//            Add_data addData = new Add_data();
//            addData.insertStudent(5, "Ronit Chauguthi", "Bachelor", "B", "BCA");
            View_details viewDetails = new View_details();
            viewDetails.listUser(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
