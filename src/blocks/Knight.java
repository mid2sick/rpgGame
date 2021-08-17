package src.blocks;

import java.awt.Point;
import java.awt.Rectangle;

import src.background.Background;
import src.Direction;
import src.Window;
import src.area.*;

import javax.swing.ImageIcon;


public class Knight extends MovingUnit{

    protected Window window;
    private Background currentBackground;
    public Knight(Point location, Window window) {
        super(location, "騎士", 100, 120);
        this.window = window;
        headImage = "headImages/knight.png";
        image = "idle/right0.png";
        setIcon(new ImageIcon(getClass().getClassLoader().getResource(image)));
        setBounds((int)location.getX(), (int)location.getY(), getWidth(), getHeight());
    }

    public void update() {
        // change location
        //System.out.println(currentBackground.areas.get(1).sc.getLocation().getX() + ", " + currentBackground.areas.get(1).sc.getLocation().getY());
        for(Direction direction: directions) {
            int x = (int)direction.translate().getX();
            int y = (int)direction.translate().getY();
            if(directions.size() == 2) {
                x = (int)(x / 1.3);
                y = (int)(y / 1.3);
            }

            if(isBoundaryValid(x, y)) {
                setBounds((int)getLocation().getX() + x, (int)getLocation().getY() + y, getWidth(), getHeight());
                innerRectangle.setLocation((int)getLocation().getX() + innerRangeX, (int)getLocation().getY() + innerRangeY);
            }
        }

        // change image
        fsm.update();
        revalidate();
        repaint();

    }

    public void setCurrentBackground(Background bg) {
        currentBackground = bg;
    }

    public Background getCurrentBackground() {
        return currentBackground;
    }

    public void move(Direction direction) {
        state = State.WALK;
        if(!directions.contains(direction)) {
            if(direction == Direction.LEFT)
                face = Direction.LEFT;
            if(direction == Direction.RIGHT)
                face = Direction.RIGHT;
            directions.add(direction);
        }
        System.out.println("knight: " + getLocation());
        System.out.println("inner:" + innerRectangle);
    }

    public void stop(Direction direction) {
        directions.remove(direction);
        if (directions.isEmpty()) {
            state = State.IDLE;
        }
    }

    public boolean isBoundaryValid(int x, int y) {
        Rectangle r = new Rectangle((int)innerRectangle.getX() + x, (int)innerRectangle.getY() + y, (int)innerRectangle.getWidth(), (int)innerRectangle.getHeight());
        
        for(Area a: currentBackground.areas) {
            if(a.intersects(r)) {
                if(a.type == Type.OBSTACLE) {
                    // System.out.println("a: " + a.getLocation());
                    // System.out.println("obstacle");
                    return false;
                }
                if(a.type == Type.SCENECHANGER) {
                    // System.out.println("change scene!");
                    // System.out.println("inner char = " + (innerRectangle.getX() + innerRectangle.getWidth()) + ", " + (innerRectangle.getY() + innerRectangle.getHeight()));
                    window.scr = a.scr;
                    return true;
                }
                if(a.type == Type.NPC) {
                    System.out.println("Hey! Don't push me!");
                    return false;
                }
            }
        }
        return true;
    }

    public boolean intersectNPC(NPC npc) {
        Rectangle r = new Rectangle(getX(), getY(), getWidth(), getHeight());
        Rectangle npcR = new Rectangle(npc.getX(), npc.getY(), npc.getWidth(), npc.getHeight());
        if(r.intersects(npcR)) return true;
        return false;
    }

}
