import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class ArenaModel {

    private SnakeModel snakeModel;
    private SnakeView snakeView;
    private SnakeController snakeController;
    private Apple apple;
    private LinkedList<Boxes> boxes = new LinkedList<Boxes>();
    private int SCORE = 0;
    private int width,height;



    public ArenaModel(int width, int height,SnakeModel snakeModel, SnakeView snakeView,SnakeController snakeController){
        this.snakeModel = snakeModel;
        this.snakeView = snakeView;
        this.snakeController = snakeController;
        this.width = width;
        this.height = height;
        createApples();
        createBoxes();
    }

    public int getSCORE() {
        return SCORE;
    }
    public SnakeModel getSnakeModel(){
        return snakeModel;
    }

    private void createApples(){
        Random random = new Random();
        Random power = new Random();

        apple = new Apple(new Position (random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        int powerNumber = power.nextInt(10);

        if(powerNumber > 4 && powerNumber <= 7) {apple.setPower(Powers.SPEED);}

        else if(powerNumber > 7) {apple.setPower(Powers.STRENGTH);}

        else {apple.setPower(Powers.NONE);}
    }

    public Apple getApple() {
        return apple;
    }

    public void isAteApple() {
        Position start = snakeView.getHead();
        if(start.equals(apple.getPosition())){
            snakeView.getBody().add(snakeController.whereTo());
            snakeModel.setAte(true);
            snakeModel.setPower(apple.getPower());
        }
    }

    public boolean checkCollision() throws IOException, InterruptedException {
        if(boxes.isEmpty()){
            createBoxes();
        }

        Position start = snakeView.getHead();
        for(Boxes p: boxes){
            if(start.equals(p.getPosition())){
                if(snakeModel.getPower() == Powers.STRENGTH){
                    if(SCORE != 0){
                        SCORE--;
                    }
                    boxes.remove(p);
                    return false;
                }
                snakeModel.kill();
                return true;
            }
        }

        Position snakeHead = snakeView.getHead();

        for(int i = snakeView.getBody().size()-2; i > 0; i--){
            if(snakeHead.equals(snakeView.getBody().get(i))){
                snakeModel.kill();
                return true;
            }
        }

        if(snakeHead.getX() < 0 || snakeHead.getX() > width){
            snakeModel.kill();
            return true;
        }

        if(snakeHead.getY() < 0 || snakeHead.getY() > height-2){
            snakeModel.kill();
            return true;
        }
        return false;
    }
    private LinkedList<Boxes> createBoxes() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {boxes.add(new Boxes(new Position (random.nextInt(width - 2) +1, random.nextInt(height - 2) + 1)));}
        return boxes;
    }

    public LinkedList<Boxes> getBoxes() {
        return boxes;
    }

    public void tick() throws IOException, InterruptedException {
        snakeController.move();
        if(checkCollision()) return;

        isAteApple();

        if(snakeModel.getAte()){
            createApples();
            SCORE++;
        }
        snakeModel.setAte(false);

    }
    private boolean checkCreatedBox(Boxes box) {
        if (snakeController.getDirection() == Direction.LEFT && box.getX() == snakeView.getHead().getX() -1) {return false;}

        if (snakeController.getDirection() == Direction.RIGHT && box.getX() == snakeView.getHead().getX() +1) {return false;}

        if (snakeController.getDirection() == Direction.UP && box.getY() == snakeView.getHead().getX() +1) {return false;}

        if (snakeController.getDirection() == Direction.DOWN && box.getX() == snakeView.getHead().getY() -1) {return false;}

        return true;
    }


}
