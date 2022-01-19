import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;


import java.io.IOException;
import java.security.Key;
import java.util.LinkedList;
import java.util.Random;


public class Arena {
    private int width,height;
    static int SCORE;
    public static final int TICKS_PER_SECOND = 10;
    private Apple apple;
    private LinkedList<Boxes> boxes = new LinkedList<Boxes>();
    private Snake snake;


    public Arena(int width,int height, Snake snake){
        this.width = width;
        this.height = height;
        this.snake = snake;
        createApples();
        createBoxes();

    }
    public void paintArena(Screen screen) throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        graphics.fillRectangle(new TerminalPosition(0,0),new TerminalSize(width,height), ' ');
        snake.draw(graphics,snake.getColor());
        apple.draw(graphics,null);
        for(Boxes b: boxes){
            b.draw(graphics,null);
        }
        for (int j=0; j<24; j++) {
            graphics.setBackgroundColor(TextColor.ANSI.WHITE);
            graphics.putString(0,j," ");
        }

        for (int j=0; j<24; j++) {
            graphics.putString(60,j," ");
        }

        for (int j=0; j<60; j++) {
            graphics.putString(j,0," ");
        }

        for (int j=0; j<60; j++) {
            graphics.putString(j,23," ");
        }


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
        graphics.putString( 66, 5, Symbols.TRIANGLE_LEFT_POINTING_MEDIUM_BLACK + "");
        screen.refresh();
    }
    private Direction getOppositeDirection(Direction direction) {
        if (direction == Direction.LEFT) {
            return Direction.RIGHT;
        }
        if (direction == Direction.RIGHT) {
            return Direction.LEFT;
        }
        if (direction == Direction.UP) {
            return Direction.DOWN;
        }
        if (direction == Direction.DOWN) {
            return Direction.UP;
        }

        return direction;
    }
    public boolean checkCollision(){
        Position start = snake.getHead();
        for(Boxes p: boxes){
            if(start.equals(p.getPosition())){

                snake.kill();
                return true;
            }
        }


        Position snakeHead = snake.getHead();

        for(int i = snake.getBody().size()-2; i > 0;i--){
            if(snakeHead.equals(snake.getBody().get(i))){
                snake.kill();
                return true;

            }
        }
        if(snakeHead.getX() < 0 || snakeHead.getX() > width){
            snake.kill();
            return true;

        }
        if(snakeHead.getY() < 0 || snakeHead.getY() > height){
            snake.kill();
            return true;
        }


        return false;
    }
    public Snake getSnake(){
        return snake;
    }
    private void createApples(){
        Random random = new Random();
        Random power = new Random();
        apple = new Apple(new Position (random.nextInt(width - 2) +1, random.nextInt(height - 2) + 1));
        int powerNumber = power.nextInt(3);
        if(powerNumber == 1) apple.setPower(Powers.SPEED);
        if(powerNumber == 2) apple.setPower(Powers.STRENGTH);
        




    }
    public void isAteApple(){
        Position start = snake.getHead();
        if(start.equals(apple.getPosition())){
            snake.getBody().add(snake.whereTo());
            snake.setAte(true);
        }
    }

    public Apple getApples() {
        return apple;
    }
    private LinkedList<Boxes> createBoxes(){
        Random random = new Random();

        for (int i = 0; i < 3; i++)
            boxes.add(new Boxes(new Position (random.nextInt(width - 2) +1, random.nextInt(height - 2) + 1)));
        return boxes;
    }
    public LinkedList<Boxes> getBoxes(){
        return boxes;
    }




    public void tick()  {
        snake.move();
        if(checkCollision()) return;
        isAteApple();
        if(snake.getAte()){
            createApples();
            SCORE++;
        }
        snake.setAte(false);

    }
    public void run(){
        while (true){
            snake.move();
        }
    }
    /*public void updateArena(Screen screen) throws IOException {
        snake.move();
        isAteApple();
        if(snake.getAte()) {createApples();SCORE++;}
        snake.setAte(false);
        if(!checkCollision()) paintArena(screen);







    }*/
}

