package automata;

import java.awt.Color;
import java.util.Random;

/**
 * Represents a possible state of a cell.
 * 
 * This model is represented by a name (optional)
 * and a color (optional). For example, the two states
 * for the Conway automaton could be:
 * 
 *      State("Alive", Color.blue);
 *      State("Dead", Color.white);
 * 
 * If not specified, the default name value is "".
 * If not specified, the default color is a random one.
 * 
 * @see Automaton
 * @see Cell
 * 
 * @author Aurélien Pepin
 * @version 1.0
 */
public class State {
    
    /**
     * The (optional) name of the state.
     * Used for printing. Default value: "".
     */
    private String name;
    
    /**
     * The (optional) color of the state.
     * Used for graphics. Default value: a random color.
     */
    private Color color;
    
    /**
     * State constructor {name, color}.
     * @param name  Name of the state
     * @param color Color of the state
     */
    public State(String name, Color color) {
        this.setName(name);
        this.setColor(color);
    }
    
    /**
     * State constructor (empty).
     */
    public State() {
        this(null, null);
    }
    
    /**
     * State constructor {name}.
     * @param name  Name of the state
     */
    public State(String name) {
        this(name, null);
    }
    
    /**
     * State constructor {color}.
     * @param color Color of the state
     */
    public State(Color color) {
        this(null, color);
    }

    /**
     * Name setter.
     * If null, the name will be set to the default value "".
     * 
     * @param name Name of the state.
     */
    public final void setName(String name) {
        this.name = (name == null) ? "" : name;
    }

    /**
     * Color setter.
     * If null, the color will be defined with random values.
     * 
     * @param color Color of the state.
     */
    public final void setColor(Color color) {        
        if (color == null) {
            Random rand = new Random();
            
            // Compute three random values for the components
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            
            // Create the color and make it shiny 8-)
            this.color = new Color(r, g, b);
            this.color.brighter();
        } else {
            this.color = color;
        }
    }
    
    /**
     * Name getter.
     * 
     * @return The name of the state
     * @see State#name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Color getter.
     * 
     * @return The color of the state
     * @see State#color
     */
    public Color getColor() {
        return this.color;
    }
}

