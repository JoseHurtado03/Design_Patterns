package memento;

public class CareTaker {
    private Originator currentValue;
    private Memento originalState;

    public CareTaker(Originator currentValue, Memento originalState) {
        this.currentValue = currentValue;
        this.originalState = originalState;
    }
    /**
     * @return the currentValue
     */
    public Originator getCurrentValue() {
        return currentValue;
    }

    /**
     * @param currentValue the currentValue to set
     */
    public void setCurrentValue(Originator currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * @return the originalState
     */
    public Memento getOriginalState() {
        return originalState;
    }

    public void undo(){
        int value = this.getOriginalState().getState(); 
        this.currentValue.setCurrentValue(value);
    }
    
}
