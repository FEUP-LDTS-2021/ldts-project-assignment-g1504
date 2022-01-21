import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;


import java.io.IOException;


public class Help {
    private int width,height;


    public void paintHelp(Screen screen) throws IOException, InterruptedException {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.fillRectangle(new TerminalPosition(0,0),new TerminalSize(width,height), ' ');

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

        for (int j=25; j<30; j++) {
            for (int i = 10; i < 13; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE_BRIGHT);
                tg.putString(j,i," ");
            }
        }

        for (int j=25; j<30; j++) {
            for (int i = 14; i < 17; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE_BRIGHT);
                tg.putString(j,i," ");
            }
        }

        for (int j=32; j<37; j++) {
            for (int i = 14; i < 17; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE_BRIGHT);
                tg.putString(j,i," ");
            }
        }

        for (int j=18; j<23; j++) {
            for (int i = 14; i < 17; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE_BRIGHT);
                tg.putString(j,i," ");
            }
        }


        //PLAYER1
        for (int j=24; j<29; j++) {
            for (int i = 9; i < 12; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(j,i," ");
            }
        }
        tg.putString( 26, 10, "" + Symbols.ARROW_UP);

        for (int j=24; j<29; j++) {
            for (int i = 13; i < 16; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(j,i," ");
            }
        }
        tg.putString( 26, 14, "" + Symbols.ARROW_DOWN);

        for (int j=31; j<36; j++) {
            for (int i = 13; i < 16; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(j,i," ");
            }
        }
        tg.putString( 33, 14, "" + Symbols.ARROW_RIGHT);

        for (int j=17; j<22; j++) {
            for (int i = 13; i < 16; i++) {
                tg.setBackgroundColor(TextColor.ANSI.WHITE);
                tg.putString(j,i," ");
            }
        }
        tg.putString( 19, 14, "" + Symbols.ARROW_LEFT);


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
        tg.putString( 37, 22, "(ENTER)");


        screen.refresh();

        KeyStroke key;
        key = screen.readInput();
        processKey(key);

        switch (key.getCharacter()){
            case '\n':
                Menu2 menu2 = new Menu2();
                menu2.paintMenu2(screen);
                break;

        }

    }

    private void processKey(KeyStroke key) throws IOException, InterruptedException {

    }


}

