package src.informationPanels;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import src.blocks.Unit;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

public class Dialog extends JLabel{
    private JTextPane text = new JTextPane();
    private boolean visible;
    private JTextArea bg = new JTextArea();
    private Vector<Message> messageBuf = new Vector<Message>();
    private Vector<String> curMessage = new Vector<String>();
    private Unit curUnit = null;
    private UnitImage unitImage = new UnitImage();
    private final int maxLength = 155;

    private final int originX = 20;
    private final int originY = 570;
    private final int width = 960;
    private final int height = 200;

    int cnt = 0;
    public Dialog() {
        setBounds(originX, originY, width, height);
        setBackground(Color.black);
        textIntitialize();
        
        text.setFont(new Font("Courier 10 Pitch", Font.LAYOUT_LEFT_TO_RIGHT, 30));
        Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
        text.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(15, 15, 15, 15)));

        this.add(text);
        this.setVisible(false);
        visible = false;

        this.add(unitImage);
        createBackground();
    }

    private void createBackground() {
        bg.setBounds(0, 0, width, height);
        bg.setBackground(new Color(51, 153, 255, 100));
        bg.setVisible(true);
        this.add(bg);
    }


    private void textIntitialize() {
        text.setBounds(0, 0, 960, 200);
        text.setBackground(new Color(0, 0, 0, 0));
        text.setForeground(Color.WHITE);
        text.setEditable(false);
    }

    public void update() {
        if(!curMessage.isEmpty()) {
            text.setText(curMessage.get(0));
            curMessage.remove(0);
        } else if(!messageBuf.isEmpty()) {
            curUnit = messageBuf.get(0).unit;   // get the current talking unit

            if(curUnit != null) {
                System.out.println("show image");
                text.setBounds(170, 0, 790, height);
                unitImage.setVisible(true);
                unitImage.set(curUnit);
            } else {
                text.setBounds(0, 0, width, height);
                unitImage.setVisible(false);
            }

            cutTheMessage();
            text.setText(curMessage.get(0));
            curMessage.remove(0);
        } else {
            System.out.println("close the dialog");
            this.setVisible(false);
            visible = false;
        }
    }

    public void showMessage(Unit unit, String message) {
        messageBuf.add(new Message(unit, message));
        if(!visible) {
            this.setVisible(true);
            visible = true;
            update();
        }
    }

    public void showMessage(String message) {
        showMessage(null, message);
    }

    public boolean isShowing() {
        return visible;
    }

    private void cutTheMessage() {
        String m = messageBuf.get(0).text;
        int index;
        int length = m.length();

        curMessage.clear();
        messageBuf.remove(0);
        while(length > 0) {
            if(m.length() <= maxLength) {
                curMessage.add(m);
                return;
            }
            index = maxLength;
            
            // for 斷字
            while(m.charAt(index) != ' ') index --;
            
            curMessage.add(m.substring(0, index + 1));
            m = m.substring(index + 1, length);
            length = length - (index + 1); // index + 1 is the length of substring
        }
    }
}
