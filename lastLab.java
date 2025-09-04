import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class lastLab {
    static Scanner input=new Scanner(System.in);
    public static void main(String [] Args){
        System.out.println("\n-------------Welcome to file handling portion--------------");
        String history="";
        int count=1;
        while(true){
            System.out.println("\n-----------------------------------------------");
            System.out.println("1.Create new file.\n2.Enter data i.e.,Studrnt id,Age and Name. .\n3.read data.\n4.Find specific record by id.\n5.Enter data of any type.\n6.Return to main menu.");
            System.out.println("-----------------------------------------------");
            System.out.print("Enter your choice here: ");
            String choice=input.nextLine();
            if(choice.equals("1")){
                history="Create new file";
                CreateNewFile();
            }
            else if(choice.equals("2")){
                String name="";
                while(true){
                    history="Enter data in file(Student id, Age and Name)";
                    System.out.print("Enter name of file:");
                    name=input.nextLine();
                    if(checkFileExist(name)){
                        enterStudentData(name);
                        break;
                    }
                    else{
                        while(true){
                            System.out.print("File does not exist.\n1.Plz create new file.\n2.Plz enter name again.\nEnter your choice here:");
                            String choice1=input.nextLine();
                            if(choice1.equals("1")){
                                CreateNewFile();
                                break;
                            }
                            else if(choice1.equals("2"))
                                break;
                            else
                                System.out.print("Invalid choice.");
                        }
                    }
                }
            }
            else if(choice.equals("3")){
                history="Read data from file";
                while(true){
                    System.out.print("Enter name of file:");
                    String name=input.nextLine();
                    if(checkFileExist(name)){
                        readData(name);
                        break;
                    }
                    else{
                        while(true){
                            System.out.print("File does not exist.\n1.Plz create new file.\n2.Plz enter name again.\nEnter your choice here:");
                            String choice1=input.nextLine();
                            if(choice1.equals("1")){
                                CreateNewFile();
                                break;
                            }
                            else if(choice1.equals("2"))
                                break;
                            else
                                System.out.print("Invalid choice.");
                        }
                    }
                }
            }
            else if(choice.equals("4")){
                while(true){
                    history="Find record by id";
                    System.out.print("Enter file name:");
                    String name=input.nextLine();
                    if(checkFileExist(name)){
                        findRecord(name);
                        break;
                    }
                    else{
                        while(true){
                            System.out.print("File does not exist.\n1.Plz create new file.\n2.Plz enter name again.\nEnter your choice here:");
                            String choice1=input.nextLine();
                            if(choice1.equals("1")){
                                CreateNewFile();
                                break;
                            }
                            else if(choice1.equals("2"))
                                break;
                            else
                                System.out.print("Invalid choice.");
                        }
                    }
                }
            }
            else if(choice.equals("5")){
                while(true){
                    System.out.print("Enter file name:");
                    String name=input.nextLine();
                    if(checkFileExist(name)){
                        enterData(name);
                        break;
                    }
                    else{
                        while(true){
                            System.out.print("File does not exist.\n1.Plz create new file.\n2.Plz enter name again.\nEnter your choice here:");
                            String choice1=input.nextLine();
                            if(choice1.equals("1")){
                                CreateNewFile();
                                break;
                            }
                            else if(choice1.equals("2"))
                                break;
                            else
                                System.out.print("Invalid choice.");
                        }
                    }
                }
            }
            else if(choice.equals("6"))
                break;
            else{
                System.out.print("Invalid choice.\n Plz choose again");
                history="Invalid choice";
            }

            try (FileWriter fileWriter = new FileWriter("History.txt", true)){
                fileWriter.write("\t"+count+"."+history+"\n");
            }
            catch(Exception e){
                System.out.println(e);
            }
            count++;
        }
    }

    public static void CreateNewFile(){
        while(true){
            System.out.println("Enter path for your new file");
            String path=input.nextLine();
            File myfile=new File(path);
            if(myfile.exists()){
                System.out.println("File already exists");
                System.out.println("Enter path again.");
            }
            else{
                try{
                    myfile.createNewFile();
                    System.out.println("File created successfully");
                    break;
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    public static void enterStudentData(String name){
        String Id;
        String Sname;
        String age;
        String choice="";
        while(true){
            if (choice.equals("0"))
                break;
            else{
                System.out.print("Enter id of student:");
                Id=input.nextLine();
                System.out.print("Enter name of student:");
                Sname=input.nextLine();
                System.out.print("Enter age of student:");
                age=input.nextLine();
                try (FileWriter fileWriter = new FileWriter(name, true)) {
                    fileWriter.write(Id + "    " + Sname + "         " + age + "\n");
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            System.out.print("Enter 0 to exit and any button to enter next data:");
            choice=input.nextLine();
        }
    }

    public static void readData(String name){
        File myFile=new File(name);
        try{
            Scanner sc=new Scanner(myFile);
            while (sc.hasNextLine()) {
                String Line=sc.nextLine();
                System.out.println(Line);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void findRecord(String name){
        File myFile=new File(name);
        System.out.print("Enter id");
        String id=input.nextLine();
        try{
            Scanner sc=new Scanner(myFile);
            while (sc.hasNextLine()) {
                String Line=sc.nextLine();
                String subString=(Line.substring(0,3)).trim();
                if (subString.equals(id)){
                    System.out.println("ID    Student Name   Age");
                    System.out.println(Line);
                }
                else;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean checkFileExist(String name){
        File myFile=new File(name);
        if(myFile.exists())
            return true;
        else
            return false;
    }

    public static void enterData(String name){
        String data;
        String choice="";
        while(true){
            if (choice.equals("0"))
                break;
            else{
                System.out.print("Enter data:");
                data=input.nextLine();
                try (FileWriter fileWriter = new FileWriter(name, true)) {
                    fileWriter.write(data + "\n");
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            System.out.print("Enter 0 to exit and any button to enter next data:");
            choice=input.nextLine();
        }
    }
}



