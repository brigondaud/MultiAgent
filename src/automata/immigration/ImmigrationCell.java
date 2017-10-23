package automata.immigration;

import java.util.List;
import automata.Cell;
import automata.State;
import automata.Grid;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents of a cell for Immigration Game. This class extends the abstract
 * cell model.
 *
 * @author Aurélien Pepin, Baptiste Rigondaud, Valentin Sicard
 * @version 1.0
 */
public class ImmigrationCell extends Cell {

    public ImmigrationCell(Grid grid, int i, int j, List<State> states) {
        super(grid, i, j, states);
    }

    @Override
    protected final State initState() {
        if (states.size() == 1) {
            return states.get(0);
        }
        
        int randomIdState = ThreadLocalRandom.current().nextInt(0, states.size());
        return states.get(randomIdState);
    }

    @Override
    protected State nextState() {        
        // If there's only one state: return the current state
        if (states.size() == 1)
            return this.state;
        
        int followingID = (this.getState().getID() + 1) % states.size();
        State followingState = states.get(followingID);
        
        int neighbourCounter = this.countNeighbours(followingState);
        return (neighbourCounter >= 3) ? followingState : this.state;
        
//        for (Cell neighbour : this.neighbours) {
//            if (neighbour.getState().getID() == (this.getState().getID() + 1) % states.size()) {
//                neighbourCounter++;
//            }
//        }
//        
//        if (neighbourCounter >= 3) {
//            return states.get((this.getState().getID() + 1) % states.size());
//        } else {
//            return this.state;
//        }
    }
}
