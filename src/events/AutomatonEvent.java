package events;

import automata.Automaton;
import automata.Grid;

/**
 * The AutomatonEvent corresponds to the event that can be added to an event
 * manager of a cellular automaton. The event auto-generates other events in its
 * event manager to simulate a continuous evolution of the cellular automaton.
 *
 * @author Baptiste Rigondaud
 *
 */
public class AutomatonEvent extends Event {

    /**
     * The automaton on which the event is executed.
     */
    private Automaton automaton;

    /**
     * Initiate the event with a given date and the automaton on which the event
     * will be executed.
     *
     * @param date
     * @param automaton
     */
    public AutomatonEvent(long date, Automaton automaton) {
        super(date);
        this.automaton = automaton;
    }

    /**
     * The execution of the event computes the next generation of the cellular
     * automaton's grid. Its also generate another event in the event manager to
     * simulate the constant evolution of the cellular automaton.
     */
    @Override
    public void execute() {
        automaton.getGrid().computeNextGeneration();
        automaton.getGrid().draw(automaton.getGui(), automaton.getCellSize(), false);
        automaton.getEvents().addEvent(new AutomatonEvent(getDate() + 1, automaton));
    }

}
