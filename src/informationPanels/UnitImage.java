package src.informationPanels;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import src.blocks.Unit;

public class UnitImage extends JLabel{
    public JLabel picture = new JLabel();
    //public JLabel name = new JLabel();
    public JTextPane name = new JTextPane();
    private final int width = 171;
    private final int height = 200;
    public UnitImage() {

        // initialize the whole image label
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        this.setBounds(0, 0, width, height);
        this.setVisible(false);

        picture.setBounds(20, 20, 130, 130);
        
        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontSize(attribs, 20);
        StyleConstants.setForeground(attribs, Color.BLACK);
        name.setParagraphAttributes(attribs, true);
        name.setBorder(BorderFactory.createLineBorder(new Color(30, 100, 255), 2));
        name.setBounds(20, 160, 130, 30);
        name.setBackground(new Color(51, 200, 255, 100));
        this.add(picture);
        this.add(name);
    }

    public void set(Unit unit) {
        picture.setIcon(new ImageIcon(getClass().getClassLoader().getResource(unit.headImage)));
        name.setText(unit.getName());
    }
}
