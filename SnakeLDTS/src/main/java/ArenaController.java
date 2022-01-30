public class ArenaController {
    private  SnakeController snakeController;

    public ArenaController(SnakeController snakeController){
        this.snakeController = snakeController;
    }

    public SnakeController getSnakeController(){
        return snakeController;
    }
}
