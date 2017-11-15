package test;

import automata.immigration.ImmigrationAutomaton;

/**
 *
 * @author Baptiste Rigondaud, Aurélien Pépin, Valentin Sicard
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
