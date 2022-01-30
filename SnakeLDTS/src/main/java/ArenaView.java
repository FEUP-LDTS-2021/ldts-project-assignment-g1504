import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;


import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;


public class ArenaView {
    private int width,height;
     //Iniciar sempre o Score a zero quando o jogo começa
    private Timer tempo; //Temporizador das maçãs com poderes
    public static final int TICKS_PER_SECOND = 10;

    private ArenaModel arenaModel;
    private SnakeView snakeView;
    private SnakeController snakeController;


    public ArenaView(int width, int height, SnakeView snakeView, SnakeController snakeController,ArenaModel arenaModel){
        this.width = width;
        this.height = height;
        this.snakeView = snakeView;

        this.snakeController = snakeController;
        this.arenaModel = arenaModel;

    }

    public void paintArena(Screen screen) throws IOException { //Inicializar arena
        String Score = Integer.toString(arenaModel.getSCORE());
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        graphics.fillRectangle(new TerminalPosition(0,0),new TerminalSize(width,height), ' ');
        snakeView.draw(graphics,snakeView.getColor());

        arenaModel.getApple().draw(graphics, arenaModel.getApple().getColor());

        for(Boxes b: arenaModel.getBoxes()){b.draw(graphics,null);}

        for (int j=0; j<24; j++) {
            graphics.setBackgroundColor(TextColor.ANSI.WHITE);
            graphics.putString(0,j," ");
        }

        for (int j=0; j<24; j++) {graphics.putString(60,j," ");}

        for (int j=0; j<60; j++) {graphics.putString(j,0," ");}

        for (int j=0; j<60; j++) {graphics.putString(j,23," ");}

        for (int j=61; j<80; j++) {
            for (int i = 0; i < 24; i++) {
                graphics.setBackgroundColor(TextColor.ANSI.WHITE);
                graphics.putString(j,i," ");
            }
        }

        graphics.setBackgroundColor(TextColor.ANSI.WHITE);
        graphics.setForegroundColor(TextColor.ANSI.BLACK_BRIGHT);

        char c = Symbols.BLOCK_SOLID;
        graphics.putString( 63, 9, "    " + c + c + c + c + c);
        graphics.putString( 63, 10, "   " + c + "     " + c);
        graphics.putString( 63, 11, "   " + c + "      " + c);
        graphics.putString( 63, 12, "  " + c + " " + c + "   " + c + " " + c);
        graphics.putString( 63, 13, "  " + c + " " + c + "   " + c + "  " + c);
        graphics.putString( 63, 14, "   " + c + "      " + c);
        graphics.putString( 63, 15, "    " + c + c + c + c + c + c + c);
        graphics.putString( 63, 16, "  " + c + c + "  " + c + "   " + c + c);
        graphics.putString( 63, 17, " " + c + "   " + c + "    " + c + " " + c);
        graphics.putString(63, 18, c + "  " + c + "     " + c + "   " + c);
        graphics.putString(63, 19, c + "   " + c + c + c + c + c + "   " + c + " " + c);
        graphics.putString(63, 20, " " + c + "         " + c + c + " " + c);
        graphics.putString(63, 21, "  " + c + c + c + c + c + c + c + c + c + "  " + c);
        graphics.setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);
        graphics.putString( 64, 4, "CURRENT SCORE", SGR.BOLD);
        graphics.putString(68,5,Score,SGR.BOLD);
        graphics.putString( 66, 5, Symbols.TRIANGLE_LEFT_POINTING_MEDIUM_BLACK + "");
        screen.refresh();
    }

    private Direction getOppositeDirection(Direction direction) {
        if (direction == Direction.LEFT) {return Direction.RIGHT;}

        if (direction == Direction.RIGHT) {return Direction.LEFT;}

        if (direction == Direction.UP) {return Direction.DOWN;}

        if (direction == Direction.DOWN) {return Direction.UP;}

        return direction;
    }



    public SnakeView getSnakeView(){
        return snakeView;
    }





















}

