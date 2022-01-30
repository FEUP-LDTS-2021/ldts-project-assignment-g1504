import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;


import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;


public class Arena {
    private int width,height;
    private int SCORE = 0; //Iniciar sempre o Score a zero quando o jogo começa
    private Timer tempo; //Temporizador das maçãs com poderes
    public static final int TICKS_PER_SECOND = 10;
    private Apple apple;
    private LinkedList<Boxes> boxes = new LinkedList<Boxes>();
    private SnakeView snakeView;
    private SnakeController snakeController;
    private SnakeModel snakeModel;

    public Arena(int width,int height, SnakeView snakeView,SnakeModel snakeModel, SnakeController snakeController){
        this.width = width;
        this.height = height;
        this.snakeView = snakeView;
        this.snakeModel = snakeModel;
        this.snakeController = snakeController;
        createApples();
        createBoxes();
    }

    public void paintArena(Screen screen) throws IOException { //Inicializar arena
        String Score = Integer.toString(SCORE);
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        graphics.fillRectangle(new TerminalPosition(0,0),new TerminalSize(width,height), ' ');
        snakeView.draw(graphics,snakeView.getColor());
        apple.draw(graphics, apple.getColor());

        for(Boxes b: boxes){b.draw(graphics,null);}

        for (int j=0; j<24; j++) {
            graphics.setBackgroundColor(TextColor.ANSI.WHITE);
            graphics.putString(0,j," ");
        }

        for (int j=0; j<24; j++) {graphics.putString(60,j," ");}

        for (int j=0; j<60; j++) {graphics.putString(j,0," ");}

        for (int j=0; j<60; j++) {graphics.putString(j,23," ");}

        for (int j=61; j<80; j++) {
            for (int i = 0; i < 24; i++) {
                graphics.setBackgroundColor(TextColor.ANSI.WHITE);
                graphics.putString(j,i," ");
            }
        }

        graphics.setBackgroundColor(TextColor.ANSI.WHITE);
        graphics.setForegroundColor(TextColor.ANSI.BLACK_BRIGHT);

        char c = Symbols.BLOCK_SOLID;
        graphics.putString( 63, 9, "    " + c + c + c + c + c);
        graphics.putString( 63, 10, "   " + c + "     " + c);
        graphics.putString( 63, 11, "   " + c + "      " + c);
        graphics.putString( 63, 12, "  " + c + " " + c + "   " + c + " " + c);
        graphics.putString( 63, 13, "  " + c + " " + c + "   " + c + "  " + c);
        graphics.putString( 63, 14, "   " + c + "      " + c);
        graphics.putString( 63, 15, "    " + c + c + c + c + c + c + c);
        graphics.putString( 63, 16, "  " + c + c + "  " + c + "   " + c + c);
        graphics.putString( 63, 17, " " + c + "   " + c + "    " + c + " " + c);
        graphics.putString(63, 18, c + "  " + c + "     " + c + "   " + c);
        graphics.putString(63, 19, c + "   " + c + c + c + c + c + "   " + c + " " + c);
        graphics.putString(63, 20, " " + c + "         " + c + c + " " + c);
        graphics.putString(63, 21, "  " + c + c + c + c + c + c + c + c + c + "  " + c);
        graphics.setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);
        graphics.putString( 64, 4, "CURRENT SCORE", SGR.BOLD);
        graphics.putString(68,5,Score,SGR.BOLD);
        graphics.putString( 66, 5, Symbols.TRIANGLE_LEFT_POINTING_MEDIUM_BLACK + "");
        screen.refresh();
    }

    private Direction getOppositeDirection(Direction direction) {
        if (direction == Direction.LEFT) {return Direction.RIGHT;}

        if (direction == Direction.RIGHT) {return Direction.LEFT;}

        if (direction == Direction.UP) {return Direction.DOWN;}

        if (direction == Direction.DOWN) {return Direction.UP;}

        return direction;
    }

    public boolean checkCollision() throws IOException, InterruptedException {
        if(boxes.isEmpty()){
            createBoxes();
        }

        Position start = snakeView.getHead();
        for(Boxes p: boxes){
            if(start.equals(p.getPosition())){
                if(snakeModel.getPower() == Powers.STRENGTH){
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

    public SnakeView getSnakeView(){
        return snakeView;
    }
    public SnakeModel getSnakeModel(){
        return snakeModel;
    }
    public SnakeController getSnakeController(){
        return snakeController;
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

    public void isAteApple() {
        Position start = snakeView.getHead();
        if(start.equals(apple.getPosition())){
            snakeView.getBody().add(snakeController.whereTo());
            snakeModel.setAte(true);
            snakeModel.setPower(apple.getPower());
        }
    }

    public Apple getApple() {
        return apple;
    }

    private LinkedList<Boxes> createBoxes() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {boxes.add(new Boxes(new Position (random.nextInt(width - 2) +1, random.nextInt(height - 2) + 1)));}
        return boxes;
    }

    private boolean checkCreatedBox(Boxes box) {
        if (snakeController.getDirection() == Direction.LEFT && box.getX() == snakeView.getHead().getX() -1) {return false;}

        if (snakeController.getDirection() == Direction.RIGHT && box.getX() == snakeView.getHead().getX() +1) {return false;}

        if (snakeController.getDirection() == Direction.UP && box.getY() == snakeView.getHead().getX() +1) {return false;}

        if (snakeController.getDirection() == Direction.DOWN && box.getX() == snakeView.getHead().getY() -1) {return false;}

        return true;
    }

    public LinkedList<Boxes> getBoxes() {
        return boxes;
    }

    public int getSCORE() {return SCORE;}

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




}

