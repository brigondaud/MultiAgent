/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import automata.immigration.ImmigrationAutomaton;

/**
 *
 * @author Baptiste Rigondaud, Aurélien Pépin, Valentin Sicard
 */
public class TestImmigrationGame {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		ImmigrationAutomaton immigrationGame = new ImmigrationAutomaton(50, 50, 10, 5);
		immigrationGame.simulate();
	}

}
