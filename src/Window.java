package src;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Point;

import src.blocks.Knight;
import src.informationPanels.*;
import src.area.SceneChangeRecorder;
import src.blocks.NPC;

public class Window extends JFrame {
    private final int windowWidth = 1000;
    private final int windowHeight = 820;
    public Knight character;
    private Point initLocation = new Point(500, 600);
    public WorldBuilder wb;
    public SceneName scName;
    public Dialog dialog;
    public SceneChangeRecorder scr = null;

    public Window(String gameName) {
        super(gameName);
        initWindow();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        dialog.update();
                        System.out.println("clicked enter");
                        break;
                    case KeyEvent.VK_W:
                        System.out.println("up");
                        if(dialog.isShowing()) break;
                        System.out.println("up done");
                        character.move(Direction.UP);
                        break;
                    case KeyEvent.VK_S:
                        if(dialog.isShowing()) break;
                        character.move(Direction.DOWN);
                        break;
                    case KeyEvent.VK_A:
                        if(dialog.isShowing()) break;
                        character.move(Direction.LEFT);
                        break;
                    case KeyEvent.VK_D:
                        if(dialog.isShowing()) break;
                        character.move(Direction.RIGHT);
                        break;
                    case KeyEvent.VK_E:
                        if(dialog.isShowing()) break;
                        talkToNPC();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_W:
                        character.stop(Direction.UP);
                        break;
                    case KeyEvent.VK_S:
                        character.stop(Direction.DOWN);
                        break;
                    case KeyEvent.VK_A:
                        character.stop(Direction.LEFT);
                        break;
                    case KeyEvent.VK_D:
                        character.stop(Direction.RIGHT);
                        break;
                }
            }
        });        
        
        dialog = new Dialog();
        this.add(dialog);
        character = new Knight(initLocation, this);
        this.add(character);
        scName = new SceneName();
        this.add(scName);

        wb = new WorldBuilder(this, character, dialog);
        //dialog.setMessage("test");
        dialog.showMessage(character, "今天天氣真好。");
        //dialog.showMessage(null, "今天天氣真好一 今天天氣真好二 今天天氣真好三 今天天氣真好四 今天天氣真好五 今天天氣真好六 今天天氣真好七 今天天氣真好八 今天天氣真好九 今天天氣真好十 今天天氣真好十一 今天天氣真好十二 今天天氣真好十三 今天天氣真好十四 今天天氣真好十五 今天天氣真好十六 今天天氣真好十七 今天天氣真好十八 今天天氣真好十九 今天天氣真好二十 今天天氣真好一 今天天氣真好二 今天天氣真好三 今天天氣真好四 今天天氣真好五 今天天氣真好六 今天天氣真好七 今天天氣真好八 今天天氣真好九 今天天氣真好十 今天天氣真好十一 今天天氣真好十二 今天天氣真好十三 今天天氣真好十四 今天天氣真好十五 今天天氣真好十六 今天天氣真好十七 今天天氣真好十八 今天天氣真好十九 今天天氣真好二十");
        dialog.showMessage("前面出現了一群人。");
        dialog.showMessage(character, "他們是誰？");
        dialog.showMessage(character, "我躲在一旁觀察一下好了。");
    }

    private void initWindow() {
        setSize(windowWidth, windowHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        setLayout(null);
        setVisible(true);
    }

    public void update() {
        character.update();
        checkChangeScene();
        revalidate();
        repaint();
    }

    public void checkChangeScene() {
        if(scr == null) return;

        // change character location
        System.out.println(scr.getLocation());
        character.setLocation(scr.getLocation());

        changeScene(scr);
        scr = null;
    }

    public void changeScene(SceneChangeRecorder scr) {
        wb.currentBG.setVisible(false);
        wb.currentBG = scr.changeToScene;
        wb.currentBG.setVisible(true);
        scName.setSceneName(wb.currentBG.name);
        character.setCurrentBackground(wb.currentBG);
        character.setFaceAt(scr.faceAt);
        return;
    }

    public void talkToNPC() {
        for(NPC npc: wb.currentBG.npcs) {
            if(wb.character.intersectNPC(npc)) {
                npc.talk();
                //System.out.println("you are infront of " + npc.getName());
                break;
            }
        }
    }
}
