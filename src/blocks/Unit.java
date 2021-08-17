package src.blocks;

import javax.swing.JLabel;

import java.awt.Point;
import java.awt.Rectangle;


public class Unit extends JLabel{
    protected String image;
    public String headImage;

    public Rectangle innerRectangle;

    // an inner rectangle for boundary validation, not the width or
    // height of it, but the distance of it to the outer rectangle
    protected final int innerRangeX = 30;
    protected final int innerRangeY = 10;

    public Unit(Point location, String name, int width, int height) {
        int tempW = width - 2 * innerRangeX;
        int tempH = height - 2 * innerRangeY;
        innerRectangle = new Rectangle((int)location.getX() + innerRangeX, (int)location.getY() + innerRangeY, tempW, tempH);
        System.out.println(name + " at " + location);
        setName(name);
        setBounds((int)location.getX(), (int)location.getY(), width, height);
    }

    public void setLocation(Point p) {
        innerRectangle.setLocation((int)p.getX() + innerRangeX, (int)p.getY() + innerRangeY);
        setBounds((int)p.getX(), (int)p.getY(), getWidth(), getHeight());
    } 
}
