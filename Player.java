public class Player{
    private String name;
    private int id;

    public Player(String name, int id){
        this.name=name;
        this.id=id;
    }

    public String toString(){
        return "Player with Name: "+this.name+" and ID: "+this.id;
    }
}