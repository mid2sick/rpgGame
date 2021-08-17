package src.area;

import src.background.Background;
import src.Direction;

import java.awt.Point;

public class SceneChangeRecorder {
    public Background changeToScene;
    private Point characterLocation;
    public Direction faceAt;

    public SceneChangeRecorder(Background changeToScene, Point characterLocation, Direction faceAt) {
        this.changeToScene = changeToScene;
        this.characterLocation = characterLocation;
        this.faceAt = faceAt;
    }

    public Point getLocation() {
        return characterLocation;
    }
}
