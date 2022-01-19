import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    private final static int GAME_SPEED_1 = 90;
    private final static int GAME_SPEED_2 = 75;
    private final static int GAME_SPEED_3 = 60;
    private final static int GAME_SPEED_4 = 45;
    private final static int GAME_SPEED_5 = 35;
    private Snake snake;

    public Game(Screen screen){

        this.screen = screen;
        snake = new Snake(30,15,Direction.RIGHT);
        this.arena = new Arena(60,24,snake);
    }
    private void processKey() throws IOException {
        KeyStroke key = screen.pollInput();
        if (key == null) {
            return;
        }
        if (key.getCharacter() != null) {
            return;
        }
        if(validKey(key)) {
            switch (key.getKeyType()) {
                case ArrowUp -> snake.setDirection(Direction.UP);
                case ArrowDown -> snake.setDirection(Direction.DOWN);
                case ArrowLeft -> snake.setDirection(Direction.LEFT);
                case ArrowRight -> snake.setDirection(Direction.RIGHT);
            }

        }
    }
    private boolean validKey(KeyStroke key){
        if(key.getKeyType() == KeyType.ArrowUp && snake.getDirection() == Direction.DOWN){
            return false;
        }else if(key.getKeyType() == KeyType.ArrowDown && snake.getDirection() == Direction.UP){
            return false;
        }else if(key.getKeyType() == KeyType.ArrowLeft && snake.getDirection() == Direction.RIGHT){
            return false;
        }else if( key.getKeyType() == KeyType.ArrowRight && snake.getDirection() == Direction.LEFT){
            return false;
        }
        return true;
    }
    private void tick() throws IOException {
        processKey();
        arena.tick();
        screen.clear();
        arena.paintArena(screen);


    }
    private void beginTicks() throws IOException, InterruptedException {
        while (arena.getSnake().isSnakeAlive()) {
            tick();
            Thread.sleep(1000L / Arena.TICKS_PER_SECOND);
        }

        System.exit(0);
    }

    public void  run() throws IOException, InterruptedException {
        beginTicks();
        /*while(arena.getSnake().isSnakeAlive()){

            KeyStroke key;
            key = screen.readInput();
            arena.processKey(key);
            arena.paintArena(screen);
            if(counter % GAME_SPEED_1 == 0){
                arena.tick();
            }


            /*arena.paintArena(screen);
            arena.getSnake().isAteApple(arena.getApples());
            arena.checkCollision();
        }*/


    }

    public void setArena(Arena arena){
        this.arena = arena;
    }
    private boolean running = true;
    private Arena arena;
    private Screen screen;
}
