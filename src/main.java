import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class main {
    public static void main(String[] args) {
        System.out.println("Select option you would like to do:");
        System.out.println("1) Multiple File Rename");
        System.out.println("--------------------------------------");
        Scanner userIn = new Scanner(System.in);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){
            System.out.println(e);
        }
        try {
            int option = userIn.nextInt();
            switch (option) {
                case 1:
                    multiRename();
                    break;
                default:
                    System.out.println("Enter Valid Number");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void multiRename(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & zip Images", "jpg", "zip");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
        }
        String filename =chooser.getSelectedFile().getName().substring(chooser.getSelectedFile().getName().lastIndexOf("."));
        if(filename.equals(".zip")){
            System.out.println("Zip File Selected");
            unzip(filename);
        }
        else{
            System.out.println("jpg selected");
        }
    }

    public static void unzip(String zFileName){
        String zippedFile = zFileName;


    }
}
