package src.fsm;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import src.Direction;

public class Walk extends State{
    public Walk(FinalStateMachine fsm, int framesToChange, int totalPictures){
        super(fsm, framesToChange, totalPictures);
    }

    @Override
    public void reset() {
        remaining = -1; // means not its time
    }

    @Override
    public void update() {
        if(remaining == -1) { // its time to starts to work!
            remaining = framesToChange;
            frameID = 0;
        } else { // it is already working
            remaining --;
            if(remaining == 0) {
                frameID = (frameID + 1) % totalPictures;
                remaining = framesToChange;
            }
        }
    }

    @Override
    public Icon getImageIcon() {
        String direction;
        String pathname;
        if(fsm.mvUnit.getFaceAt() == Direction.LEFT) direction = "left";
        else direction = "right";
        pathname = "walk/" + direction + frameID + ".png";
        return new ImageIcon(getClass().getClassLoader().getResource(pathname));
    }
}
