/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata.schelling;

import automata.Cell;
import automata.Grid;
import automata.State;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Admin
 */
public class SchellingCell extends Cell implements Comparable {

    /**
     * Set of vacants cells.
     * Give a reference to the cell so the trade is possible.
     */
    private final SchellingSet<SchellingCell> vacants;
    
    /**
     * Thresold to trigger a cell move.
     * Give a reference to the cell so it can know if it has to move.
     */
    private final int thresold;
    
    
    public SchellingCell(Grid grid, int i, int j, List<State> states,
                         SchellingSet<SchellingCell> vacants, int thresold) {
        super(grid, i, j, states);
        
        this.vacants = vacants;
        this.thresold = thresold;
    }

    
    @Override
    protected State initState() {
        int isEmpty = ThreadLocalRandom.current().nextInt(0, 100);
        
        // There should be enough vacant cells (cf. Schelling p. 12)
        if (isEmpty < 30) {
            this.vacants.add(this);
            return states.get(0);
        }
        
        int whatColor = ThreadLocalRandom.current().nextInt(1, states.size() - 1);
        return states.get(whatColor);
    }

    @Override
    protected State nextState() {
        if (this.state.equals(states.get(0))) {
            if (vacants.contains(this)) {
                return this.state;
            } else {
                // System.err.println("SS : " + this.saveState);
                return this.saveState;
            }
        }
        
        // If the cell isn't empty, check its neighbours.
        int strangers = 8 - this.countNeighbours(states.get(0)) // No neighbour
                          - this.countNeighbours(state);        // Same color
        
        // The cell has to move.
        if (strangers > thresold) {
            SchellingCell newFamily = vacants.removeRandom();
            
            if (newFamily != null) {
                newFamily.setSaveState(state);
                return states.get(states.size() - 1);
            }
        }
        
        return state;
    }

    
    /**
     * TODO. Commentaires ici.
     */
    @Override
    public void changeState() {
        if (this.saveState.equals(states.get(states.size() - 1))) {
            this.setSaveState(states.get(0));
            
            this.vacants.add(this);
        }
        
        super.changeState();
    }

    @Override
    public int compareTo(Object t) {
        if (this == t)
            return 0;
        
        final SchellingCell other = (SchellingCell) t;
        
        // Compare cells with coordinates
        if (this.i < other.i)
            return -1;
        else if (this.i > other.i)
            return 1;
        else
            return (this.j < other.j) ? -1 : 1;
    }
}
