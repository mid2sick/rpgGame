package src.area;

import java.awt.Rectangle;

public class Area extends Rectangle{
    public Type type;
    public SceneChangeRecorder scr; // it is null for normal area
    public Area(int x, int y, int width, int height, Type type) {
        super(x, y, width, height);
        this.type = type;
    }
}