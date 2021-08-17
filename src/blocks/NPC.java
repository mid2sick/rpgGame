package src.blocks;

import src.background.*;
import src.informationPanels.Dialog;

import java.awt.Point;

import javax.swing.ImageIcon;

public class NPC extends Unit{
    public Background bg;
    public Dialog dialog;
    public NPC(Point location, Background bg, String name, String image, String headImage, int width, int height) {
        super(location, name, width, height);
        this.image = image;
        this.headImage = headImage;
        this.bg = bg;
        setIcon(new ImageIcon(getClass().getClassLoader().getResource(image)));
        System.out.println("creating npc: " + location);
    }

    public void talk() {}

    public void say(String s) {
        dialog.showMessage(this, s);
    }
}
