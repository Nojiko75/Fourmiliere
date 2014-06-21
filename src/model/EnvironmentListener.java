package model;

import java.util.EventListener;

public interface EnvironmentListener extends EventListener {
	public void environmentChanged(EnvironmentChangedEvent event);
}
