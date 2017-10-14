package automata;

/**
 * Represents a (n * m) circular grid.
 * 
 * This model contains cells depicted with their position.
 * The grid is circular, meaning that the (n, m) cell can
 * interact with the (1, 1) cell.
 * 
 * The size of the grid is fixed at the instanciation.
 * 
 * @see Cell
 * 
 * @author Aurélien Pepin
 * @version 1.0
 */
public class Grid {
    
    /**
     * The height of the grid (n).
     * Should be > 0.
     */
    private int height;
    
    /**
     * The width of the grid (m).
     * Should be > 0.
     */
    private int width;
    
    /**
     * The 2D array of cells.
     */
    private final Cell[][] cells;
    
    
    /**
     * Grid constructor {height, width}. 
     * @param height
     * @param width 
     */
    public Grid(int height, int width) {
        this.setHeight(height);
        this.setWidth(width);
        
        // Default content of array elements is <null>.
        this.cells = new Cell[this.height][this.width];
    }

    /**
     * Height setter.
     * 
     * @throws IllegalArgumentException
     * @param height 
     */
    private void setHeight(int height) {
        if (height < 1)
            throw new IllegalArgumentException("Bad size for height");
        
        this.height = height;
    }

    /**
     * Width setter.
     * 
     * @throws IllegalArgumentException
     * @param width 
     */
    private void setWidth(int width) {
        if (width < 1)
            throw new IllegalArgumentException("Bad size for width");
        
        this.width = width;
    }
    
    /**
     * Height getter.
     */
    public int getHeight() {
        return this.height;
    }
    
    /**
     * Width getter.
     */
    public int getWidth() {
        return this.width;
    }
}
