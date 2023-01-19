import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    public void play(){
        System.out.println("How many players?");
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int num = Integer.parseInt(n);

        //initialize players
        ArrayList<Player> a = new ArrayList<Player>();
        for(int i=1;i<num+1;i++){
            System.out.println("Input name");
            String name = sc.nextLine();
            Player temp = new Player(name, i);
            a.add(temp);
            System.out.println(temp+" is added.");
        }


        //create and populate board
        Board b = new Board();
        b.populate();

        //game logic
        while(b.numPieces>0){
            for(Player p:a){
                System.out.println("-----------------------------------------------------");
                System.out.println(p+"'s turn.");
                System.out.println("How many pieces will you take?");
                n = sc.nextLine();
                num=Integer.parseInt(n);
                if(num==1){
                    b.numPieces-=num;
                    System.out.println("The number of pieces left is: "+b.numPieces);
                }
                else if(0<num&&num<=(b.numPieces/2)){
                    b.numPieces-=num;
                    System.out.println("The number of pieces left is: "+b.numPieces);
                }
                else{
                    System.out.println("You can't take that many pieces.");
                    System.out.println("The number of pieces left is: "+b.numPieces);
                }

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