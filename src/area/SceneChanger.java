package src.area;

import src.background.Background;
import src.Direction;

import java.awt.Point;

public class SceneChanger extends Area{
    public SceneChanger(int x, int y, int width, int height, Background changeToBackground, Point characterLocation, Direction faceAt) {
        super(x, y, width, height, Type.SCENECHANGER);
        scr = new SceneChangeRecorder(changeToBackground, characterLocation, faceAt);
    }
}