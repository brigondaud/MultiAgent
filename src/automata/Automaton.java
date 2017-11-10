package automata;

import gui.GUISimulator;
import gui.Simulable;
import events.EventManager;
import events.AutomatonEvent;
import java.awt.Color;
import java.util.List;
import systems.System;

/**
 * Represents a 2D cellular automaton (CA).
 *
 * This model is designed to fit with most of cellular agent-based models. It
 * encapsulates among others a grid (variable size) and drawing methods.
 *
 * @author Aurélien Pepin
 * @version 1.0
 */
abstract public class Automaton extends System {

    /**
     * The (n * m) circular grid.
     */
    protected Grid grid;

    /**
     * The graphic size of a cell in pixels. Should be > 0. Default value: 20.
     */
    protected int cellSize;

    /**
     * The list of possible states for this automaton.
     */
    protected List<State> states;

    /**
     * Automaton constructor {height, width, cellSize}.
     *
     * @param height The vertical number of cells
     * @param width The horizontal number of cells
     * @param cellSize The size of a cell in pixels
     */
    public Automaton(int height, int width, int cellSize) {
        super();
        this.grid = new Grid(height, width, this);
        this.setCellSize(cellSize);
    }

    /**
     * Automaton constructor {height, width}.
     *
     * @param height The vertical number of cells
     * @param width The horizontal number of cells
     */
    public Automaton(int height, int width) {
        this(height, width, -1);
    }

    /**
     * Initializes components of the automaton. Possible states, all cells
     */
    private void initAutomatonComponents() {
        // The states, defined by child classes
        this.states = possibleStates();
        
        // The cells inside the grid
        this.grid.initialize();
        
        // The initial event of the cellular automaton.
        this.events.addEvent(new AutomatonEvent(1, this));
    }

    /**
     * Begins the simulation by creating the window. Here, the GUI and the
     * automaton are fully dependent.
     *
     * The graphic simulation is only feasible if the automaton was correctly
     * created. All the information needed to draw the grid and the cells stay
     * inside the automaton. That's why the first lines of this function force
     * subclasses to override initialization methods.
     *
     * See "Template method pattern".
     *
     * @return The GUI created and carried by the automaton
     */
    @Override
    public final GUISimulator simulate() {
        // Let's build the automaton before simulation.
        // Example of template method pattern.
        this.initAutomatonComponents();

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
        if (cellSize > 0) {
            this.cellSize = cellSize;
        } else {
            this.cellSize = 20;
        }
    }
    
    /**
     * Execution of the automaton event.
     */
    @Override
    public void executeEvent() {
    	grid.computeNextGeneration();
        grid.draw(gui, cellSize, false);
    }

    @Override
    public void next() {
        this.events.next();
    }

    @Override
    public void restart() {
        this.grid.restart();
        this.grid.draw(gui, cellSize, false);
    }

    /**
     * Returns possible states for cells of the automaton. For example, this
     * function would return a list :
     *
     * [ new State("Alive"), new State("Dead") ]
     *
     * in Conway's game of life. The states may depend on parameters according
     * to the automaton, so this method will be called in child classes only.
     *
     * Possible states are shared by all cells. So they should be created in the
     * automaton and passed to the cells then.
     *
     * @return The list of possible states
     */
    abstract protected List<State> possibleStates();

    /**
     * Returns the associated cell model with the automaton. This is a case of
     * creational factory method pattern (see WP).
     *
     * Each automaton child should override this method and return the class
     * that will represent its cells. For example, the method
     * ConwayAutomaton.getCellModel would return "new ConwayCell({...});"
     *
     * The whole grid will be filled with cells returned by getCellModel.
     *
     * @param i The x-position of the new cell
     * @param j The y-position of the new cell
     * @return A cell in this automaton
     */
    abstract protected Cell getCellModel(int i, int j);
}
