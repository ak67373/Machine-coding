package com.interview.designpatterns;

/**
 * State Pattern
 * Allows an object to alter its behavior when its internal state changes
 */
public class StatePattern {
    
    public static void main(String[] args) {
        System.out.println("=== STATE PATTERN ===\n");
        
        Context context = new Context();
        
        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());
        
        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());
    }
}

interface State {
    void doAction(Context context);
}

class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start State";
    }
}

class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Stop State";
    }
}

class Context {
    private State state;

    public Context() {
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}

