package memento;

/**
 *
 * @author hvjos
 */
public class Memento {
    private int state;

    public Memento(int state) {
        this.state = state;
    }

    /**
     * @return the state
     */
    public int getState() {
        return state;
    }    
}
