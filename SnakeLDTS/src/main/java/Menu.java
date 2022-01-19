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

    public void drawStartMenu() throws IOException, InterruptedException {
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
        tg.putString( 36, 20, Symbols.TRIANGLE_LEFT_POINTING_MEDIUM_BLACK + " START");
        tg.setForegroundColor(TextColor.ANSI.WHITE);
        tg.putString( 26, 22, "(1)");
        tg.putString( 51, 22, "(3)");
        tg.putString( 39, 22, "(2)");

        screen.refresh();

        key = screen.readInput();
        processKey(key);
    }
    private void processKey(KeyStroke key) throws IOException, InterruptedException {
        switch (key.getCharacter()){
            case '2':
                screen.stopScreen();
                Nplayers nplayers = new Nplayers();
                nplayers.drawNplayers();
                break;
            case '1':
                screen.stopScreen();
                Help help = new Help();
                help.drawHelp();
                break;
            case '3':
                screen.stopScreen();
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

