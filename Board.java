import java.util.concurrent.ThreadLocalRandom;
public class Board {
    public int numPieces;

    public Board(){
        System.out.println("Board created");
    }

    public void populate(){
        this.numPieces=ThreadLocalRandom.current().nextInt(20,51);
        System.out.println("The number of pieces is: "+numPieces);
    }


}
