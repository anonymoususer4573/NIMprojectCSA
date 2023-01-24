import java.util.concurrent.ThreadLocalRandom;
public class Board {
    //instance variables
    public int numPieces;

    //constructor
    public Board(){
        System.out.println("Board created");
    }

    //used to generate random number of pieces
    public void populate(){
        this.numPieces=ThreadLocalRandom.current().nextInt(20,51);
        System.out.println("The number of pieces is: "+numPieces);
    }

}
