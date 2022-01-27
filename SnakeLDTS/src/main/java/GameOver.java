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


public class GameOver {
    private int width, height;

    public void paintGameOver(Screen screen, int score) throws IOException, InterruptedException {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        for (int j = 0; j < 80; j++) {
            for (int i = 0; i < 24; i++) {
                tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                tg.putString(j, i, " ");
            }
        }

        for (int j = 0; j < 80; j++) {
            for (int i = 0; i < 24; i++) {
                tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                tg.putString(j, i, " ");
            }
        }

        tg.setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);

        tg.putString(36, 2, "GAME OVER", SGR.BOLD);

        tg.setBackgroundColor(TextColor.ANSI.WHITE);
        for (int i = 11; i < 70; i++) {
            tg.putString(i, 4, " ");
            //Thread.sleep(10);
            screen.refresh();
        }

        for (int i = 4; i < 20; i++) {
            tg.putString(69, i, " ");
            tg.putString(70, i, " ");
            //Thread.sleep(10);
            screen.refresh();
        }

        for (int i = 70; i > 11; i--) {
            tg.putString(i, 20, " ");
            //Thread.sleep(10);
            screen.refresh();
        }

        for (int i = 20; i > 3; i--) {
            tg.putString(10, i, " ");
            tg.putString(11, i, " ");
            //Thread.sleep(10);
            screen.refresh();
        }

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);

        char c = Symbols.BLOCK_SOLID;
        tg.putString(17, 6, "    " + c + c + c + c + c);
        tg.putString(17, 7, "   " + c + "     " + c);
        tg.putString(17, 8, "   " + c + "      " + c);
        tg.putString(17, 9, "  " + c + " " + c + "   " + c + " " + c);
        tg.putString(17, 10, "  " + c + " " + c + "   " + c + "  " + c);
        tg.putString(17, 11, "   " + c + "      " + c);
        tg.putString(17, 12, "    " + c + c + c + c + c + c + c);
        tg.putString(17, 13, "  " + c + c + "  " + c + "   " + c + c);
        tg.putString(17, 14, " " + c + "   " + c + "    " + c + " " + c);
        tg.putString(17, 15, c + "  " + c + "     " + c + "   " + c);
        tg.putString(17, 16, c + "   " + c + c + c + c + c + "   " + c + " " + c);
        tg.putString(17, 17, " " + c + "         " + c + c + " " + c);
        tg.putString(17, 18, "  " + c + c + c + c + c + c + c + c + c + "  " + c);


        tg.setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);
        tg.putString(39, 12, "POINTS SCORED:", SGR.BOLD);
        tg.putString(39, 14, score + "", SGR.BOLD);
        tg.putString(39, 16, "1. Play Again", SGR.BOLD);
        tg.putString(39, 17, "2. Exit", SGR.BOLD);
        screen.refresh();

        KeyStroke key;
        key = screen.readInput();
        processKey(key);

        switch (key.getCharacter()) {
            case '1':
                screen.stopScreen();
                Menu menu = new Menu();
                menu.drawStartMenu();
                break;

            case '2':
                System.exit(0);
        }
    }

    private void processKey(KeyStroke key) throws IOException, InterruptedException {

    }
}