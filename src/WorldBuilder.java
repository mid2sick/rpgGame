package src;

import src.background.*;
import src.blocks.Knight;
import src.informationPanels.Dialog;

import java.awt.Point;

public class WorldBuilder {
    public Window window;
    public Background home = new Home(this, "家");
    public Background forest = new Forest(this, "森林深處");
    public Background woods = new Woods(this, "森林");
    public Background currentBG;
    public Knight character;
    public Dialog dialog;

    public WorldBuilder(Window window, Knight character, Dialog dialog) {
        this.window = window;
        this.character = character;
        this.dialog = dialog;

        addScene(woods);
        addScene(forest);
        addScene(home);
        woods.addSceneChangeRecorder(-50, 320, 50, 480, forest, new Point(880, 600), Direction.LEFT);
        woods.addBoundary(Direction.RIGHT);
        woods.addBoundary(Direction.DOWN);

        forest.addSceneChangeRecorder(1050, 400, 50, 400, woods, new Point(20, 600), Direction.RIGHT);
        forest.addSceneChangeRecorder(180, 370, 140, 100, home, new Point(180, 390), Direction.RIGHT);
        forest.addBoundary(Direction.LEFT);
        forest.addBoundary(Direction.DOWN);


        home.addBoundary(Direction.LEFT);
        home.addBoundary(Direction.DOWN);
        home.addBoundary(Direction.RIGHT);
        home.addSceneChangeRecorder(90, 360, 70, 100, forest, new Point(200, 500), Direction.LEFT);

        

        //currentBG = woods;
        //this.character.setCurrentBackground(woods);
        startAt(forest);
        window.scName.setSceneName(currentBG.name);
    }

    public void addScene(Background bg) {
        window.add(bg.panel);
        bg.setVisible(false);
    }

    public void startAt(Background bg) {
        currentBG = bg;
        character.setCurrentBackground(bg);
        bg.setVisible(true);
    }
    
}
