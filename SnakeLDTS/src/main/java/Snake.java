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
    public boolean isAteApple(LinkedList<Apple> Apples){
        Position start = getHead();
        for(Apple p: Apples){
            if(start.equals(p.getPosition())){
                Apples.remove(p);
                body.add(whereTo());

                //Position position = new Position()
                return true;
            }
        }
        return false;
    }
    private Position whereTo(){
        Position position = new Position(0,0);
        Position head = getHead();
        switch(direction)
        {
            case UP:

                position = new Position(head.getX(), head.getY() - 1);
                break;

            case DOWN:

                position = new Position(head.getX(), head.getY() + 1);
                break;

            case LEFT:

                position = new Position(head.getX() - 1, head.getY());
                break;

            case RIGHT:

                position = new Position(head.getX() + 1, head.getY());
                break;

        }
        return position;
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
        Position head = getHead();
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        for(Position p: body){
            if(p.equals(head)){
                graphics.setBackgroundColor(TextColor.Factory.fromString("#33ff00"));
            }
            graphics.putString(new TerminalPosition(p.getX(), p.getY()), " ");
        }


    }
}
