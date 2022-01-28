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


public class Menu2 { //Menu onde se escolhem as cores da cobra
    private int width,height;

    public void paintMenu2(Screen screen) throws IOException, InterruptedException {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.fillRectangle(new TerminalPosition(0,0),new TerminalSize(width,height), ' ');

        for (int j=0; j<80; j++) {
            for (int i = 0; i < 24; i++) {
                tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                tg.putString(j,i," ");
            }
        }

        tg.setForegroundColor(TextColor.ANSI.DEFAULT);

        char c = Symbols.BLOCK_SOLID;
        tg.putString(11, 2, "    " + c + c + c + c + "         " + c + c + c + c + c + "    " + c + c + c + c + c + "     " + c + "        " + c + c);
        tg.putString(11, 3, "  " + c + c + c + "   " + c + c + "       " + c + "   " + c + c + "  " + c + c + "    " + c + c + "  " + c + " " + c + " " + c + c + c + c + " " + c + "  " + c + " " + c + c + c + c);
        tg.putString(11, 4, " " + c + c + "      " + c + "  " + c + c + c + c + c + c + "    " + c + " " + c + c + "       " + c + "  " + c + "  " + c + "  " + c + " " + c + "   " + c + "    " + c + c);
        tg.putString(11, 5, " " + c + "       " + c + "  " + c + "   " + c + c + "    " + c + " " + c + "  " + c + c + c + "    " + c + "   " + c + "   " + c + " " + c + "   " + c + "      " + c);
        tg.putString(11, 6, " " + c + "      " + c + c + "  " + c + "    " + c + c + "    " + c + "   " + c + "      " + c + "   " + c + "  " + c + "  " + c + "   " + c + "      " + c);
        tg.putString(11, 7, " " + c + "    " + c + c + "    " + c + "     " +  c + "    " + c + "   " + c + " " + c + "    " + c + "   " + c + "  " + c + "  " + c + "   " + c + "      " + c);
        tg.putString(11, 8, c + "      " + c + "    " + c + "          " + c + c + "   " + c + c + "     " + c + " " + c + "   " + c + c + c + "   " + c + "      " + c + c);
        tg.putString(11, 9, c + "       " + c + c + "  " + c + "   " + c + "      " + c + c + "          " + c + c + c + "        " + c + "  " + c + c + c + c + c );
        tg.putString(11, 10, " " + c + "  " + c + c + "   " + c + c + " " + c + "   " + c + c + "      " + c + "           " + c + c + "      " + c + c + c + "     " + c);
        tg.putString(11, 11, " " + c + c + c + c + "     " + c + " " + c + "     " + c + "     " + c + "     " + c + c + c + "   " + c + c + "        " + c + "     " + c);
        tg.putString(11, 12, " " + c + c + "        " + c + c + "     " + c + c + "    " + c + "     " + c + " " + c + "   " + c + c + "        " + c + c + "  " + c + c + c + c + c + c);
        tg.putString(11, 13, " " + c + "         " + c + c + "      " + c + "    " + c + c + "   " + c + c + " " + c + c + "  " + c + "    " + c + c + "    " + c + "       " + c);
        tg.putString(11, 14, " " + c + "        " + c + c + c + "      " + c + c + "   " + c + c + "    " + c + "  " + c + "  " + c + "    " + c + " " + c + "   " + c + "        " + c);
        tg.putString(11, 15, " " + c + "        " + c + " " + c + "     " + c + c + c + "    " + c + "    " + c + "  " + c + c + c + c + "    " + c + " " + c + "   " + c + "        " + c);
        tg.putString(11, 16, " " + c + "       " + c + "  " + c + "    " + c + c + "  " + c + c + c + "  " + c + "  " + c + c + "      " + c + c + c + c + "  " + c + c + "  " + c + c + "      " + c);
        tg.putString(11, 17, "  " + c + "   " + c + c + c + "   " + c + c + c + c+ c + "         " + c + c + c + "              " + c + c + c + c + "  " + c + c + c + c + c +c);
        tg.putString(11, 18, "   " + c + c + c + c+ c + "      " + c + c);

        tg.setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);
        tg.putString( 24, 20, Symbols.TRIANGLE_LEFT_POINTING_MEDIUM_BLACK + " HELP");
        tg.putString( 49, 20, Symbols.TRIANGLE_LEFT_POINTING_MEDIUM_BLACK + " EXIT");
        tg.putString( 36, 20, Symbols.TRIANGLE_LEFT_POINTING_MEDIUM_BLACK + " START");
        tg.setForegroundColor(TextColor.ANSI.WHITE);
        tg.putString( 26, 22, "(1)");
        tg.putString( 51, 22, "(3)");
        tg.putString( 39, 22, "(2)");

        screen.refresh();

        KeyStroke key;
        key = screen.readInput();
        processKey(key);

        switch (key.getCharacter()){
            case '1':
                Help help = new Help();
                help.paintHelp(screen);
                break;

            case '3':
                screen.stopScreen();
                break;

            case '2':
                Custom custom = new Custom();
                custom.paintCustom(screen);
                break;
        }
    }

    private void processKey(KeyStroke key) throws IOException, InterruptedException {

    }


}