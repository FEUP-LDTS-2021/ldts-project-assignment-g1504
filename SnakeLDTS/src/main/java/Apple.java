import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Apple extends Element {
    public Apple(Position position){
        super(position);
    }
    public void draw(TextGraphics graphics,String color){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#EBFF00"));
        graphics.putString(new TerminalPosition(this.getX(), this.getY()), "C");
    }
}