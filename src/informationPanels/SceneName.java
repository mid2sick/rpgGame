package src.informationPanels;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class SceneName extends JLabel{
    private JTextPane text = new JTextPane();
    private final int boxWidth = 150;
    private final int boxHeight = 50;
    public SceneName() {
        this.setBounds(425, 0, boxWidth, boxHeight);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);

        text.setBounds(0, 0, boxWidth, boxHeight);
        text.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0), 2));
        text.setBackground(new Color(153, 102, 0, 150));
        text.setForeground(Color.WHITE);
        text.setEditable(false);
        
        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
        StyleConstants.setSpaceAbove(attribs, 8);
        StyleConstants.setFontSize(attribs, 20);
        StyleConstants.setForeground(attribs, Color.WHITE);
        text.setParagraphAttributes(attribs, true);
        this.add(text);
    }

    public void setSceneName(String name) {
        text.setText(name);
    }
}
