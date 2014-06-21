package model;

import javax.swing.event.EventListenerList;

public class SimulationModel extends Simulation {
	private Environment environment;
	private EventListenerList listeners;

	public SimulationModel(Environment environment) {
		super(environment);
		this.listeners = new EventListenerList();
	}

	public void setEnvironment(Environment environment) {
		super.setEnvironment(environment);
		this.fireEnvironmentChanged();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public void nextStep() {
		super.nextStep();
		this.fireEnvironmentChanged();
	}
	
	public void moveAnts() {
		super.moveAnts();
		this.fireEnvironmentChanged();
	}
	
	public void addEnvironmentListener(EnvironmentListener l) {
		this.listeners.add(EnvironmentListener.class, l);
	}
	
	public void removeEnvironmentListener(EnvironmentListener l) {
		this.listeners.remove(EnvironmentListener.class, l);
	}
	
	private void fireEnvironmentChanged() {
		EnvironmentListener[] listenerList = (EnvironmentListener[])this.listeners.getListeners(EnvironmentListener.class);
		for(EnvironmentListener listener : listenerList) {
			listener.environmentChanged(new EnvironmentChangedEvent(this, this.environment));
		}
	}	
}
