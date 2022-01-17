import com.googlecode.lanterna.SGR;
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

public class Help {

    public Help(){
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

    public void drawHelp() throws IOException {
        KeyStroke key;

        TextGraphics tg = screen.newTextGraphics();

        screen.startScreen();


        for (int j=0; j<80; j++) {
            for (int i = 0; i < 24; i++) {
                tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                tg.putString(j,i," ");
            }
        }


        for (int j=0; j<80; j++) {
            for (int i = 0; i < 24; i++) {
                tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                tg.putString(j,i," ");
            }
        }

        tg.setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);

        tg.putString( 38, 2, "HELP", SGR.BOLD);
        tg.putString( 18, 6, Symbols.TRIANGLE_LEFT_POINTING_MEDIUM_BLACK + " Player 1", SGR.BOLD);
        tg.putString( 52, 6, Symbols.TRIANGLE_LEFT_POINTING_MEDIUM_BLACK + " Player 2", SGR.BOLD);

        //PLAYER1
        for (int j=21; j<26; j++) {
            for (int i = 8; i < 11; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(j,i," ");
            }
        }
        tg.putString( 23, 9, "W");

        for (int j=21; j<26; j++) {
            for (int i = 12; i < 15; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(j,i," ");
            }
        }
        tg.putString( 23, 13, "S");

        for (int j=28; j<33; j++) {
            for (int i = 12; i < 15; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(j,i," ");
            }
        }
        tg.putString( 30, 13, "D");

        for (int j=14; j<19; j++) {
            for (int i = 12; i < 15; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(j,i," ");
            }
        }
        tg.putString( 16, 13, "A");


        //PLAYER2
        for (int j=55; j<60; j++) {
            for (int i = 8; i < 11; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(j,i," ");
            }
        }
        tg.putString( 57, 9, String.valueOf(Symbols.ARROW_UP));

        for (int j=55; j<60; j++) {
            for (int i = 12; i < 15; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(j,i," ");
            }
        }
        tg.putString( 57, 13, String.valueOf(Symbols.ARROW_DOWN));

        for (int j=62; j<67; j++) {
            for (int i = 12; i < 15; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(j,i," ");
            }
        }
        tg.putString( 64, 13, String.valueOf(Symbols.ARROW_RIGHT));

        for (int j=48; j<53; j++) {
            for (int i = 12; i < 15; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(j,i," ");
            }
        }
        tg.putString( 50, 13, String.valueOf(Symbols.ARROW_LEFT));


        tg.setBackgroundColor(TextColor.ANSI.WHITE);
        for (int i= 11; i < 70; i++) {
            tg.putString(i, 4, " ");
            //Thread.sleep(10);
            screen.refresh();
        }

        for (int i= 4; i < 18; i++) {
            tg.putString(69, i, " ");
            tg.putString(70, i, " ");
            //Thread.sleep(10);
            screen.refresh();
        }

        for (int i= 70; i > 11; i--) {
            tg.putString(i, 18, " ");
            //Thread.sleep(10);
            screen.refresh();
        }

        for (int i= 18; i > 3; i--) {
            tg.putString(10, i, " ");
            tg.putString(11, i, " ");
            //Thread.sleep(10);
            screen.refresh();
        }

        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.setForegroundColor(TextColor.ANSI.WHITE);
        tg.putString( 37, 20, "(ENTER)");


        screen.refresh();

        key = screen.readInput();
        processKey(key);
    }
    private void processKey(KeyStroke key) throws IOException {
        switch (key.getCharacter()){
            case '\n':
                screen.stopScreen();
                Menu menu = new Menu();
                menu.drawStartMenu();
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

