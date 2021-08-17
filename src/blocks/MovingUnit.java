package src.blocks;

import src.fsm.*;
import src.Direction;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.Set;

import java.awt.Point;


public class MovingUnit extends Unit{
    protected State state;
    protected Direction face;
    public FinalStateMachine fsm;

    // by using direction set, it is able to go in 2 directions simultaneously
    protected final Set<Direction> directions = new CopyOnWriteArraySet<>();

    public enum State {
        WALK, IDLE
    }
    public MovingUnit(Point location, String name, int width, int height) {
        super(location, name, width, height);
        state = State.IDLE;
        fsm = new FinalStateMachine(this);
        face = Direction.RIGHT;
    }

    public State getState() {
        return state;
    }

    public void move(int len) {

    }

    public Direction getFaceAt() {
        return face;
    }

    public void setFaceAt(Direction d) {
        if(d == Direction.LEFT || d == Direction.RIGHT) face = d;
    }
}
