import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Select option you would like to do:");
        System.out.println("1) Multiple File Rename");
        Scanner userIn = new Scanner(System.in);
        try {
            int option = userIn.nextInt();
            switch (option) {
                case 1:
                    multiRename();
                default:
                    System.out.println("Enter Valid Number");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void multiRename(){

    }
}
