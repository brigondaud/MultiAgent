package systems;

import events.EventManager;
import gui.GUISimulator;
import gui.Simulable;

/**
 * Represents the system in a multiagent system environment.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
abstract public class AbstractSystem implements Simulable {

    /**
     * The GUI used by the system.
     *
     * @see System#simulate
     */
    protected GUISimulator gui;

    /**
     * The event manager for the system.
     */
    protected EventManager events;

    /**
     * Constructor.
     */
    public AbstractSystem() {
        this.events = new EventManager();
    }

    /**
     * Gui getter.
     *
     * @see System#gui
     * @return gui
     */
    public GUISimulator getGui() {
        return this.gui;
    }

    /**
     * Events getter.
     *
     * @see System#events
     * @return events
     */
    public EventManager getEvents() {
        return this.events;
    }
    
    /**
     * Any multi-agent system could be simulated.
     *
     * @return A reference to the current GUI Simulator.
     */
    abstract public GUISimulator simulate();
}
