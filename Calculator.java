import java.io.FileWriter;
import java.util.Scanner;
public class Calculator {
    static Scanner input=new Scanner(System.in);
    public static void main(String[]Args){
        System.out.println("\n-------------Welcome to calculator portion----------");
        String choice;
        String history="";
        int count=1;
        while(true){
            System.out.println("\n-----------------------------------------------");
            System.out.println("1.Simple Calculator.\n2.Comsat Aggregate Calculator.\n3.Grade and Percentage  Calculator.\n4.Calculate number of digits in a number.\n5.Calculate number of characters in a sentence.\n6.All Factors Calculator.\n7.HCF or GCD calculator of 2 numbers..\n8.HCF calculator of 3 numbers.\n9.LCM Calculator of 3 numbers.\n10.LCM calculator of 2 digits.\n11.Calculate sum of digits of a number.\n12.Calculate time by speed and distance.\n13.Enter 13 to return to main menu.");
            System.out.println("-----------------------------------------------");
            System.out.print("Enter your choice here: ");
            choice=input.nextLine();
            if(choice.equals("1")){
                simpleCalculator();
                history="Simple Calculator";
            }
            else if(choice.equals("2")){
                aggregateCalculator();
                history = "Comsat Aggregate Calculaor";
            }
            else if(choice.equals("3")){
                gradeAndPercentageCalculator();
                history = "Grade and Percentage Calculator";
            }
            else if(choice.equals("4")){
                digitCalculator();
                history = "Digits Calculator";
            }
            else if(choice.equals("5")){
                characterCalculator();
                history = "Characters Calculator";
            }
            else if(choice.equals("6")){
                dividerChecker();
                history = "Factors Calcuators";
            }
            else if(choice.equals("7")){
                while(true){
                    try{
                        System.out.print("Enter the first number:");
                        int num1=input.nextInt();
                        input.nextLine();
                        System.out.print("Enter the second number:");
                        int num2=input.nextInt();
                        input.nextLine();
                        System.out.printf("The GCD or HCF of %d and %d is %d",num1,num2,hcfCalculator2(num1,num2));
                        break;
                    }
                    catch(Exception e){
                        System.out.println("Plz enter integer as an input.");
                        input.nextLine();
                    }
                }
                history = "2 digit HCF calculator";
            }
            else if(choice.equals("8")){
                while(true){
                    try{
                        System.out.print("Enter first numbers:");
                        int num1=input.nextInt();
                        input.nextLine();
                        System.out.print("Enter second numbers:");
                        int num2=input.nextInt();
                        input.nextLine();
                        System.out.print("Enter third numbers:");
                        int num3=input.nextInt();
                        input.nextLine();
                        System.out.println("The hcf is "+hcfCalculator3(num1,num2,num3));
                        break;
                    }
                    catch(Exception e){
                        System.out.println("Plz enter integer as an input.");
                        input.nextLine();
                    }
                }
            history = "3 digit HCF calculator";
            }
            else if(choice.equals("9")){
                lcmCalculator3();
                history = "3 Digit LCM Calculator";
            }
            else if(choice.equals("10")){
                lcmCalculator2();
                history = "2 Digit LCM Calculator";
            }
            else if(choice.equals("11")){
                sumOfDigits();
                history = "Sum of Digits";
            }
            else if(choice.equals("12")){
                calTime();
                history = "Calculate time by Distance";
            }
            else if(choice.equals("13"))
                break;
            else{
                System.out.println("Invalid Choice.Plz Select Again.");
                history="Invalid Input";
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

    public static void simpleCalculator() {
        double result=0;
        try{
            System.out.print("Enter first number:");
            double num1=input.nextDouble();
            input.nextLine();
            System.out.print("Enter operator(+,*,-,/)");
            char operator=input.next().charAt(0);
            input.nextLine();
            System.out.print("Enter second number:");
            double num2=input.nextDouble();
            input.nextLine();
            switch (operator) {
                case '+':result = num1 + num2;break;
                case '-':result = num1 - num2;break;
                case '*':result = num1 * num2;break;
                case '/':
                    if(num2!=0)
                        result=num1/num2;
                    else{
                        System.out.println("Cannot divide by 0");
                        System.out.println("Enter inputs again:");
                        simpleCalculator();
                    }break;
                default:{System.out.println("Invalid Operation choice.");
                    simpleCalculator();
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
            System.out.print("plz give valid inputs.");
            input.nextLine();
            simpleCalculator();
        }
        System.out.println(result);
    }

    public static void aggregateCalculator(){
        try{
            System.out.print("Enter obtain marks in metric");
            int obtMetric=input.nextInt();
            input.nextLine();
            System.out.print("Enter total marks in metric");
            int totalMetric=input.nextInt();
            input.nextLine();
            System.out.print("Enter obtain marks in inter");
            int obtinter=input.nextInt();
            input.nextLine();
            System.out.print("Enter total marks in inter");
            int totalinter=input.nextInt();
            input.nextLine();
            System.out.print("Enter obtain marks in nts");
            int obtNts=input.nextInt();
            input.nextLine();
            if((obtMetric>totalMetric) || (obtinter>totalinter))
                aggregateCalculator();
            else{
                double aggregate=((((double)obtMetric/totalMetric)*10.0)+(((double)obtinter/totalinter)*40.0)+(((double)obtNts/100)*50.0));
                System.out.println("Your Aggregate is "+aggregate);
            }
        }
        catch(Exception e){
            System.out.println(e);
            input.nextLine();
            aggregateCalculator();
        }
    }

    public static void gradeAndPercentageCalculator(){
        try{
            System.out.print("Enter obtain marks:");
            int obtMarks=input.nextInt();
            input.nextLine();
            System.out.print("Enter total marks:");
            int totalMarks=input.nextInt();
            input.nextLine();
            if(obtMarks>totalMarks){
                System.out.print("Invalid input:");
                gradeAndPercentageCalculator();
            }
            char grade;
            double percentage=((double)obtMarks/totalMarks)*100.0;
            if(percentage>=90)
                grade='A';
            else if(percentage>=80)
                grade='B';
            else if(percentage>=70)
                grade='C';
            else if(percentage>=50)
                grade='D';
            else
                grade='F';
            System.out.println("Percentae= "+percentage);
            System.out.println("Grade= "+grade);
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("Your innput is invalid plz enter input again.");
            input.nextLine();
            gradeAndPercentageCalculator();
        }
    }

    public static void digitCalculator(){
        try{
            System.out.print("Enter the integer:");
            int numiginal = input.nextInt();
            input.nextLine();
            int num = numiginal;
            int count = 0;
            while(num != 0) {
                num = num / 10;
                count += 1;
            }
            System.out.print(numiginal + " has " + count + " digits.");
        }
        catch(Exception e){
            System.out.println("Plz enter integer as an input.");
            input.nextLine();
            digitCalculator();
        }
    }

    public static void characterCalculator() {
        try{
            System.out.print("Enter sentence here:");
            String sentence=input.nextLine() ;
            sentence = sentence.replaceAll("\\s+","");
            int characters = sentence.length();
            System.out.println(characters);
        }
        catch(Exception e){
            System.out.println(e);
            characterCalculator();
        }
    }

    public static void dividerChecker(){
        try{
            System.out.print("Enter the number:");
            int num=input.nextInt();
            input.nextLine();
            System.out.println(num+" is divisible by all the numbers given below:");
            for(int i=1;i<=Math.sqrt(num);i++){
                if(num%i==0)
                    System.out.print(i+",");
            }
            System.out.print(num);
        }
        catch(Exception e){
            System.out.println("Plz enter integer as an input.");
            input.nextLine();
            dividerChecker();
        }
    }

    public static int hcfCalculator2(int num1, int num2) {
        int hcf = 1;
        for (int i = Math.min(num1, num2); i >= 2; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                hcf = i;
                break;
            }
        }
        return hcf;
    }

    public static int hcfCalculator3(int num1,int num2,int num3){
        int GCD=1;
        if(num1<num2 && num1<num3)
            GCD=hcfCalculator2(hcfCalculator2(num1,num2),num3);
        else if(num2<num1 && num2<num3)
            GCD=hcfCalculator2(hcfCalculator2(num2,num1),num3);
        else{
            GCD=hcfCalculator2(hcfCalculator2(num2,num1),num2);
        }
        return GCD;
    }

    public static void lcmCalculator3(){
        try{
            System.out.print("Enter first numbers:");
            int num1=input.nextInt();
            input.nextLine();
            System.out.print("Enter second numbers:");
            int num2=input.nextInt();
            input.nextLine();
            System.out.print("Enter third numbers:");
            int num3=input.nextInt();
            input.nextLine();
            int GCD=hcfCalculator3(num1,num2,num3);
            int LCM=(num1*num2*num3)/GCD;
            System.out.println("The LCM is "+LCM);
        }
        catch(Exception e){
            System.out.println(e);
            input.nextLine();
            lcmCalculator3();
        }
    }

    public static void lcmCalculator2(){
        try{
            System.out.print("Enter first numbers:");
            int num1=input.nextInt();
            input.nextLine();
            System.out.print("Enter second numbers:");
            int num2=input.nextInt();
            input.nextLine();
            int GCD=hcfCalculator2(num1,num2);
            int LCM=(num1*num2)/GCD;
            System.out.println("The LCM is "+LCM);
        }
        catch(Exception e){
            System.out.println(e);
            input.nextLine();
            lcmCalculator2();
        }
    }

    public static void sumOfDigits(){
        try{
            System.out.print("Enter the integer:");
            int num1 =input.nextInt();
            input.nextLine();
            int num=num1;
            int sum = 0;
            while (num > 0) {
                sum+=num % 10;
                num = num/10;
            }
            System.out.printf("The digit sum of %d is %d" ,num1,sum);
        }
        catch(Exception e){
            System.out.print(e);
            input.nextLine();
            sumOfDigits();
        }
    }

    public static void calTime(){
        try{
            System.out.print("Enter distance in meters.");
            int dis=input.nextInt();
            input.nextLine();
            System.out.print("Enter your speed.");
            float speed=input.nextFloat();
            input.nextLine();
            float time=dis/speed;
            System.out.printf("The time taken by Sarah is %.2fmins",time);
        }
        catch(Exception e){
            System.out.print(e);
            input.nextLine();
            calTime();
        }
    }
}
