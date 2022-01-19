import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Apple extends Element {
    private Powers power;
    public Apple(Position position){
        super(position);

    }

    public Powers getPower() {
        return power;
    }

    public void setPower(Powers power) {
        this.power = power;
    }

    public void draw(TextGraphics graphics, String color){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#EBFF00"));
        graphics.putString(new TerminalPosition(this.getX(), this.getY()), "C");
    }
}
