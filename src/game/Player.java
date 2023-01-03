package game;

public class Player {
    private final String username;
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

    public String getUsername() {
        return username;
    }
}
