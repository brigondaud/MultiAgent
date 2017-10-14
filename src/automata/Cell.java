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
     * The current state of the cell.
     */
    protected State state;
    
    /**
     * Cell constructor {Grid}.
     * 
     * @param grid The grid which contains the cell.
     * @see Grid
     * @see Cell#grid
     */
    public Cell(Grid grid) {
        this.grid = grid;
        this.state = null;
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
