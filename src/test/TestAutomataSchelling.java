package test;

import automata.schelling.SchellingAutomaton;

/**
 *
 * @author Baptiste Rigondaud, Aurélien Pépin, Valentin Sicard
 */
public class TestAutomataSchelling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SchellingAutomaton schelling = new SchellingAutomaton(35, 80, 10, 2, 2);
        schelling.simulate();
    }

}
