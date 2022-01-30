public class SnakeController {
    private Direction direction;
    private SnakeView snakeView;

    public SnakeController(Direction direction,SnakeView snakeView){
        this.direction = direction;
        this.snakeView = snakeView;
    }
    public Direction getDirection(){
        return direction;
    }
    public void setDirection(Direction direction){
        this.direction = direction;
    }
    public Position whereTo() {
        Position position = new Position(0,0);
        Position head = snakeView.getHead();

        switch(direction) {
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
    public void move() {
        // Get current head position
        Position head = snakeView.getHead();

        // Remove tail from body
        snakeView.getBody().removeFirst();

        // Determine head's new position based on snake's direction
        switch(direction) {
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
        snakeView.getBody().addLast(head);
    }
}
