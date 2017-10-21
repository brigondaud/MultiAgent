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
		if (states.size() == 1)
			return states.get(0);
		int randomIdState = ThreadLocalRandom.current().nextInt(0, states.size()-1);
		return states.get(randomIdState);
	}

	@Override
	protected State nextState() {
		int neighbourCounter = 0;
		// If there's only one state: return the current state
		if (states.size() == 1)
			return this.state;
		for (Cell neighbour : this.neighbours) {
			if (neighbour.getState().getID() == (this.getState().getID() + 1)%(states.size()-1))
				neighbourCounter++;
		}
		if (neighbourCounter >= 3)
			return states.get((this.getState().getID() + 1)%(states.size()-1));
		else
			return this.state;
	}

}
