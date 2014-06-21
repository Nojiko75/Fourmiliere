package model;

public class Simulation {
	private Environment environment;
	
	public Simulation(Environment environment) {
		this.environment = environment;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "Simulation [environment=" + environment + "]";
	}
	
	public void nextStep() {
		this.moveAnts();
		this.updatePheromones();
	}
	
	public void moveAnts() {
		for (Ant ant : this.environment.getAnts()) {
			int direction = ant.chooseNextDirection();
			ant.move(direction);
		}
	}
	
	public void updatePheromones() {
		for (Ant ant : this.environment.getAnts()) {
			int rand = (int) (Math.random() * 10000);
			if (rand == 0) {
				this.environment.leavePheromone(ant.getPosition());
			}
		}
	}
}
