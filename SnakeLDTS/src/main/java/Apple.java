import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.swing.*;
import java.awt.*;

public class Apple extends Element {
    private Powers power;
    private String color = "#FF0202";

    public Apple(Position position){super(position);}

    public String getColor() {return color;}

    public Powers getPower() {
        return power;
    }

    public void setPower(Powers power) {

        this.power = power;
        if(power == Powers.SPEED) {color = "#0224FF";}

        else if(power == Powers.STRENGTH) {color = "#FF02DC";}

        else {color = "#FF0202";}
    }

    public void draw(TextGraphics graphics, String color){
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.putString(new TerminalPosition(this.getX(), this.getY()), " ");
    }

}