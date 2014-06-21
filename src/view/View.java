package view;

import javax.swing.JFrame;

import controller.Controller;
import model.Constants;
import model.EnvironmentListener;
import model.SimulationModel;

public abstract class View extends JFrame implements EnvironmentListener, Constants {
	
	private Controller controller;
	
	public View(Controller controller) {
		this.controller = controller;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public final Controller getController() {
		return this.controller;
	}
	
	public abstract void paint(SimulationModel model);
	
	public abstract void display();
	
	public abstract void close();
}
