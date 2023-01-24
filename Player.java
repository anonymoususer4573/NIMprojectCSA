import java.util.Scanner;

public class Player{

    //instance variables
    private String name;
    private int id;
    private int numSkips;

    //constructors
    public Player(String name, int id){
        this.name=name;
        this.id=id;
        this.numSkips=1;
    }

    //just if you want a custom number of skips
    public Player(String name, int id, int numSkips){
        this.name=name;
        this.id=id;
        this.numSkips=numSkips;
    }

    public String toString(){
        return "Player with Name: "+this.name+" and ID: "+this.id;
    }

    //function for taking pieces
    public int takePiece(Board b, Player p){

        //ask for number of pieces
        System.out.println("-----------------------------------------------------");
        System.out.println(p+"'s turn.");
        System.out.println("You have "+this.numSkips+" skips.");
        System.out.println("The number of pieces left is: "+b.numPieces);
        System.out.println("How many pieces will you take?");
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int num=Integer.parseInt(n);

        //take one piece
        if(num==1){
            return num;
        }
        
        //take between one pieces and half the number of available pieces
        else if(0<num&&num<=(b.numPieces/2)){
            return num;
        }

        //skip code is 100, since we're only generating a max of 50 pieces
        else if(num==100){
            if(this.numSkips!=0){
                this.numSkips-=1;
                return 100;
            }
            else{
                System.out.println("You can't skip anymore!");
                return 0;
            }
        }

        //handles all invalid inputs.
        else{
            return 0;
        }
    }
}
