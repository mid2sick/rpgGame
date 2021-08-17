package src.fsm;

import javax.swing.Icon;

public abstract class State {
    protected int remaining;
    protected final int framesToChange;
    protected final int totalPictures;
    protected FinalStateMachine fsm;
    protected int frameID;

    public State(FinalStateMachine fsm, int framesToChange, int totalPictures) {
        this.fsm = fsm;
        this.framesToChange = framesToChange;
        this.totalPictures = totalPictures;
    }

    public abstract void reset();
    public abstract void update();
    public abstract Icon getImageIcon();
}
