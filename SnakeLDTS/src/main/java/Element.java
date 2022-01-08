import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class  Element {
    public Element(Position position){
        this.position = position;
    }
    public Position getPosition(){
        return position;
    }
    public void setPosition(Position position){
        this.position = position;
    }
    public int getX(){
        return position.getX();
    }
    public int getY(){
        return position.getY();
    }
    abstract void draw(TextGraphics textGraphics,String color);


    private Position position;

}
