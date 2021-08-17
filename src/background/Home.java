package src.background;

import src.WorldBuilder;

public class Home extends Background {
    //private Pearl pearl2 = new Pearl(new Point(200, 700), this);
    public Home(WorldBuilder wb, String name) { // set background
        super(wb, name);
        image = "background/home.png";
        //areas.add(new Area(0, 0, 1000, 450, Type.OBSTACLE));

        // add npcs
        
        // add objects
        //addNormalObject("house", "items/house.png", 180, 350, 140, 200, false);
        

        // create background
        createBackground();
    }

}