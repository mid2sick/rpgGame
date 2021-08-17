package src.background;



import src.Direction;
import src.WorldBuilder;
import src.area.*;
import src.blocks.NPC;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Point;

public class Background {
    public WorldBuilder wb;
    protected String image;
    public ArrayList<Area> areas = new ArrayList<Area>(); // to record obstacles and scene changers
    public ArrayList<NPC> npcs = new ArrayList<NPC>();
    public JPanel panel = new JPanel();
    protected JLabel background = new JLabel();
    protected final int width = 1000;
    protected final int height = 800;
    public String name;

    public Background(WorldBuilder wb, String name) {
        this.wb = wb;
        panel.setBounds(0, -10, width, height); // why -10 can make the above white disappear?
        panel.setBackground(null);
        panel.setLayout(null);
        this.name = name;
    }

    public void createBackground() {
        background.setBounds(0, 0, width, height);
        background.setBackground(new Color(0, 0, 0, 0));
        background.setIcon(new ImageIcon(getClass().getClassLoader().getResource(image)));
        panel.add(background);
    }

    public void addSceneChangeRecorder(int x, int y, int width, int height, Background changeToBackground, Point characterLocation, Direction faceAt) {
        areas.add(new SceneChanger(x, y, width, height, changeToBackground, characterLocation, faceAt));
    }

    public void addBoundary(Direction d) {
        switch(d) {
            case LEFT:
                areas.add(new Area(0, -10, 10, 1020, Type.OBSTACLE));
                break;
            case RIGHT:
                areas.add(new Area(1000, -10, 10, 1020, Type.OBSTACLE));
                break;
            case UP:
                areas.add(new Area(-10, -10, 1020, 10, Type.OBSTACLE));
                break;
            case DOWN:
                areas.add(new Area(-10, 790, 1020, 10, Type.OBSTACLE));
                break;
        }
    }

    public void setVisible(boolean t) {
        panel.setVisible(t);
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);
        panel.add(npc);
        System.out.println("npc: " + npc.innerRectangle);
        areas.add(new Area((int)npc.innerRectangle.getX(), (int)npc.innerRectangle.getY(), (int)npc.innerRectangle.getWidth(), (int)npc.innerRectangle.getHeight(), Type.NPC));
    }

    // add item with no interactions
    public void addNormalObject(String name, String pathname, int x, int y, int w, int h, boolean passable) {
        JLabel object = new JLabel();
        object.setBounds(x, y, w, h);
        object.setIcon(new ImageIcon(getClass().getClassLoader().getResource(pathname)));
        object.setName(name);
        panel.add(object);
        if(!passable) areas.add(new Area(x, y, w, h - 100, Type.OBSTACLE));
    }
}
