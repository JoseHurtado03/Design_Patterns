package memento;

/**
 *
 * @author hvjos
 */
public class Originator {
    private int currentValue;

    public Originator(int currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * @return the currentValue
     */
    public int getCurrentValue() {
        return currentValue;
    }

    /**
     * @param currentValue the currentValue to set
     */
    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }
}
