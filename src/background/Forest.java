package src.background;

import src.WorldBuilder;
import src.area.*;
import src.blocks.npc.*;

import java.awt.Point;

public class Forest extends Background {
    private Pearl pearl2 = new Pearl(new Point(200, 700), this);
    public Forest(WorldBuilder wb, String name) { // set background
        super(wb, name);
        image = "background/forest.png";
        areas.add(new Area(0, 0, 1000, 450, Type.OBSTACLE));

        // add npcs
        addNPC(pearl2);
        
        // add objects
        addNormalObject("house", "items/house.png", 180, 350, 140, 200, false);

        // create background
        createBackground();
    }

}