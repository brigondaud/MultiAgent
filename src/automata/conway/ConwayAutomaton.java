package automata.conway;

import automata.Automaton;
import automata.State;
import java.awt.Color;

/**
 * Represents a 2D automaton for Conway's Game of Life.
 * This class extends the abstract automaton model.
 * 
 * Their are 2 possible states :
 *   - State("Alive")
 *   - State("Dead")
 * 
 * @author Aurélien Pepin
 * @version 1.0
 */
public class ConwayAutomaton extends Automaton {

    /**
     * Conway Automaton constructor {height, width, cellSize}.
     * 
     * @param height    The vertical number of cells
     * @param width     The horizontal number of cells
     * @param cellSize  The size of a cell in pixels
     * @see Automaton#Automaton(int, int, int)
     */
    public ConwayAutomaton(int height, int width, int cellSize) {
        super(height, width, cellSize);
    }

    /**
     * Conway Automaton constructor {height, width}.
     * 
     * @param height    The vertical number of cells
     * @param width     The horizontal number of cells
     * @see Automaton#Automaton(int, int) 
     */
    public ConwayAutomaton(int height, int width) {
        super(height, width);
    }

    @Override
    protected State[] possibleStates() {
        return new State[] {
            new State("Alive"),
            new State("Dead", Color.WHITE)
        };
    }    
}
