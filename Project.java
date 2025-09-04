import java.util.Random;

import javax.swing.JOptionPane;

class Project{
    public static void main(String [] Args){
        JOptionPane.showMessageDialog(null,"Welcome To Tic Tac Toe");
        while (true){
            String name1="";
            String name2="";
            String selection=JOptionPane.showInputDialog("Enter your choice\n1.You want to play with computer.\n2.You want to play 2 players game.");
            if (selection.equals("1")){
                name1=JOptionPane.showInputDialog("Enter your name");
                name2="Computer";
            }
            else if (selection.equals("2")){
                name1 = JOptionPane.showInputDialog("Enter the name of first player");
                name2 = JOptionPane.showInputDialog("Enter the name of second player");
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Selection");
                continue;
            }
            int turn=toss(name1,name2);
            char [] board={'1','2','3','4','5','6','7','8','9'};
            char marker='.';
            while(true) {
                if(turn==1){
                    marker='X';
                    printBoardPlusInput(name1,board,marker);
                    if(checkWinner(board,marker)){
                        JOptionPane.showMessageDialog(null,name1+" won the game.");
                        break;
                    }
                }
                else{
                    marker='O';
                    printBoardPlusInput(name2,board,marker);
                    if(checkWinner(board,marker)){
                        JOptionPane.showMessageDialog(null,name2+" won the game.");
                        break;
                    }
                }
                if(isMatchTie(board)){
                    JOptionPane.showMessageDialog(null,"Match Tie");
                    break;
                }
                turn=1-turn;
            }
            String b=JOptionPane.showInputDialog("1.Return to main menu.\n0.Exit game.");
            while((!b.equals("1")) && (!b.equals("0"))){
                    JOptionPane.showMessageDialog(null,"Invalid Input");
                    b=JOptionPane.showInputDialog("1.Return to main menu.\n0.Exit game.");
                }
            if (b.equals("1"))
                continue;
            else
                break;
        }
    }
    public static int toss(String name1,String name2){
        Random random=new Random();
        String choice;
        while(true){
            choice=JOptionPane.showInputDialog(name1+"Enter your choice\n1.Head.\n2.Tail.");
            if((choice.equals("1")) ||(choice.equals("2"))){
                int rand=random.nextInt(2)+1;
                String rand1=String.valueOf(rand);
                String winner=choice.equals(rand1)?name1:name2;
                JOptionPane.showMessageDialog(null,winner+" won the toss.");
                return winner.equals(name1) ? 1 : 0;
            }
            else
                JOptionPane.showMessageDialog(null,"Invalid input");
        }
    }
    public static void printBoardPlusInput(String name,char[] board,char marker){
        Random rand=new Random();
        int Input=0;
        while (true){
            if(name.equals("Computer")){
                Input=computerMove(board);
            }
            else{
                while(true)
                    try{
                        String input=JOptionPane.showInputDialog(board[0] + " | " + board[1] + " | " + board[2]+
                        "\n---|---|---\n"
                        +board[3] + " | " + board[4] + " | " + board[5]+
                        "\n---|---|---\n"
                        +board[6] + " | " + board[7] + " | " + board[8] +
                        "\n" + name + " Plz select any number from board.");
                        Input=Integer.parseInt(input);
                        break;
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,name + ",Plz enter a valid input");
                    }
            }
            if(Input<1 || Input >9){
                    JOptionPane.showMessageDialog(null,name + ",Plz  enter a valid input");
            }
            else if ((board[Input-1]=='X')||(board[Input-1]=='O')){
                if(name.equals("Computer"));
                else
                    JOptionPane.showMessageDialog(null,name + ",Position already occupied. Please choose an empty position.");
                }
            else{
                Input=Input-1;
                board[Input]=marker;
                break;
            }
        }
    }
    public static boolean checkWinner(char[] board,char marker){
        return((board[0] == marker && board[1] == marker && board[2] == marker) ||
        (board[3] == marker && board[4] == marker && board[5] == marker) ||
        (board[6] == marker && board[7] == marker && board[8] == marker) ||
        (board[0] == marker && board[3] == marker && board[6] == marker) ||
        (board[1] == marker && board[4] == marker && board[7] == marker) ||
        (board[2] == marker && board[5] == marker && board[8] == marker) ||
        (board[0] == marker && board[4] == marker && board[8] == marker) ||
        (board[2] == marker && board[4] == marker && board[6] == marker));
    }
    public static boolean isMatchTie(char[] board){
        return(board[0]!='1' && board[1]!='2' && board[2]!='3'
        && board[3]!='4' && board[4]!='5' && board[5]!='6' &&
        board[6]!='7' && board[7]!='8' && board[8]!='9');
    }
    public static int computerMove(char[] board){
        Random rand=new Random();
        //to block
        for(int i=1;i<=9;i++){
            if((board[i-1]=='X') || (board[i-1]=='O'));
            else{
                char original_num=board[i-1];
                board[i-1]='X';
                if(checkWinner(board, 'X')){
                    board[i-1]=original_num;
                    return i;
                }
                else
                    board[i-1]=original_num;
                
            }
        }
        // to win
        for(int i=1;i<=9;i++){
            if((board[i-1]=='X') || (board[i-1]=='O'));
            else{
                char original_num=board[i-1];
                board[i-1]='O';
                if(checkWinner(board, 'O')){
                    board[i-1]=original_num;
                    return i;
                }
                else
                    board[i-1]=original_num;
            }
        }
        // random move
        if (board[4]=='5'){
            return 5;
        }
        else
            return rand.nextInt(9)+1;
    }
}