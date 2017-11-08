/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata.schelling;

import automata.Automaton;
import automata.Cell;
import automata.State;
import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Admin
 */
public class SchellingAutomaton extends Automaton {
    
    /**
     * Number of colors.
     * Should be > 0.
     */
    private final int colorsNumber;
    
    /**
     * Thresold for a cell move.
     * Should be > 0.
     */
    private final int thresold;
    
    /**
     * Set to store vacant cells.
     */
    private final SchellingSet<SchellingCell> vacants;
    
    /**
     * Schelling Automaton constructor {height, width, cellSize, colorsNumber, thresold}.
     * 
     * @param height
     * @param width
     * @param cellSize
     * @param colorsNumber
     * @param thresold 
     */    
    public SchellingAutomaton(int height, int width, int cellSize, int colorsNumber, int thresold) {
        super(height, width, cellSize);
        
        /* Set additional fields for this automaton. */
        if (colorsNumber <= 0 || thresold <= 0)
            throw new IllegalArgumentException("Bad settings for Schelling.");
        
        this.colorsNumber = colorsNumber;
        this.thresold = thresold;
        
        this.vacants = new SchellingSet<>();
    }
    

    @Override
    protected List<State> possibleStates() {
        State futureStates[] = new State[colorsNumber + 2];
        futureStates[0] = new State(0, "EMPTY", Color.WHITE);
        
        for (int i = 1; i <= colorsNumber; ++i) {
            futureStates[i] = new State(i, i + "");
        }
        
        futureStates[colorsNumber + 1] = new State(colorsNumber + 1, "EVASION");
        
        /* No need to create a mutable ArrayList. */
        return Arrays.asList(futureStates);
    }

    @Override
    protected Cell getCellModel(int i, int j) {
        return new SchellingCell(grid, i, j, states, vacants, thresold);
    }

    @Override
    public void restart() {
        super.restart();
        
        this.vacants.removeAll();
        SchellingCell cell;
        
        for (int i = 0; i < this.grid.getHeight(); ++i) {
            for (int j = 0; j < this.grid.getWidth(); ++j) {
                cell = (SchellingCell) this.grid.get(i, j);
                
                if (cell.getState() == states.get(0))
                    this.vacants.add(cell);
            }
        }
    }
}
