package test;

import automata.conway.ConwayAutomaton;

/**
 *
 * @author Baptiste Rigondaud, Aurélien Pépin, Valentin Sicard
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
