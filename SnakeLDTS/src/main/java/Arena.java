import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


import java.io.IOException;
import java.security.Key;
import java.util.LinkedList;
import java.util.Random;


public class Arena {
    private int width,height;
    private int SCORE = 0;
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
        String Score = Integer.toString(SCORE);
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        graphics.fillRectangle(new TerminalPosition(0,0),new TerminalSize(width,height), ' ');
        snake.draw(graphics,snake.getColor());
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

        Position start = snake.getHead();
        for(Boxes p: boxes){
            if(start.equals(p.getPosition())){
                if(snake.getPower() == Powers.STRENGTH){
                    boxes.remove(p);
                    return false;
                }
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

        if(snakeHead.getY() < 0 || snakeHead.getY() > height-2){
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
        int powerNumber = power.nextInt(10);

        if(powerNumber > 4 && powerNumber <= 7) {apple.setPower(Powers.SPEED);}

        else if(powerNumber > 7){apple.setPower(Powers.STRENGTH);}

        else{apple.setPower(Powers.NONE);}
    }

    public void isAteApple(){
        Position start = snake.getHead();
        if(start.equals(apple.getPosition())){
            snake.getBody().add(snake.whereTo());
            snake.setAte(true);
            snake.setPower(apple.getPower());
        }
    }

    public Apple getApple() {
        return apple;
    }

    private LinkedList<Boxes> createBoxes(){
        Random random = new Random();

        for (int i = 0; i < 10; i++)
            boxes.add(new Boxes(new Position (random.nextInt(width - 2) +1, random.nextInt(height - 2) + 1)));
        return boxes;
    }

    private boolean checkCreatedBox(Boxes box){
        if (snake.getDirection() == Direction.LEFT && box.getX() == snake.getHead().getX() -1) {return false;}

        if (snake.getDirection() == Direction.RIGHT && box.getX() == snake.getHead().getX() +1) {return false;}

        if (snake.getDirection() == Direction.UP && box.getY() == snake.getHead().getX() +1) {return false;}

        if (snake.getDirection() == Direction.DOWN && box.getX() == snake.getHead().getY() -1) {return false;}

        return true;
    }

    public LinkedList<Boxes> getBoxes(){
        return boxes;
    }

    public int getSCORE(){return SCORE;}

    public void tick() throws IOException, InterruptedException {
        snake.move();
        if(checkCollision()) return;

        isAteApple();

        if(snake.getAte()){
            createApples();
            SCORE++;
        }
        snake.setAte(false);

    }




}

