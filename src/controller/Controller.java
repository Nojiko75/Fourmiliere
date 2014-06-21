package controller;

import view.Rendu;
import view.View;
import model.Constants;
import model.Environment;
import model.Simulation;
import model.SimulationModel;


public class Controller {
	
	private SimulationModel model;
	private View view;
	
	public Controller(SimulationModel model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public SimulationModel getModel() {
		return model;
	}
	
	public void setModel(SimulationModel model) {
		this.model = model;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public void addListenersToModel() {
		this.model.addEnvironmentListener(this.view);
	}	
	
	public void displayViews() {
		this.view.display();
	}
	
	public void closeViews() {
		this.view.close();
	}
	
	public void notifyEnvironmentChanged(Environment environment) {
		this.model.setEnvironment(environment);
	}
	
	public void notifyNextStep() {
		this.model.nextStep();
	}
	
	public void run() {
		while (true) {
//			System.out.println("Controller.run");
			this.model.nextStep(); 
			this.view.paint(this.model); 
			try { 
				Thread.sleep(Constants.SIMULATION_TIME_INTERVAL); 
			} 
			catch (InterruptedException e) { 
				e.printStackTrace(); 
			}
		}

	}
	
	
}
