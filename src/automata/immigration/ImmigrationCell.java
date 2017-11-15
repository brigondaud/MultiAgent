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
 * @author Baptiste Rigondaud, Aurélien Pépin, Valentin Sicard
 * @version 1.0
 */
public class ImmigrationCell extends Cell {

    /**
     * Constructor of the cell {grid, i, j, states}.
     *
     * @param grid The grid in which the cell evolves.
     * @param i The i-index of the cell.
     * @param j The j-index of the cell.
     * @param states A reference of the possible states.
     */
    public ImmigrationCell(Grid grid, int i, int j, List<State> states) {
        super(grid, i, j, states);
    }

    /**
     * Assign a state to a cell at its creation. Here the state assigned is
     * chosen randomly in the possible states.
     */
    @Override
    protected final State initState() {
        if (states.size() == 1) {
            return states.get(0);
        }

        int randomIdState = ThreadLocalRandom.current().nextInt(0, states.size());
        return states.get(randomIdState);
    }

    /**
     * Assign the next state of the cell. The next state is k+1 if there are at
     * least more that 3 neighbours in the next state.
     */
    @Override
    protected State nextState() {
        // If there's only one state: return the current state
        if (states.size() == 1) {
            return this.state;
        }

        int followingID = (this.getState().getID() + 1) % states.size();
        State followingState = states.get(followingID);

        int neighbourCounter = this.countNeighbours(followingState);
        return (neighbourCounter >= 3) ? followingState : this.state;
    }
}
