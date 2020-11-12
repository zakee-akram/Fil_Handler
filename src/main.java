import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.Scanner;
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
            unzip(chooser.getSelectedFile().getPath());
        }
        else{
            System.out.println("jpg selected");
        }
    }

    public static void unzip(String zFileName){
        String zippedFile = zFileName;
        InputStream input = main.class.getResourceAsStream("src/tempimage/");;
        System.out.println(input);
        // create output directory if it doesn't exist

        FileInputStream fis;
        byte[] buffer = new byte[1024];
        int counter =0 ;
        String userName ="";
        System.out.println("Enter file Name:");
        Scanner userIn = new Scanner(System.in);
        userName = userIn.nextLine();
        try {
            fis = new FileInputStream(zippedFile);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                counter =counter+1;
                String fileName = userName + "_" + counter+".jpg";
            //    String fileName = ze.getName();
                File newFile = new File("tempimages/"+userName + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }
