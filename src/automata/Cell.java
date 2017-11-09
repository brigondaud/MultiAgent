package automata;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a cell evolving in a grid.
 *
 * This model may have multiple states according to its neighbourhood.
 *
 * @see Grid
 *
 * @author Aurélien Pepin
 * @version 1.0
 */
abstract public class Cell {

    /**
     * The grid in which the cell evolves.
     */
    protected Grid grid;

    /**
     * The x-position (height) of the cell.
     */
    protected int i;

    /**
     * The y-position (width) of the cell.
     */
    protected int j;

    /**
     * The list of possible states for the cell. With this reference, we can
     * build a transition function.
     */
    protected List<State> states;

    /**
     * The current state of the cell.
     */
    protected State state;

    /**
     * (Back-up). The first state of the cell.
     */
    protected State firstState;

    /**
     * The next state of the cell. This attribute is used because all the cells
     * have to check their next state (via neighbours) before one can be
     * changed.
     */
    protected State saveState;

    /**
     * The eight neighbours of the cell. To avoid searching neighbours of the
     * cell at each generation, this attribute stores them.
     */
    protected List<Cell> neighbours;

    /**
     * Cell constructor {Grid}.
     *
     * @param grid The grid which contains the cell.
     * @param i The x-position (height) of the cell.
     * @param j The y-position (width) of the cell.
     * @param states The list of possible states for the cell.
     *
     * @see Grid
     * @see Cell#grid
     */
    public Cell(Grid grid, int i, int j, List<State> states) {
        this.grid = grid;
        this.i = i;
        this.j = j;

        this.states = states;
    }

    /**
     * Gives birth to the cell. Updates its first state and saves it.
     *
     * @see Cell#initState()
     */
    public final void emerge() {
        this.state = this.initState();  // Compulsory
        this.firstState = this.state;

        this.neighbours = null;
    }

    /**
     * Restarts the cell. As the only thing that evolves in the cell is its
     * status, this method only set the current state to the firstState.
     */
    public final void restart() {
        this.state = this.firstState;
    }

    /**
     * Saves the next state of the cell. First, all cells check their next state
     * and save it. Then, all cells adopt their new states.
     *
     * @see Cell#saveState
     */
    public final void saveNextState() {
        this.saveState = this.nextState();
    }

    /**
     * Changes the state of the cell, according to "saveState". Once all cells
     * know their future state, they can update.
     *
     * @see Cell#saveState
     */
    public void changeState() {
        this.state = this.saveState;
    }

    /**
     * Finds the eight neighbours of the cell. As long as the grid is circular,
     * a cell will always have eight neighbours.
     */
    public void findNeighbours() {
        ArrayList<Cell> cells = new ArrayList<>();

        for (int v = -1; v <= 1; ++v) {
            for (int h = -1; h <= 1; ++h) {
                if (v != 0 || h != 0) {
                    cells.add(this.grid.get(
                        Math.floorMod(i + v, this.grid.getHeight()),
                        Math.floorMod(j + h, this.grid.getWidth())
                    ));
                }
            }
        }

        this.neighbours = cells;
    }

    /**
     * Counts the number of neighbouring cells in the state "state". If the
     * state is null, throws an IllegalArgumentException.
     *
     * @param state The state that the neighbourhood should have.
     * @return The number of neighbours in the state "state"
     */
    public int countNeighbours(State state) {
        if (state == null) {
            throw new IllegalArgumentException("Can't count an absent state");
        }

        int numberOfNeighbours = 0;

        for (Cell n : this.neighbours) {
            if (state.equals(n.getState())) {
                numberOfNeighbours++;
            }
        }

        return numberOfNeighbours;
    }

    /**
     * State getter.
     *
     * @return The current state of the cell.
     */
    public State getState() {
        return state;
    }

    /**
     * State setter.
     *
     * @param state The state to assign to the cell.
     */
    public void setState(State state) {
        this.state = state;
    }
    
    /**
     * Save state setter.
     * 
     * @param saveState The save state to assign to the cell.
     */
    public void setSaveState(State saveState) {
        this.saveState = saveState;
    }

    /**
     * Assigns the state of the cell at its creation. Cells can't be "stateless"
     * objects. Each cell should have a first state when being instanciated.
     *
     * This init state may be either always the same one, or decided with
     * randomness.
     *
     * @return The first state of the cell at the beginning.
     */
    abstract protected State initState();

    /**
     * Assigns the next state of the cell. Cells evolve due to their
     * neighbourhod. Each cell should always have a state.
     *
     * This method is not intended to assign the future state. It's the
     * "transition function" of the automaton.
     *
     * @return The next state of the cell depending on its current state.
     */
    abstract protected State nextState();
}
