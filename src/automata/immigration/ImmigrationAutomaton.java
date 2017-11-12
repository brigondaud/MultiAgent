package automata.immigration;

import java.util.Arrays;
import java.util.List;

import automata.Automaton;
import automata.Cell;
import automata.State;

/**
 * Represents a 2D automaton for Immigration Game: a Conway's Game of Life but
 * with n states.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class ImmigrationAutomaton extends Automaton {

    /**
     * The number of states in the immigration simulation.
     */
    private int statesNumber;

    /**
     * Immigration Automaton constructor {height, width, cellSize,
     * statesNumber}.
     *
     * @param height        The vertical number of cells
     * @param width         The horizontal number of cells
     * @param cellSize      The size of a cell in pixels
     * @param statesNumber  The number of possible states
     * @see Automaton#Automaton(int, int, int)
     */
    public ImmigrationAutomaton(int height, int width, int cellSize, int statesNumber) {
        super(height, width, cellSize);
        this.setStatesNumber(statesNumber);
    }

    /**
     * Immigration Automaton constructor {height, width}.
     *
     * @param height The vertical number of cells
     * @param width The horizontal number of cells
     * @param statesNumber The number n of future states
     * @see Automaton#Automaton(int, int)
     */
    public ImmigrationAutomaton(int height, int width, int statesNumber) {
        super(height, width);
        this.setStatesNumber(statesNumber);
    }

    /**
     * Setter for statesNumber
     *
     * @param statesNumber
     */
    public final void setStatesNumber(int statesNumber) {
        if (statesNumber <= 0) {
            throw new IllegalArgumentException("There must be at least one state");
        }

        this.statesNumber = statesNumber;
    }

    @Override
    protected List<State> possibleStates() {
        State futureStates[] = new State[statesNumber];

        for (int i = 0; i < futureStates.length; i++) {
            futureStates[i] = new State(i, i + "");
        }

        return Arrays.asList(futureStates);
    }

    @Override
    protected Cell getCellModel(int i, int j) {
        return new ImmigrationCell(this.grid, i, j, this.states);
    }
}
