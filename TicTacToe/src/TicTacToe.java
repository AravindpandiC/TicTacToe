
import javax.swing.*;
import java.util.*;

public class TicTacToe {
    static ArrayList<Integer>playerPos =new ArrayList<>();
    static ArrayList<Integer>cpuPos =new ArrayList<>();
    static  List<List<Integer>>winning = Arrays.asList( Arrays.asList(1,2,3),
                                                        Arrays.asList(4,5,6),
                                                        Arrays.asList(7,8,9),
                                                        Arrays.asList(1,4,7),
                                                        Arrays.asList(2,5,8),
                                                        Arrays.asList(3,6,9),
                                                        Arrays.asList(1,5,9),
                                                        Arrays.asList(3,5,7));


    public static void main(String[] args) {
        char[][] gameBoard={{' ','|',' ','|',' '},
                            {'-','+','-','+','-'},
                            {' ','|',' ','|',' '},
                            {'-','+','-','+','-'},
                            {' ','|',' ','|',' '},};
        print(gameBoard);
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("Enter your position 1-9:");
            int pos = sc.nextInt();
            while (playerPos.contains(pos) || cpuPos.contains(pos)){
                System.out.println("Position taken!");
                pos=sc.nextInt();
            }
            pastePos(gameBoard, pos, "player");
            String str=check();
            if(str.length()>0) {
                if(str.equals("Player wins!")) print(gameBoard);
                System.out.println(str);
                break;
            }

            Random ran = new Random();
            pos = ran.nextInt(9) + 1;
            while (playerPos.contains(pos) || cpuPos.contains(pos)){
                pos = ran.nextInt(9) + 1;
            }
            pastePos(gameBoard, pos, "cpu");
            print(gameBoard);
            str=check();
            if(str.length()>0) {
                System.out.println(str);
//                break;
                int a=Integer.MAX_VALUE;
            }
        }

    }
    public static void print(char[][] gameBoard){
        for(char[] row:gameBoard){
            for (char i:row){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static void pastePos(char[][] gameBoard,int pos,String user){
        char symbol=' ';
        if(user.equals("player")) {
            playerPos.add(pos);
            symbol='X';
        }
        else if(user.equals("cpu")) {
            cpuPos.add(pos);
            symbol='O';
        }
        switch (pos){
            case 1:
                gameBoard[0][0]=symbol;
                break;
            case 2:
                gameBoard[0][2]=symbol;
                break;
            case 3:
                gameBoard[0][4]=symbol;
                break;
            case 4:
                gameBoard[2][0]=symbol;
                break;
            case 5:
                gameBoard[2][2]=symbol;
                break;
            case 6:
                gameBoard[2][4]=symbol;
                break;
            case 7:
                gameBoard[4][0]=symbol;
                break;
            case 8:
                gameBoard[4][2]=symbol;
                break;
            case 9:
                gameBoard[4][4]=symbol;
                break;
            default:
                break;
        }
    }
    public static String check(){
        for (List l:winning){
            if(playerPos.containsAll(l)) return "Player wins!";
            else if(cpuPos.containsAll(l)) return "Cpu wins!";
            else  if(playerPos.size()+cpuPos.size()==9) return "draw";
        }
        return "";
    }
}
