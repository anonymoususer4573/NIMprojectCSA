import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        Game nim = new Game();
        nim.play();

        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to play again?");
        String response = sc.nextLine();
        while(response.equals("Yes")){
            nim.play();
            System.out.println("Do you want to play again?");
            response = sc.nextLine();
        }
        System.out.println("See you next time!");
    }
}
