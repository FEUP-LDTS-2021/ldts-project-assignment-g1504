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


public class Custom {
    private int width,height;

    public void snake(TextGraphics tg) {
        char c = Symbols.BLOCK_SOLID;
        tg.putString(32, 6, "    " + c + c + c + c + c);
        tg.putString(32, 7, "   " + c + "     " + c);
        tg.putString(32, 8, "   " + c + "      " + c);
        tg.putString(32, 9, "  " + c + " " + c + "   " + c + " " + c);
        tg.putString(32, 10, "  " + c + " " + c + "   " + c + "  " + c);
        tg.putString(32, 11, "   " + c + "      " + c);
        tg.putString(32, 12, "    " + c + c + c + c + c + c + c);
        tg.putString(32, 13, "  " + c + c + "  " + c + "   " + c + c);
        tg.putString(32, 14, " " + c + "   " + c + "    " + c + " " + c);
        tg.putString(32, 15, c + "  " + c + "     " + c + "   " + c);
        tg.putString(32, 16, c + "   " + c + c + c + c + c + "   " + c + " " + c);
        tg.putString(32, 17, " " + c + "         " + c + c + " " + c);
        tg.putString(32, 18, "  " + c + c + c + c + c + c + c + c + c + "  " + c);
    }


    public void paintCustom(Screen screen) throws IOException, InterruptedException {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.fillRectangle(new TerminalPosition(0,0),new TerminalSize(width,height), ' ');

        for (int j=0; j<80; j++) {
            for (int i = 0; i < 24; i++) {
                tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                tg.putString(j,i," ");
            }
        }

        tg.setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);

        tg.putString( 32, 2, " CUSTOMIZE SNAKE", SGR.BOLD);

        tg.setBackgroundColor(TextColor.ANSI.WHITE);

        for (int i= 11; i < 70; i++) {
            tg.putString(i, 4, " ");
            //Thread.sleep(10);
            screen.refresh();
        }

        for (int i= 4; i < 20; i++) {
            tg.putString(69, i, " ");
            tg.putString(70, i, " ");
            //Thread.sleep(10);
            screen.refresh();
        }

        for (int i= 70; i > 11; i--) {
            tg.putString(i, 20, " ");
            //Thread.sleep(10);
            screen.refresh();
        }

        for (int i= 20; i > 3; i--) {
            tg.putString(10, i, " ");
            tg.putString(11, i, " ");
            //Thread.sleep(10);
            screen.refresh();
        }

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.setForegroundColor(TextColor.ANSI.WHITE);
        snake(tg);

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(15, 7, "(1)", SGR.BOLD);
        tg.setBackgroundColor(TextColor.ANSI.BLUE);
        tg.putString(18,7," ");
        tg.putString(19,7," ");

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.putString(15, 9, "(2)", SGR.BOLD);
        tg.setBackgroundColor(TextColor.ANSI.MAGENTA);
        tg.putString(18,9," ");
        tg.putString(19,9," ");

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.putString(15, 11, "(3)", SGR.BOLD);
        tg.setBackgroundColor(TextColor.ANSI.YELLOW);
        tg.putString(18,11," ");
        tg.putString(19,11," ");

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.putString(15, 13, "(4)", SGR.BOLD);
        tg.setBackgroundColor(TextColor.ANSI.RED);
        tg.putString(18,13," ");
        tg.putString(19,13," ");

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.putString(15, 15, "(5)", SGR.BOLD);
        tg.setBackgroundColor(TextColor.ANSI.GREEN);
        tg.putString(18,15," ");
        tg.putString(19,15," ");

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(59, 7, "(6)", SGR.BOLD);
        tg.setBackgroundColor(TextColor.ANSI.BLUE_BRIGHT);
        tg.putString(62,7," ");
        tg.putString(63,7," ");

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.putString(59, 9, "(7)", SGR.BOLD);
        tg.setBackgroundColor(TextColor.ANSI.MAGENTA_BRIGHT);
        tg.putString(62,9," ");
        tg.putString(63,9," ");

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.putString(59, 11, "(8)", SGR.BOLD);
        tg.setBackgroundColor(TextColor.ANSI.YELLOW_BRIGHT);
        tg.putString(62,11," ");
        tg.putString(63,11," ");

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.putString(59, 13, "(9)", SGR.BOLD);
        tg.setBackgroundColor(TextColor.ANSI.RED_BRIGHT);
        tg.putString(62,13," ");
        tg.putString(63,13," ");

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.putString(59, 15, "(0)", SGR.BOLD);
        tg.setBackgroundColor(TextColor.ANSI.GREEN_BRIGHT);
        tg.putString(62,15," ");
        tg.putString(63,15," ");

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.setForegroundColor(TextColor.ANSI.WHITE);
        tg.putString( 37, 22, "(ENTER)");

        screen.refresh();

        KeyStroke key;
        do {
            key = screen.readInput();

            switch (key.getCharacter()) {
                case 'x':
                    Menu2 menu2 = new Menu2();
                    menu2.paintMenu2(screen);
                    break;

                case '\n':
                    Game game = new Game(screen, color);
                    game.run();
                    break;

                case '1':
                    color = String.valueOf(TextColor.ANSI.BLUE);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                    tg.setForegroundColor(TextColor.ANSI.BLUE);
                    snake(tg);
                    screen.refresh();
                    break;

                case '2':
                    color = String.valueOf(TextColor.ANSI.MAGENTA);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                    tg.setForegroundColor(TextColor.ANSI.MAGENTA);
                    snake(tg);
                    screen.refresh();
                    break;

                case '3':
                    color = String.valueOf(TextColor.ANSI.YELLOW);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                    tg.setForegroundColor(TextColor.ANSI.YELLOW);
                    snake(tg);
                    screen.refresh();
                    break;

                case '4':
                    color = String.valueOf(TextColor.ANSI.RED);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                    tg.setForegroundColor(TextColor.ANSI.RED);
                    snake(tg);
                    screen.refresh();
                    break;

                case '5':
                    color = String.valueOf(TextColor.ANSI.GREEN);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                    tg.setForegroundColor(TextColor.ANSI.GREEN);
                    snake(tg);
                    screen.refresh();
                    break;

                case '6':
                    color = String.valueOf(TextColor.ANSI.BLUE_BRIGHT);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                    tg.setForegroundColor(TextColor.ANSI.BLUE_BRIGHT);
                    snake(tg);
                    screen.refresh();
                    break;

                case '7':
                    color = String.valueOf(TextColor.ANSI.MAGENTA_BRIGHT);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                    tg.setForegroundColor(TextColor.ANSI.MAGENTA_BRIGHT);
                    snake(tg);
                    screen.refresh();
                    break;

                case '8':
                    color = String.valueOf(TextColor.ANSI.YELLOW_BRIGHT);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                    tg.setForegroundColor(TextColor.ANSI.YELLOW_BRIGHT);
                    snake(tg);
                    screen.refresh();
                    break;

                case '9':
                    color = String.valueOf(TextColor.ANSI.RED_BRIGHT);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                    tg.setForegroundColor(TextColor.ANSI.RED_BRIGHT);
                    snake(tg);
                    screen.refresh();
                    break;

                case '0':
                    color = String.valueOf(TextColor.ANSI.GREEN_BRIGHT);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                    tg.setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);
                    snake(tg);
                    screen.refresh();
                    break;
            }
        } while (key.getCharacter() != '\n' || key.getCharacter() != 'x');
    }

    private String color;
}