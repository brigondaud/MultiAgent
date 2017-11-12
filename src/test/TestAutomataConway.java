package test;

import automata.conway.ConwayAutomaton;

/**
 *
 * @author Team 22 in Teide
 */
public class TestAutomataConway {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ConwayAutomaton conway = new ConwayAutomaton(35, 80, 10);
        conway.simulate();
    }

}
