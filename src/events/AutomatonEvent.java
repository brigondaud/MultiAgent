package events;

import automata.Automaton;

/**
 * The AutomatonEvent corresponds to the event that can be added to an event
 * manager of a cellular automaton. The event auto-generates other events in its
 * event manager to simulate a continuous evolution of the cellular automaton.
 *
 * @author Team 22 in Teide
 * @version 1.0
 */
public class AutomatonEvent extends Event {

    /**
     * The automaton on which the event is executed.
     */
    private final Automaton automaton;

    /**
     * Initiate the event with a given date and the automaton on which the event
     * will be executed.
     *
     * @param date      The date to fire the event.
     * @param automaton The associated automaton with this event.
     */
    public AutomatonEvent(long date, Automaton automaton) {
        super(date);
        
        if (automaton == null)
            throw new IllegalArgumentException("Automaton cannot be null");
                
        this.automaton = automaton;
    }

    /**
     * The execution of the event computes the next generation of the cellular
     * automaton's grid. Its also generate another event in the event manager to
     * simulate the constant evolution of the cellular automaton.
     */
    @Override
    public void execute() {
        automaton.executeEvent();
        
        // Generates another event in the event manager
        automaton.getEvents().addEvent(new AutomatonEvent(getDate() + 1, automaton));
    }

}
