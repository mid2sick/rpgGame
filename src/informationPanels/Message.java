package src.informationPanels;

import src.blocks.Unit;

public class Message {
    public String text;
    public Unit unit;
    public Message(Unit unit, String text) {
        this.unit = unit;
        this.text = text;
    }
}
