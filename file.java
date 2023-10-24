package FileManagerProject;
import java.util.Scanner;

class file{

    public static void main(String[] args) {
        System.out.println("**************************************************** Welcome to File Manager ****************************************");
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Which operation you would like to perform: ");
            System.out.println("1. Listing all files present in the root directory");
            System.out.println("2. Creating a file or a Dictionary");
            System.out.println("3. Rename a file or Directory");
            System.out.println("4. Copy a file or Directory to other location");
            System.out.println("5. Moving the file or Directory from one place to other");
            System.out.println("6. Deleting the file or Directory");
            System.out.println("7. Exit");
            System.out.print("Enter the S.no of Operation: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    FileManagerProject.function.list();
                    break;
                case 2:
                    System.out.println("What you would like to create: ");
                    System.out.println("1. File");
                    System.out.println("2. Directory");
                    System.out.print("1 -> File, 2. -> Directory : ");
                    int a = sc.nextInt();
                    if(a==1){
                        FileManagerProject.function.createFile();
                        break;
                    }
                    else if (a == 2) {
                        FileManagerProject.function.createDir();
                        break;
                    }
                    else {
                        System.out.println("Enter a valid value.");
                        break;
                    }
                case 3:
                    FileManagerProject.function.rename();
                    break;
                case 4:
                    FileManagerProject.function.copy();
                    break;
                case 5:
                    FileManagerProject.function.move();
                    break;
                case 6:
                    FileManagerProject.function.delete();
                    break;
                case 7:
                    FileManagerProject.function.exit();
                    break;
                default:
                    System.out.println("Enter a valid Input\n");
                    break;
            }
            System.out.println("\n");
        }
    }
}
