import java.io.FileWriter;
import java.util.Scanner;
public class Converter {
    static Scanner input=new Scanner(System.in);
    public static void main(String []Arg){
        System.out.println("\n------------Welcome to Converter--------");
        String history="";
        int count=1;
        while(true){
            System.out.println("\n-----------------------------------------------");
            System.out.println("1.Convert hour into seconds.\n2.Sec to hour.\n3.Convert fahrenhiet into celcius and vice versa.\n4.Convert a number into its reverse number.\n5.Currency converter.\n6.Enter 6 to return to min menu. ");
            System.out.println("-----------------------------------------------");
            System.out.print("Enter your choice here: ");
            String choice=input.nextLine();
            if(choice.equals("1")){
                hourToSec();
                history="Hour to second converter.";
            }
            else if(choice.equals("2")){
                secToHour();
                history="Second to hour Converter.";
            }
            else if(choice.equals("3")){
                celciusFahrenhietConverter();
                history="Celcius to Fahrenhiet Converter and vice versa";
            }
            else if(choice.equals("4")){
                numberReverser();
                history="Number Reverser";
            }
            else if(choice.equals("5")){
                currencyConverter();
                history="Currency Converter";
            }
            else if(choice.equals("6"))
                break;
            else{
                System.out.println("Invalid choice.Plz enter again.");
                history="Invalid Input.";
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

    public static void hourToSec(){
        try{
            System.out.print("Enter the number of hours:");
            int h=input.nextInt();
            input.nextLine();
            int ans=h*3600;
            System.out.println("The equivalent time in seconds is="+ans);
        }
        catch(Exception e){
            System.out.print(e);
            input.nextLine();
            hourToSec();
        }
    }

    public static void secToHour(){
        try{
            System.out.print("Enter the number of seconds:");
            int sec=input.nextInt();
            input.nextLine();
            double ans=sec/3600.0;
            System.out.println("The equivalent time in hours is="+ans);
        }
        catch(Exception e){
            System.out.print(e);
            input.nextLine();
            secToHour();
        }
    }

    public static void celciusFahrenhietConverter(){
        try{
            System.out.println("-------------------------------");
            System.out.println("\nEnter your choice \n 1.Convert celcius to fahrenhiet.\n2.Convert Fahrenheit to Celsius.");
            System.out.println("-------------------------------");
            System.out.print("Enter your choice here: ");
            String choice=input.nextLine();
            if (choice.equals("1")){
                System.out.print( "Enter temperature in celcius : ");
                float c=input.nextFloat();
                input.nextLine();
                float fah=((9.0f/5)*c)+32;
                System.out.printf("The temperture in fahrenheit is=%.3f" ,fah);
            }
            else if (choice.equals("2")){
                System.out.print("Enter temperature in Fahrenheit : ");
                float f=input.nextFloat();
                input.nextLine();
                float cel=(f-32)/1.8f;
                System.out.printf("The temprature in celcius is=%.3f",cel);
            }
            else{
                System.out.println("Your choice is not valid.plz enter valid choice.");
                celciusFahrenhietConverter();
            }
        }
        catch(Exception e){
            System.out.print(e);
            input.nextLine();
            celciusFahrenhietConverter();
        }
    }

    public static void numberReverser() {
        try{
            System.out.print("\nEnter the number:");
            int num1 =input.nextInt();
            input.nextLine();
            int num=num1;
            int reversenumber=0;
            while (num>0){
                int reminder=num%10;
                reversenumber=reversenumber*10+reminder;
                num=num/10;
                }
            System.out.printf("The reverse of number is %d ",reversenumber);
        }
        catch(Exception e){
            System.out.print(e);
            input.nextLine();
            numberReverser();
        }
    }

    public static void currencyConverter() {
        try{
            System.out.println("\n----------------------------");
            System.out.println("\nEnter the type of your currency .\n1.USD\n2.Eur\n3.Jpy\n4.Pkr\n5.pound\n6.Riyal");
            System.out.println("----------------------------");
            System.out.print("Enter your choice here: ");
            String type=input.nextLine();
            System.out.print("\nEnter the amount of currency here:");
            Double amount=input.nextDouble();
            input.nextLine();
            System.out.println("----------------------------");
            System.out.println("In which currency you  want to convert;\n1.USD.\n2.JPY.\n3.EUR.\n4.PKR.\n5.Pound.\n6.Riyal.");
            System.out.println("----------------------------");
            System.out.print("Enter your choice here: ");
            String choice=input.nextLine();
            double USD_to_EUR=0.92;
            double USD_to_JPY=110;
            double USD_to_PKR=277.86;
            double USD_to_Pound=0.79;
            double USD_to_Riyal=3.75;
            double USD_to_USD=1;
            double EUR_to_JPY=130;
            double EUR_to_USD=1/0.85;
            double EUR_to_PKR=301.44;
            double EUR_to_Pound=301.44;
            double EUR_to_Riyal=4.07;
            double EUR_to_EUR=1;
            double JPY_to_USD=1.0/110;
            double JPY_to_EUR=1.0/130;
            double JPY_to_PKR=1.77;
            double JPY_to_Pound=0.0050;
            double JPY_to_Riyal=0.024;
            double JPY_to_JPY=1;
            double PKR_to_USD=1/277.86;
            double PKR_to_EUR=1/301.44;
            double PKR_to_JPY=1/1.77;
            double PKR_to_Pound=0.0028;
            double PKR_to_Riyal=0.013;
            double PKR_to_PKR=1;
            double Pound_to_USD=1/0.79;
            double Pound_to_EUR=1/301.44;
            double Pound_to_JPY=1/0.0050;
            double Pound_to_PKR=1/0.0028;
            double Pound_to_Riyal=4.78;
            double Pound_to_Pound=1;
            double Riyal_to_USD=1/3.75;
            double Riyal_to_EUR=1/4.07;
            double Riyal_to_JPY=1/0.024;
            double Riyal_to_PKR=1/0.013;
            double Riyal_to_Pound=1/4.78;
            double Riyal_to_Riyal=1;
            double answer=0;
            if (type.equals("1")){
                if(choice.equals("1"))
                    answer=amount*USD_to_USD;
                else if (choice.equals("2"))
                    answer=amount*USD_to_JPY;
                else if(choice.equals("3"))
                    answer=amount*USD_to_EUR;
                else if(choice.equals("4"))
                    answer=amount*USD_to_PKR;
                else if(choice.equals("5"))
                    answer=amount*USD_to_Pound;
                else if(choice.equals("6"))
                    answer=amount*USD_to_Riyal;
                else{
                    System.out.print("Wrong Input!");
                    currencyConverter();
                }
            }
            else if (type.equals("2")){
                if(choice.equals("1"))
                    answer=amount*EUR_to_USD;
                else if(choice.equals("2"))
                    answer=amount*EUR_to_JPY;
                else if(choice.equals("3"))
                    answer=amount*EUR_to_EUR;
                else if(choice.equals("4"))
                    answer=amount*EUR_to_PKR;
                else if(choice.equals("5"))
                    answer=amount*EUR_to_Pound;
                else if(choice.equals("6"))
                    answer=amount*EUR_to_Riyal;
                else{
                    System.out.print("Wrong Input!");
                    currencyConverter();
                }
            }
            else if (type.equals("3")){
                if(choice.equals("1"))
                    answer=amount*JPY_to_USD;
                else if(choice.equals("2"))
                    answer=amount*JPY_to_JPY;
                else if(choice.equals("3"))
                    answer=amount*JPY_to_EUR;
                else if(choice.equals("4"))
                    answer=amount*JPY_to_PKR;
                else if(choice.equals("5"))
                    answer=amount*JPY_to_Pound;
                else if(choice.equals("6"))
                    answer=amount*JPY_to_Riyal;
                else{
                    System.out.print("Wrong Input!");
                    currencyConverter();
                }
            }
            else if (type.equals("4")){
                if(choice.equals("1"))
                    answer=amount*PKR_to_USD;
                else if(choice.equals("2"))
                    answer=amount*PKR_to_JPY;
                else if(choice.equals("3"))
                    answer=amount*PKR_to_EUR;
                else if(choice.equals("4"))
                    answer=amount*PKR_to_PKR;
                else if(choice.equals("5"))
                    answer=amount*PKR_to_Pound;
                else if(choice.equals("6"))
                    answer=amount*PKR_to_Riyal;
                else{
                    System.out.print("Wrong Input!");
                    currencyConverter();
                }
            }
            else if (type.equals("5")){
                if(choice.equals("1"))
                    answer=amount*Pound_to_USD;
                else if(choice.equals("2"))
                    answer=amount*Pound_to_JPY;
                else if(choice.equals("3"))
                    answer=amount*Pound_to_EUR;
                else if(choice.equals("4"))
                    answer=amount*Pound_to_PKR;
                else if(choice.equals("5"))
                    answer=amount*Pound_to_Pound;
                else if(choice.equals("6"))
                    answer=amount*Pound_to_Riyal;
                else{
                    System.out.print("Wrong Input!");
                    currencyConverter();
                }
            }
            else if (type.equals("6")){
                if(choice.equals("1"))
                    answer=amount*Riyal_to_USD;
                else if(choice.equals("2"))
                    answer=amount*Riyal_to_JPY;
                else if(choice.equals("3"))
                    answer=amount*Riyal_to_EUR;
                else if(choice.equals("4"))
                    answer=amount*Riyal_to_PKR;
                else if(choice.equals("5"))
                    answer=amount*Riyal_to_Pound;
                else if(choice.equals("6"))
                    answer=amount*Riyal_to_Riyal;
                else{
                    System.out.print("Wrong Input!");
                    currencyConverter();
                }
            }
            else{
                System.out.print( "Wrong type!");
                currencyConverter();
            }
            System.out.printf("Converted amount=%.2f",answer);
        }
        catch(Exception e){
            System.out.println(e);
            input.nextLine();
            currencyConverter();
        }
    }
}
