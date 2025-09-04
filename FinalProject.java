import java.io.File;
import java.io.FileWriter;
import java.security.SecureRandom;
import java.util.Scanner;

class FinalProject{
    static String username;
    static String password;
    static Scanner input=new Scanner(System.in);
    public static void main(String []Args){
        System.out.println("\n----------Welcome------------");
        while(true){
            System.out.println("\n--------------------------");
            System.out.println("1.sign up.\n2.loggin.");
            System.out.println("--------------------------");
            System.out.print("Enter your choice here: ");
            String choice=input.nextLine();
            if(choice.equals("1")){
                toSignup();
                break;
            }
            else if(choice.equals("2")){
                toLoggin();
                break;
            }
            else
                System.out.println("Invalid choice plz select again");
        }
        int count=1;
        String history="";
        while(true){
            System.out.println("\n--------------------------");
            System.out.println("\n1.Calculator.\n2.Converter\n3.Games.\n4.Area Calculator.\n5.File Handling.\n6.Checker.\n7.See your History.\n8.Enter 8 to exit.");
            System.out.println("--------------------------");
            System.out.print("Enter your choice here: ");
            String choice=input.nextLine();
            if(choice.equals("1")){
                history="Calculator.^";
                writeToHistoryFile(count, history);
                Calculator.main(new String[]{});
            }
            else if(choice.equals("2")){
                history="Converter.";
                writeToHistoryFile(count, history);
                Converter.main(new String[]{});
            }
            else if(choice.equals("3")){
                history="Games.";
                writeToHistoryFile(count, history);
                Games.main(new String[]{});
            }
            else if(choice.equals("4")){
                history="AreaCalculator.";
                writeToHistoryFile(count, history);
                AreaCalculator.main(new String[]{});
            }
            else if(choice.equals("5")){
                history="File Handling.";
                writeToHistoryFile(count, history);
                lastLab.main(new String[]{});
            }
            else if(choice.equals("6")){
                history="Checker.";
                writeToHistoryFile(count, history);
                Checker.main(new String[]{});
            }
            else if(choice.equals("7")){
                history="See history";
                writeToHistoryFile(count, history);
                seeHistory(username,password);
            }
            else if(choice.equals("8")){
                try (FileWriter fileWriter = new FileWriter("History.txt", true)){
                    fileWriter.write("-------------------------------------------------------------------\n");
                }
                catch(Exception e){
                    System.out.println(e);
                }
                break;
            }
            else{
                history="Invalid Input";
                writeToHistoryFile(count, history);
                System.out.println("Invalid choice plz select again");
            }
            count++;
        }
    }
    public static void toSignup(){
        System.out.print("Enter username:");
        username=input.nextLine();
        // password="";
        String choice;
        while(true){
            System.out.print("1.Produce autopassword\n2.Make password\nEnter your choice here:");
            choice=input.nextLine();
            if(choice.equals("2")){
                while(true){
                    System.out.println("The minimum length of password should be 8 and it must contain a lowercase Character,An upercase character,a special character and a Number.");
                    System.out.print("Enter password here:");
                    password=input.nextLine();
                    if(passwordStrength(password)){
                        System.out.printf("Your account is generated.\nYour username is %s and password is %s",username,password);
                        break;
                    }
                    else
                        System.out.print("You enter a very weak password.Plz Enter Again.");
                }
                break;
            }
            else if(choice.equals("1")){
                password=generateAutoPassword();
                System.out.printf("Your account is generated.\nYour username is %s and password is %s",username,password);
                break;
            }
            else{
                System.out.print("Your choice is invalid plz select again");
            }
        }
        try (FileWriter fileWriter = new FileWriter("passwords.txt", true)){
            fileWriter.write(username+"  "+password+ "\n");
        }
        catch(Exception e){
            System.out.println(e);
        }

        try (FileWriter fileWriter = new FileWriter("History.txt", true)){
            fileWriter.write("\n"+username+"  "+password+ "\n");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static boolean passwordStrength(String password) {
        int passLength = password.length();
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;
        for (int i = 0; i < passLength; i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch))
                hasUpperCase = true;
            else if (Character.isLowerCase(ch))
                hasLowerCase = true;
            else if (Character.isDigit(ch))
                hasDigit = true;
            else
                hasSpecialCharacter = true;
        }
        return passLength >= 8 && hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter;
    }

    public static String generateAutoPassword() {
        SecureRandom random = new SecureRandom();
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = lowerCase.toUpperCase();
        String digit = "123456789";
        String specialCharacter = "!@#$%^&*()-_=+[]{}|;:,.<>?";
        String allCharacters = lowerCase + upperCase + digit + specialCharacter;
        int length = random.nextInt(5) + 8;
        StringBuilder password = new StringBuilder(length);
        password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
        password.append(upperCase.charAt(random.nextInt(upperCase.length())));
        password.append(digit.charAt(random.nextInt(digit.length())));
        password.append(specialCharacter.charAt(random.nextInt(specialCharacter.length())));
        for (int i = 0; i < length - 4; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            int rand = random.nextInt(length);
            password.setCharAt(i, password.charAt(rand));
            password.setCharAt(rand, ch);
        }
        return password.toString();
    }

    public static void toLoggin(){
        // String username;
        // String password;
        System.out.print("Enter your username:");
        username=input.nextLine();
        System.out.print("Enter your password:");
        password=input.nextLine();
        String checker=username+"  "+password;
        try{
            File myFile=new File("passwords.txt");
            Scanner sc=new Scanner(myFile);
            while (sc.hasNextLine()) {
                String Line=sc.nextLine();
                if(Line.equals(checker)){
                    System.out.println("Loggin Successful");

                    try (FileWriter fileWriter = new FileWriter("History.txt", true)){
                        fileWriter.write("\n"+username+"  "+password+ "\n");
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                }
                else{
                    if(sc.hasNextLine())
                        continue;
                    System.out.println("Username or password does not exist.Plz enter username and password again.");
                    toLoggin();
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void seeHistory(String username, String password) {
        File myFile = new File("History.txt");
        String checker = username + "  " + password;
        String line;
        System.out.println("----------------------History---------------------");
        try {
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                if (line.equals(checker)) {
                    while (!line.equals("-------------------------------------------------------------------")) {
                        line = sc.nextLine();
                        System.out.println(line);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void writeToHistoryFile(int count,String history){
        try (FileWriter fileWriter = new FileWriter("History.txt", true)){
            fileWriter.write(count+")"+history+"\n");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
