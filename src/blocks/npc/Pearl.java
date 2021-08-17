package src.blocks.npc;

import src.blocks.NPC;
import src.background.*;

import java.awt.Point;

public class Pearl extends NPC{
    private static String name = "珍珠";
    private static String image = "units/pearl.png";
    private static String headImage = "headImages/pearl.png";
    private static int width = 100;
    private static int height = 160;
    private int cond = 0;
    public Pearl(Point loc, Background bg) {
        super(loc, bg, name, image, headImage, width, height);
    }


    public void talk() {
        switch(cond) {
            case 0:
                greetings();
                cond = 1;
                break;
            case 1:
                introduce();
                cond = 2;
                break;
            case 2:
                casual();
                break;
        }
    }
    public void greetings() {
        if(dialog == null) dialog = bg.wb.dialog;
        say("嘿，人類！第一次見到你。");
        say("需要帶你參觀這附近嗎？");
    }

    public void introduce() {
        say("我叫珍珠，正好來這裡調查事情。");
        say("什麼？你不知道你在這裡幹麻？");
        say("聽起來真是......");
        dialog.showMessage("珍珠仔細打量了你。");
        say("可疑。");
    }

    public void casual() {
        say("那你打算做什麼呢？");
    }

}
