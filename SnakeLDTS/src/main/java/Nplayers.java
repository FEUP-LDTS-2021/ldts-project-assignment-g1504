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

public class Nplayers{

    public Nplayers(){
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

    public void drawNplayers() throws IOException {
        KeyStroke key;

        TextGraphics tg = screen.newTextGraphics();

        screen.startScreen();


        for (int j=0; j<80; j++) {
            for (int i = 0; i < 24; i++) {
                tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                tg.putString(j,i," ");
            }
        }


        tg.setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);

        tg.putString( 32, 2, "NUMBER OF PLAYERS", SGR.BOLD);


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
        char c = Symbols.BLOCK_SOLID;

        tg.setForegroundColor(TextColor.ANSI.WHITE_BRIGHT);
        tg.putString(51, 6, "    " + c + c + c + c + c + c);
        tg.putString(51, 7, "   " + c + c + c + c + c + c + c + c);
        tg.putString(51, 8, "   " + c + c + c + c + c + c + c + c);
        tg.putString(51, 9, "   " + c + c + c + c + c + c + c + c);
        tg.putString(51, 10, "   " + c + c + c + c + c + c + c + c);
        tg.putString(51, 11, "    " + c + c + c + c + c + c);
        tg.putString(51, 12, "     " + c + c + c + c);
        tg.putString(51, 13, "  " + c + c + c + c + c + c + c + c + c + c);
        tg.putString(51, 14, " " + c + c + c + c + c + c + c + c + c + c + c + c);
        tg.putString(51, 15, "" + c + c + c + c + c + c + c + c + c + c + c + c + c + c);


        tg.setForegroundColor(TextColor.ANSI.DEFAULT);


        tg.putString(47, 6, "    " + c + c + c + c + c + c);
        tg.putString(47, 7, "   " + c + c + c + c + c + c + c + c);
        tg.putString(47, 8, "   " + c + c + c + c + c + c + c + c);
        tg.putString(47, 9, "   " + c + c + c + c + c + c + c + c);
        tg.putString(47, 10, "   " + c + c + c + c + c + c + c + c);
        tg.putString(47, 11, "    " + c + c + c + c + c + c);
        tg.putString(47, 12, "     " + c + c + c + c);
        tg.putString(47, 13, "  " + c + c + c + c + c + c + c + c + c + c);
        tg.putString(47, 14, " " + c + c + c + c + c + c + c + c + c + c + c + c);
        tg.putString(47, 15, "" + c + c + c + c + c + c + c + c + c + c + c + c + c + c);
        tg.putString(53, 16, "(2)");

        tg.putString(17, 6, "    " + c + c + c + c + c + c);
        tg.putString(17, 7, "   " + c + c + c + c + c + c + c + c);
        tg.putString(17, 8, "   " + c + c + c + c + c + c + c + c);
        tg.putString(17, 9, "   " + c + c + c + c + c + c + c + c);
        tg.putString(17, 10, "   " + c + c + c + c + c + c + c + c);
        tg.putString(17, 11, "    " + c + c + c + c + c + c);
        tg.putString(17, 12, "     " + c + c + c + c);
        tg.putString(17, 13, "  " + c + c + c + c + c + c + c + c + c + c);
        tg.putString(17, 14, " " + c + c + c + c + c + c + c + c + c + c + c + c);
        tg.putString(17, 15, "" + c + c + c + c + c + c + c + c + c + c + c + c + c + c);
        tg.putString(22, 16, "(1)");

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
            case '1':
                Arena arena = new Arena(80,24);
                Game game  = new Game(arena,screen);

                game.run();
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