import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


import java.util.LinkedList;
import java.util.Timer;

public class SnakeView {
    private String color;
    private final static int Snake_Initial_Size = 4;
    private LinkedList<Position> body;



    public SnakeView(int x, int y){
        body = new LinkedList<Position>();

        for(int i = 0; i < Snake_Initial_Size; i++) {body.add(new Position(x,y));}


    }

    public void setBody(LinkedList<Position> body){
        this.body = body;
    }
    public LinkedList<Position> getBody() {
        return body;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public Position getHead(){
        return body.getLast();
    }
    public Position getSnakeTail(){
        return body.getFirst();
    }

    public void draw(TextGraphics graphics,String color) {
        Position head = getHead();
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));

        for(Position p: body){
            if(p.equals(head)){graphics.setBackgroundColor(TextColor.ANSI.WHITE);}
            graphics.putString(new TerminalPosition(p.getX(), p.getY()), " ");
        }
    }
}
