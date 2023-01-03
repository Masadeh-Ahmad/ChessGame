package Game;

public class Player {
    private String username;
    private Color color;
    public Player(String username){
        this.username = username;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return this.color;
    }
}
