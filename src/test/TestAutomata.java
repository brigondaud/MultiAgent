/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import automata.conway.ConwayAutomaton;
import gui.GUISimulator;
import java.awt.Color;

/**
 *
 * @author Admin
 */
public class TestAutomata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ConwayAutomaton conway = new ConwayAutomaton(10, 10, 5);
        conway.simulate();
    }
    
}
