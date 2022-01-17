import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;
import java.io.IOException;

public class Game {
    public Game(Arena arena,Screen screen){
        this.arena = arena;
        this.screen = screen;
    }
    public void  run() throws IOException {
        while(true){
            KeyStroke key;
            screen.clear();
            arena.paintArena(screen.newTextGraphics());
            screen.refresh();
            key = screen.readInput();
            arena.processKey(key);
            arena.getSnake().isAteApple(arena.getApples());
        }



    }
    public void setArena(Arena arena){
        this.arena = arena;
    }

    private Arena arena;
    private Screen screen;
}
