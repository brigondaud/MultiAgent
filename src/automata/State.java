package automata;

import java.awt.Color;
import java.util.Objects;
import java.util.Random;

/**
 * Represents a possible state of a cell.
 *
 * This model is represented by a name (optional) and a color (optional). For
 * example, the two states for the Conway automaton could be:
 *
 * State("Alive", Color.blue); State("Dead", Color.white);
 *
 * If not specified, the default name value is "". If not specified, the default
 * color is a random one.
 *
 * @see Automaton
 * @see Cell
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class State {

    /**
     * The id of the state.
     * In a set of states for an automaton, the state's id
     * should be unique. It greatly make the transition function easier.
     */
    private int id;

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
     * State constructor {id, name, color}.
     *
     * @param id ID of the state
     * @param name Name of the state
     * @param color Color of the state
     */
    public State(int id, String name, Color color) {
        this.setID(id);
        this.setName(name);
        this.setColor(color);
    }

    /**
     * State constructor {id}.
     *
     * @param id ID of the state
     */
    public State(int id) {
        this(id, null, null);
    }

    /**
     * State constructor {id, name}.
     *
     * @param id ID of the state
     * @param name Name of the state
     */
    public State(int id, String name) {
        this(id, name, null);
    }

    /**
     * State constructor {id, color}.
     *
     * @param id ID of the state
     * @param color Color of the state
     */
    public State(int id, Color color) {
        this(id, null, color);
    }

    /**
     * ID setter. Compulsory.
     *
     * @param id ID of the state.
     */
    private void setID(int id) {
        this.id = id;
    }

    /**
     * Name setter. If null, the name will be set to the default value "".
     *
     * @param name Name of the state.
     */
    public final void setName(String name) {
        this.name = (name == null) ? "" : name;
    }

    /**
     * Color setter. If null, the color will be defined with random values.
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
     * ID getter.
     *
     * @return The id of the state
     * @see State#id
     */
    public int getID() {
        return this.id;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.name);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final State other = (State) obj;
        if (this.id != other.id) {
            return false;
        }

        return Objects.equals(this.name, other.name);
    }
}
