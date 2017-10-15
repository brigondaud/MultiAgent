package automata;

import gui.GUISimulator;
import gui.Simulable;
import java.awt.Color;

/**
 * Represents a 2D cellular automaton (CA).
 *
 * This model is designed to fit with most of cellular agent-based models.
 * It encapsulates among others a grid (variable size) and drawing methods.
 * 
 * @author Aurélien Pepin
 * @version 1.0
 */
abstract public class Automaton implements Simulable {
    
    /**
     * The GUI used by the automaton.
     * @see Automaton#simulate
     */
    protected GUISimulator gui;
    
    /**
     * The (n * m) circular grid.
     */
    protected Grid grid;
    
    /**
     * The graphic size of a cell in pixels.
     * Should be > 0. Default value: 20.
     */
    protected int cellSize;
    
    /**
     * The list of possible states for this automaton.
     */
    protected State[] states;
    
    /**
     * Automaton constructor {height, width, cellSize}.
     * @param height    The vertical number of cells
     * @param width     The horizontal number of cells
     * @param cellSize  The size of a cell in pixels
     */
    public Automaton(int height, int width, int cellSize) {
        this.grid = new Grid(height, width);
        this.setCellSize(cellSize);
        
        
    }
    
    /**
     * Automaton constructor {height, width}.
     * @param height    The vertical number of cells
     * @param width     The horizontal number of cells
     */
    public Automaton(int height, int width) {
        this(height, width, -1);
    }
    
    /**
     * Begins the simulation by creating the window.
     * Here, the GUI and the automaton are fully dependent.
     * 
     * The graphic simulation is only feasible if the automaton
     * was correctly created. All the information needed to draw
     * the grid and the cells stay inside the automaton.
     * 
     * @return The GUI created and carried by the automaton
     */
    public GUISimulator simulate() {
        int guiHeight = this.cellSize * this.grid.getHeight() + 5;
        int guiWidth = this.cellSize * this.grid.getWidth() + 5;
                
        // As the automaton carries its GUI, the user only needs to
        // create the automaton and then simulate it when he wants.
        this.gui = new GUISimulator(guiWidth, guiHeight, Color.WHITE);        
        this.gui.setSimulable(this);
        
        // Draw the grid (and the cells)
        this.grid.draw(gui, cellSize, false);
        
        return this.gui;
    }

    /**
     * Cell size setter.
     * 
     * @see Automaton#cellSize
     * @param cellSize 
     */
    private void setCellSize(int cellSize) {
        if (cellSize > 0)
            this.cellSize = cellSize;
        else
            this.cellSize = 20;
    }
    
    @Override
    public void next() {
        ;
    }

    @Override
    public void restart() {
        ;
    }
    
    /**
     * Returns possible states for cells of the automaton.
     * For example, this function would return an array
     *   
     *   [ new State("Alive"), new State("Dead") ]
     * 
     * in Conway's game of life. The states may depend on
     * parameters according to the automaton, so this
     * method will be called in child classes only.
     * 
     * @return An array of possible states
     */
    abstract protected State[] possibleStates();
    
    /**
     * Returns the associatd cell model with the automaton.
     * This is a case of creational factory method pattern (see WP).
     * 
     * Each automaton child should override this method and return the
     * class that will represent its cells. For example, the method
     * ConwayAutomaton.getCellModel would return "new ConwayCell({...});"
     * 
     * The whole grid will be filled with cells returned by getCellModel.
     * @param i The x-position of the new cell
     * @param j The y-position of the new cell
     * @return A cell in this automaton
     */
    abstract protected Cell getCellModel(int i, int j);
}
