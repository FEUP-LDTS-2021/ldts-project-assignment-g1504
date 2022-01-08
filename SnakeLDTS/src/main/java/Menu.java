import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Menu {

    public Menu(){
        try{
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);



            this.screen = new TerminalScreen(terminal);

            this.screen.setCursorPosition(null);
            this.screen.startScreen();
            this.screen.doResizeIfNecessary();




        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    /*private void drawString(int x, int y, String string,String color)
    {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(x, y, string);

    }*/
    public void drawStartMenu() throws IOException {
        KeyStroke key;

        TextGraphics tg = screen.newTextGraphics();

        screen.startScreen();


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


        /*for (int i=36; i<43; i++) {
            tg.setBackgroundColor(TextColor.ANSI.WHITE);
            tg.putString(i,20, " ");
        }*/
        tg.putString( 36, 20, Symbols.TRIANGLE_LEFT_POINTING_MEDIUM_BLACK + " START");


        screen.refresh();

        key = screen.readInput();
        processKey(key);
    }
    private void processKey(KeyStroke key) throws IOException {
        switch (key.getCharacter()){
            case 'P':
                Game game = new Game();

                break;
            case 'X':

                break;
            case 'O':

                break;

            case 'Q':

                //this.screen.close();

                break;
            /*case EOF:
                play = false;
                break;*/
        }
    }
    private Screen screen;

}

