package model;

import java.util.EventObject;

public class EnvironmentChangedEvent extends EventObject {
	private Environment environment;
	
	public EnvironmentChangedEvent(Object source, Environment environment) {
		super(source);
		this.environment = environment;
	}
	
	public Environment getEnvironment() {
		return this.environment;
	}
}
