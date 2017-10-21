package automata.conway;

import automata.Cell;
import automata.Grid;
import automata.State;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents of a cell for Conway's Game of Life.
 * This class extends the abstract cell model.
 * 
 * @author Aurélien Pepin, Baptiste Rigondaud, Valentin Sicard
 * @version 1.0
 */
public class ConwayCell extends Cell {

    public ConwayCell(Grid grid, int i, int j, List<State> states) {
        super(grid, i, j, states);
    }

    @Override
    protected final State initState() {
        int randomValue = ThreadLocalRandom.current().nextInt(0, 11);
        return (randomValue < 8) ? states.get(1) : states.get(0);
    }

    @Override
    protected State nextState() {
        State alive = states.get(0);
        
        // For the two other automata, you'll probably work with ids.
        switch (this.state.getName()) {
            case "Alive":
                int numberOfAlive = this.countNeighbours(alive);
                
                if (numberOfAlive == 2 || numberOfAlive == 3)
                    return states.get(0);
                else
                    return states.get(1);
            case "Dead":
                if (this.countNeighbours(alive) == 3)
                    return states.get(0);
                else
                    return states.get(1);
            default:
                throw new RuntimeException("Cell without any state!");
        }
    }
}
