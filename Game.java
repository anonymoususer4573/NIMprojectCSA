import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Game {
    public void play(){
        //ask for number of players
        System.out.println("How many players?");
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int num = Integer.parseInt(n);

        //initialize players and randomize
        System.out.println("How many skips do you want each player to have?");
        String in = sc.nextLine();
        int numskips = Integer.parseInt(in);
        ArrayList<Player> a = new ArrayList<Player>();
        for(int i=1;i<num+1;i++){
            System.out.println("Input name");
            String name = sc.nextLine();
            Player temp = new Player(name,numskips);
            a.add(temp);
            System.out.println(temp+" is added.");
        }

        //randomize
        System.out.println("Randomizing...");
        Collections.shuffle(a);

        //create and populate board
        Board b = new Board();
        b.populate();

        //game logic

        //keeps game running until no pieces
        while(b.numPieces>0){
            for(Player p:a){
                //assign a variable numPieces which is returned by player.
                int numPieces=p.takePiece(b, p);

                //keeps re asking if a wrong input is entered 
                while(numPieces==0){
                    System.out.println("Try to take a valid number of pieces.");
                    numPieces = p.takePiece(b,p);
                }
                
                //skip
                if(numPieces==100){
                    System.out.println(p+" has skipped their turn.");
                }

                //if correct input, subtract number of pieces
                else{
                    b.numPieces -= numPieces;
                }
                
                //check for if the player has lost
                if(b.numPieces<0||b.numPieces==0){
                    System.out.println("-----------------------------------------------------");
                    System.out.println(p+" has lost.");
                    break;
                }
            }
        }
        sc.close();
    }
}