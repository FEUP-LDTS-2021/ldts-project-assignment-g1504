import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Arena {
    public Arena(int width,int height){
        this.width = width;
        this.height = height;
        snake = new Snake(30,15,Direction.RIGHT);
        createApples();
        createBoxes();

    }
    public void paintArena(TextGraphics graphics){

        graphics.setBackgroundColor(TextColor.Factory.fromString("#faf5f5"));
        graphics.fillRectangle(new TerminalPosition(0,0),new TerminalSize(width,height), ' ');
        snake.draw(graphics,snake.getColor());
        apples.get(apples.size()-1).draw(graphics,null);
        for(Boxes b: boxes){
            b.draw(graphics,null);
        }

    }

    public Snake getSnake(){
        return snake;
    }
    private LinkedList<Apple> createApples(){
        Random random = new Random();

        for (int i = 0; i < 7; i++)
            apples.add(new Apple(new Position (random.nextInt(width - 2) +1, random.nextInt(height - 2) + 1)));

        return apples;
    }


    public LinkedList<Apple> getApples() {
        return apples;
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

    private int width,height;
    private LinkedList<Apple> apples = new LinkedList<Apple>();
    private LinkedList<Boxes> boxes = new LinkedList<Boxes>();
    private Snake snake;

    public void processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp:
                snake.setDirection(Direction.UP);
                snake.move();
                break;
            case ArrowDown:
                snake.setDirection(Direction.DOWN);
                snake.move();
                break;
            case ArrowLeft:
                snake.setDirection(Direction.LEFT);
                snake.move();
                break;

            case ArrowRight:
                snake.setDirection(Direction.RIGHT);
                snake.move();


                break;
            /*case EOF:
                play = false;
                break;*/
        }
    }
}

