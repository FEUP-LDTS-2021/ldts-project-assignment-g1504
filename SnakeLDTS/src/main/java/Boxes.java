import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Boxes extends Element{
    public Boxes(Position position) {
        super(position);
    }

    public void draw(TextGraphics graphics,String color){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#573d01"));
        graphics.putString(new TerminalPosition(this.getX(), this.getY()), "B");
    }
}
