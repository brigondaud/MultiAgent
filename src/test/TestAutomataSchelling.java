/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import automata.schelling.SchellingAutomaton;

/**
 *
 * @author Admin
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
