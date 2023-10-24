package FileManagerProject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class function {
    static Scanner sc = new Scanner(System.in);
    public static List<String> curdir = new ArrayList<>();
//........................................................................................................................
    public static void list(){
        File fl = new File(System.getProperty("user.dir"));
        curdir.clear();
        String[] files = fl.list();
        if(files != null){
            for(String s : files){
                curdir.add(s);
                System.out.println(s);
            }
        }
    }
    //.................................................................................................................
    public static void createFile(){
        System.out.print("Enter the name of file: ");
//        String a = sc.next();
        String a = new String();
        a = sc.next();
        File new_file = new File(a);
        try{
            if(new_file.createNewFile()){
                System.out.println("Your file has been created successfully\n");
                curdir.add(a);
            }
            else{
                System.out.println("Failed to create.\n");
            }
        } catch (IOException e){
            System.out.println("Error in creating file " + e.getMessage());
        }
    }

    public static void createDir(){
        System.out.print("Enter the name of directory: ");
        String a = sc.next();
        File newDir = new File(a);
        if(newDir.mkdir()){
            System.out.println("Your Directory has been created successfully\n");
        }
        else{
            System.out.println("Failed to create the file.\n");
        }
    }
//..............................................................................................................
    public static void exit() {
        System.out.println("Thank You for giving us chance to serve you");
        System.out.println("Feel free to come back again.\n");
    }
//.........................................................................................................
    public static void rename(){

        System.out.print("\nEnter the current name of the file or directory: ");
        String old_Name = sc.next();
        System.out.print("Enter the new name: ");
        String new_Name = sc.next();

        File old = new File(old_Name);
        File New = new File(new_Name);

        if (old.renameTo(New)) {
            System.out.println("File Renamed successfully.");
            curdir.remove(old_Name);
            curdir.add(new_Name);
        } else {
            System.out.println("Failed to rename the file");
        }
    }
    //............................................................................................................................
    public static void copy(){
        System.out.println("Enter the source File (File or Directory) Name: ");
        String source_file = sc.next();
        System.out.println("Enter the destination directory: ");
        String destination_file = sc.next();

        File source = new File(source_file);
        File destination = new File(destination_file, source.getName());
        try{
            if(source.isFile()){
                Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("File copied successfully.\n");
                    curdir.add(destination.getName());
            } else if (source.isDirectory()) {
                 copyDirectory(source.toPath(), destination.toPath());
                System.out.println("Directory copied successfully.\n");
                curdir.add(destination.getName());
            }
        }catch (IOException e){
            System.out.println("An Error Occured: "+e.getMessage());
        }
    }

    public static void copyDirectory(java.nio.file.Path source, java.nio.file.Path destination) throws IOException{
        // complete this function.
    }
    //...........................................................................................................
    public static void move(){
        System.out.println("Enter file or directory to be moved: ");
        String sr_file = sc.next();
        System.out.println("Enter the directory where to move: ");
        String d_file = sc.next();

        File source = new File(sr_file);
        File destination = new File(d_file, source.getName());
        if(source.renameTo(destination)){
            System.out.println("File Moved Successfully\n");
        }
        else{
            System.out.println("Failed to move the File\n");
        }
    }
    //.................................................................................................
    public static void delete(){
        System.out.println("Enter the file to be deleted: ");
        String f = sc.next();
        File target = new File(f);
        if(target.isDirectory() || target.isFile()){
            if(del(target)){
                System.out.println("File Deleted Successfully");
            }
            else{
                System.out.println("Error in deleting the file");
            }
        }
        else{
            System.out.println("File Not found.");
        }
    }

    public static boolean del(File a){
        if(a.isDirectory()){
            File[] array = a.listFiles();
            if(array != null){
                for(File i : array){
                    if(!del(i)){
                        return false;
                    }
                }
            }
        }
        return a.delete();
    }
}
