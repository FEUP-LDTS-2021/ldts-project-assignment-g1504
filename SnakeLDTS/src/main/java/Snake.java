import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


import java.util.LinkedList;

public class Snake {
    private String color;
    private final static int Snake_Initial_Size = 4;
    private Direction direction;
    private boolean SnakeCollided = false;
    private boolean ateApple = false;
    private boolean dead = false;
    private LinkedList<Position> body;

    public Snake(int x, int y,Direction direction){

        this.direction = direction;
        body = new LinkedList<Position>();
        for(int i = 0; i < Snake_Initial_Size;i++){
            body.add(new Position(x,y));
        }
        this.direction = direction;
    }

    public LinkedList<Position> getBody() {
        return body;
    }
    public Position getHead(){
        return body.getLast();
    }
    public Position getSnakeTail(){
        return body.getFirst();
    }
    public Direction getDirection(){
        return direction;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setDirection(Direction direction){
        this.direction = direction;
    }
    public boolean isSnakeCollided(){
        return SnakeCollided;
    }
    public boolean isAteApple(LinkedList<Position> Apples){
        Position start = getHead();
        for(Position p: Apples){
            if(start.equals(p)){
                Apples.remove(p);
                return true;
            }
        }
        return false;
    }
    public void endSnake(){
        dead = true;

    }
    public void move()
    {
        // Get current head position
        Position head = getHead();

        // Remove tail from body
        body.removeFirst();

        // Determine head's new position based on snake's direction
        switch(direction)
        {
            case UP:

                head = new Position(head.getX(), head.getY() - 1);
                break;

            case DOWN:

                head = new Position(head.getX(), head.getY() + 1);
                break;

            case LEFT:

                head = new Position(head.getX() - 1, head.getY());
                break;

            case RIGHT:

                head = new Position(head.getX() + 1, head.getY());
                break;
        }

        // Insert the new head into the snake's body
        body.addLast(head);
    }
    public void draw(TextGraphics graphics,String color){
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        for(Position p: body){
            graphics.putString(new TerminalPosition(p.getX(), p.getY()), " ");
        }


    }
}
