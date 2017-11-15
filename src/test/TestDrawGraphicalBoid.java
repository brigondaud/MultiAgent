package test;

import java.awt.Color;

import boids.utils.GraphicalBoid;
import boids.utils.Vector2D;
import gui.GUISimulator;

/**
 * A class to test the drawing of the boids.
 *
 * @author Baptiste Rigondaud, Aurélien Pépin, Valentin Sicard
 */
public class TestDrawGraphicalBoid {

    /**
     * Draws some boids.
     *
     * @param args
     */
    public static void main(String[] args) {
        GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
        GraphicalBoid b1 = new GraphicalBoid(new Vector2D(30, 30), new Vector2D(0, 1), Color.decode("#B44339"),
            Color.decode("#4D8FAC"), 10);
        GraphicalBoid b2 = new GraphicalBoid(new Vector2D(50, 50), new Vector2D(1, 0), Color.decode("#B5A300"),
            Color.decode("#4D8FAC"), 20);
        GraphicalBoid b3 = new GraphicalBoid(new Vector2D(150, 150), new Vector2D(0.45, -3.70), Color.decode("#00A3C4"),
            Color.decode("#4D8FAC"), 40);

        b1.rotateTo(new Vector2D(-5, 9));
        b1.translate(100, 200);

        gui.addGraphicalElement(b1);
        gui.addGraphicalElement(b2);
        gui.addGraphicalElement(b3);
    }

}
