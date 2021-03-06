package boids;

import events.BoidEvent;
import gui.GUISimulator;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import systems.AbstractSystem;

/**
 * Represents a multiagent system where agents are boids.
 *
 * @author Baptiste Rigondaud, Aurélien Pépin, Valentin Sicard
 * @version 1.0
 */
public class BoidSystem extends AbstractSystem {

    /**
     * The flocks (groups) of boids. Each flock may have its own rules.
     */
    private final List<BoidGroup> flocks;

    /**
     * The width of the window, in pixels. Should be > 0.
     */
    private int width;

    /**
     * The height of the window, in pixels. Should be > 0.
     */
    private int height;

    /**
     * Constructor.
     *
     * @param width The width of the window, in pixels.
     * @param height The height of the window, in pixels.
     */
    public BoidSystem(int width, int height) {
        super();

        this.flocks = new ArrayList<>();
        this.setWidth(width);
        this.setHeight(height);
    }

    @Override
    public GUISimulator simulate() {
        this.gui = new GUISimulator(this.width, this.height, Color.WHITE);
        this.gui.setSimulable(this);
        this.registerIcons();

        return this.gui;
    }

    /**
     * Add a new group inside the boids system.
     *
     * @param numberOfBoids The number of boids for this group.
     * @param delay
     * @return The newly created group of boids.
     */
    public BoidGroup addGroupOf(int numberOfBoids, int delay) {
        if (numberOfBoids < 1) {
            throw new IllegalArgumentException("A group without boids?!");
        }

        BoidGroup theGroup = new BoidGroup(numberOfBoids, width, height, delay);
        flocks.add(theGroup);

        this.events.addEvent(new BoidEvent(1, this, theGroup));
        return theGroup;
    }

    @Override
    public void next() {
        this.events.next();
    }

    @Override
    public void restart() {
        this.events.restart();

        for (BoidGroup flock : flocks) {
            flock.restart();
            this.events.addEvent(new BoidEvent(1, this, flock));
        }

        this.gui.reset();
        this.registerIcons();
    }

    /**
     * Width setter.
     *
     * @throws IllegalArgumentException
     * @param width
     */
    private void setWidth(int width) {
        if (width < 1) {
            throw new IllegalArgumentException("Bad size for width");
        }

        this.width = width;
    }

    /**
     * Height setter.
     *
     * @throws IllegalArgumentException
     * @param height
     */
    private void setHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("Bad size for height");
        }

        this.height = height;
    }

    /**
     * Add icons to the GUI.
     */
    private void registerIcons() {
        for (BoidGroup bg : flocks) {
            for (Boid b : bg.getBoids()) {
                this.gui.addGraphicalElement(b.getIcon());
            }
        }
    }
}
