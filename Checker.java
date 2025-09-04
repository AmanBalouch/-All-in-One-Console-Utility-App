import java.io.FileWriter;
import java.util.Scanner;
public class Checker {
    static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("---------------Welcom to Checker portion---------------");
        String history="";
        int count=1;
        while(true){
            System.out.println("\n-----------------------------------------------");
            System.out.println("1.Pallindrome Checker.\n2.Prime number checker.\n3.Leap year checker.\n4.Positivr,negative or zero checker.\n5.Return to main menu.");
            System.out.println("-----------------------------------------------");
            System.out.print("Enter your choice here: ");
            String choice=input.nextLine();
            if(choice.equals("1")){
                history="Pallindrome Checker.";
                pallindromeChecker();
            }
            else if(choice.equals("2")){
                history="Prime number checker.";
                primeNumberChecker();
            }
            else if(choice.equals("3")){
                history="Leap year checker.";
                leapYearChecker();
            }
            else if(choice.equals("4")){
                history="Positive,negative or zero checker.";
                positiveNegativeZeroChecker();
            }
            else if(choice.equals("5"))
                break;
            else{
                System.out.println("Invalid choice plz select again");
                history="Invalid input";
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

    public static void pallindromeChecker(){
        System.out.print("Enter the word:");
        String word=input.nextLine();
	    word=word.toLowerCase();
        String reverse_word="";
        for(int i=word.length()-1;i>=0;i--){
            char a=word.charAt(i);
            reverse_word=reverse_word+a;}
        if(reverse_word.equals(word))
            System.out.printf("%s is a pallindrome.",word);
        else
            System.out.printf("%s is not a pallindrome.",word);
    }

    public static void primeNumberChecker(){
        try{
            System.out.print("Enter the number:");
            int number=input.nextInt();
            input.nextLine();
            int checker=0;
            for(int i=2;i<=Math.sqrt(number);i++){
                if(number%i==0)
                    checker=1;
            }
            if(checker==0)
                System.out.printf("%d is a prime number.",number);
            else
                System.out.printf("%d is not a prime number.",number);
        }
        catch(Exception e){
            System.out.println("Invalid input.Plz enter input again");
            input.nextLine();
            primeNumberChecker();
        }
    }

    public static void leapYearChecker() {
        try{
            System.out.print("Enter a year: ");
            int year = input.nextInt();
            input.nextLine();
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (isLeapYear) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
        }
        catch(Exception e){
            System.out.println("Invalid input.Plz enter input again");
            input.nextLine();
            leapYearChecker();
        }
    }

    public static void positiveNegativeZeroChecker() {
        try{
            System.out.print("Enter a number: ");
            double number = input.nextDouble();
            input.nextLine();
            if (number > 0)
                System.out.println(number + " is a positive number.");
            else if (number < 0)
                System.out.println(number + " is a negative number.");
            else
                System.out.println(number + " is zero.");
        }
        catch(Exception e){
            System.out.println("Invalid input.Plz enter input again");
            input.nextLine();
            positiveNegativeZeroChecker();
        }
    }
}
