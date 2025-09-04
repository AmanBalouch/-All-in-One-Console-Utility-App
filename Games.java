import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
public class Games {
    static Scanner input = new Scanner(System.in);
    public static void main(String []Args){
        System.out.println("\n-------------Welcome to  game portion-------------");
        String history="";
        int count=1;
        while(true){
            System.out.println("\n-----------------------------------------------");
            System.out.println("1.Tic Tac Toe.\n2.Guess the number.\n3.Rock paper Scissors.\n4.HangMan.\n5.Enter 5 to return to main menu.");
            System.out.println("-----------------------------------------------");
            System.out.print("Enter your choice here: ");
            Scanner input=new Scanner(System.in);
            String choice=input.nextLine();
            if(choice.equals("1")){
                Project.main(new String[]{});
                history="TicTacToe";
            }
            else if(choice.equals("2")){
                numberGuesser();
                history="NumberGuesser";
            }
            else if(choice.equals("3")){
                rockPaperScissor();
                history="Rock-Paper-Scissor";
            }
            else if(choice.equals("4")){
                hangMan();
                history="HangMan";
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

    public static void rockPaperScissor() {
        try{
            String[] choices = {"rock", "paper", "scissors"};
            Random random = new Random();
            String computerChoice = choices[random.nextInt(choices.length)];
            System.out.println("Enter your choice from rock, paper, scissors");
            System.out.print("Enter your choice: ");
            String userChoice = input.nextLine().toLowerCase();
            while(!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors") && !userChoice.equals("scissor")) {
                System.out.print("Invalid choice, please enter again: ");
                userChoice = input.nextLine().toLowerCase();
            }
            System.out.println("Computer choice is: " + computerChoice);
            System.out.println("Your choice: " + userChoice);
            if (computerChoice.equals("rock") && ((userChoice.equals("scissors")) || (userChoice.equals("scissor"))))
                System.out.println("Computer wins");
            else if (computerChoice.equals("scissors") && userChoice.equals("paper"))
                System.out.println("Computer wins");
            else if (computerChoice.equals("paper") && userChoice.equals("rock"))
                System.out.println("Computer wins");
            else if (computerChoice.equals(userChoice))
                System.out.println("Match tie");
            else
                System.out.println("Congratulations, you win");
        } catch (Exception e) {
            System.out.println(e);
            rockPaperScissor();
        }
    }

    public static void numberGuesser() {
        Random random = new Random();
        int a = random.nextInt(100) + 1;
        int count=0;
        while(true){
            try{
                System.out.print("Enter a number: ");
                int b = input.nextInt();
                input.nextLine();
                count++;
                while ((a != b) && (count <=15)){
                    if ((a-b <=15) && (b-a<=15))
                        System.out.println("Too close");
                    else
                        System.out.println("Too far");
                    System.out.println(15-count+" Attemps left.");
                    System.out.print("Enter a number: ");
                    b = input.nextInt();
                    input.nextLine();
                    count++;
                }
                if (a == b){
                    System.out.println("Congratulations you won the game.");
                    break;
                }
                else{
                    System.out.println("No more attemps are left.");
                    break;
                }
            }
            catch(Exception e){
                System.out.println(e);
                input.nextLine();
            }
        }
    }

    public static void hangMan() {
        Random random = new Random();
        String[] words = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon"};
        String word = words[random.nextInt(words.length)];
        char[] guessedLetters = new char[word.length()];
        int attempts = 6;
        boolean wordGuessed = false;
        while (attempts > 0 && !wordGuessed) {
            System.out.print("Guess a letter: ");
            char letter = input.next().charAt(0);
            boolean letterGuessed = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    guessedLetters[i] = letter;
                    letterGuessed = true;
                }
            }
            if (!letterGuessed) {
                attempts--;
                System.out.println("Incorrect guess! Attempts remaining: " + attempts);
            }
            System.out.println(guessedLetters);
            if (word.equals(String.valueOf(guessedLetters))) {
                wordGuessed = true;
                System.out.println("Congratulations! You guessed the word correctly.");
            }
        }
        if (!wordGuessed) {
            System.out.println("Sorry, you ran out of attempts. The word was: " + word);
        }
    }
}
