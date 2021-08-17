package src.background;

import src.WorldBuilder;
import src.area.*;
import src.blocks.NPC;
import src.blocks.npc.Pearl;

import java.awt.Point;

public class Woods extends Background {
    //public NPC pearl = new NPC(new Point(800, 500), this, "Pearl", "units/pearl.png", "headImages/pearl.png", 100, 160);
    public NPC pearl = new Pearl(new Point(800, 500), this);

    public Woods(WorldBuilder wb, String name) { // set background
        super(wb, name);
        image = "background/woods.png";
        areas.add(new Area(0, 0, 1000, 320, Type.OBSTACLE));

        // add NPCs
        addNPC(pearl);
        
        // create background
        createBackground();
    }

}