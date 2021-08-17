package src.fsm;

import src.blocks.MovingUnit;

public class FinalStateMachine {
    public MovingUnit mvUnit;
    private State currentState;
    private State idle = new Idle(this, 6, 10);
    private State walk = new Walk(this, 4, 10);

    public FinalStateMachine(MovingUnit mvUnit) {
        this.mvUnit = mvUnit;
    }

    public void update() {
        if(mvUnit.getState() == MovingUnit.State.IDLE) {
            currentState = idle;
            walk.reset();
        } else if(mvUnit.getState() == MovingUnit.State.WALK) {
            currentState = walk;
            idle.update();
        }
        currentState.update();
        mvUnit.setIcon(currentState.getImageIcon());
    }
}
