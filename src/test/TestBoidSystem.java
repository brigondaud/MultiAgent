package test;

import boids.BoidSystem;

/**
 *
 * @author Aurélien Pepin
 * @version 1.0
 */
public class TestBoidSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BoidSystem bs = new BoidSystem(300, 300);
        bs.addGroupOf(10);
        bs.addGroupOf(15);
        
        bs.simulate();
    }
}
