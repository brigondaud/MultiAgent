package automata;

/**
 * Represents a cell evolving in a grid.
 * 
 * This model may have multiple states according to
 * its neighbourhood.
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
     * The current state of the cell.
     */
    protected State state;
    
    /**
     * Cell constructor {Grid}.
     * @param grid  The grid which contains the cell.
     * @param i     The x-position (height) of the cell.
     * @param j     The y-position (width) of the cell.
     * 
     * @see Grid
     * @see Cell#grid
     */
    public Cell(Grid grid, int i, int j) {
        this.grid = grid;
        this.i = i;
        this.j = j;
        
        this.state = null;
    }

    /**
     * State getter.
     * @return The current state of the cell.
     */
    public State getState() {
        return state;
    }
    
    /**
     * Assigns the state of the cell at its creation.
     * Cells can't be "stateless" objects. Each cell
     * should have a first state when being instanciated.
     * 
     * This init state may be either always the same one, or
     * decided with randomness.
     */
    abstract public void initState();
}
