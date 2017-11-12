package test;

import automata.immigration.ImmigrationAutomaton;

/**
 *
 * @author Team 22 in Teide
 */
public class TestAutomataImmigration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ImmigrationAutomaton immigrationGame = new ImmigrationAutomaton(50, 50, 10, 5);
        immigrationGame.simulate();
    }

}
