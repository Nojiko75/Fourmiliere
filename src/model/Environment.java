package model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Environment {
	private Anthill anthill;
	private List<Ant> ants;
	private Dimension dimension;
	private Point foodPosition;
	private double[][] pheromoneMap;
	private double[][] foodMap;
	
	public Environment() {
		this.ants = new LinkedList<Ant>();
		for (int i = 0; i < Constants.ANTHILL_ANT_CAPACITY; i++) {
			int x = (int) (Constants.FRAME_WIDTH * Math.random());
			int y = (int) (Constants.FRAME_HEIGHT * Math.random());
			Ant ant = new Ant(new Point(x, y), Constants.ANT_SIZE, Constants.ANT_SPEED, Constants.ANT_COLOR);
			this.ants.add(ant);
		}
		this.anthill = new Anthill(this.ants, new Point(50, 50), Constants.ANTHILL_SIZE, Constants.ANTHILL_COLOR);
	}
	
	public Environment(int width, int height) {
		this.dimension = new Dimension(width, height);
		
		this.ants = new LinkedList<Ant>();
		for (int i = 0; i < Constants.ANTHILL_ANT_CAPACITY; i++) {
			int x = (int) (width * Math.random());
			int y = (int) (height * Math.random());
			Ant ant = new Ant(new Point(x, y), Constants.ANT_SIZE, Constants.ANT_SPEED, Constants.ANT_COLOR);
			this.ants.add(ant);
		}
		this.anthill = new Anthill(this.ants, new Point(0, 0), Constants.ANTHILL_SIZE, Constants.ANTHILL_COLOR);
		this.foodPosition = new Point(width - 1, height - 1);
		this.pheromoneMap = new double[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				this.pheromoneMap[i][j] = 0.0;
			}
		}
		this.foodMap = new double[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				this.foodMap[i][j] = 0.0;
			}
		}
		this.foodMap[(int) this.foodPosition.getX()][(int) this.foodPosition.getY()] = 1.0;
	}

	public Anthill getAnthill() {
		return anthill;
	}

	public void setAnthill(Anthill anthill) {
		this.anthill = anthill;
	}

	public List<Ant> getAnts() {
		return ants;
	}

	public void setAnts(List<Ant> ants) {
		this.ants = ants;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Point getFoodPosition() {
		return foodPosition;
	}
	
	public void setFoodPosition(Point foodPosition) {
		this.foodPosition = foodPosition;
	}

	public double[][] getPheromoneMap() {
		return pheromoneMap;
	}
	

	public void setPheromoneMap(double[][] pheromoneMap) {
		this.pheromoneMap = pheromoneMap;
	}
	

	public double[][] getFoodMap() {
		return foodMap;
	}
	

	public void setFoodMap(double[][] foodMap) {
		this.foodMap = foodMap;
	}
	

	@Override
	public String toString() {
		return "Environment [anthill=" + anthill + ", ants=" + ants
				+ ", dimension=" + dimension
				+ ", foodPosition=" + foodPosition + "]";
	}

	public boolean leavePheromone(Point position) {
		Pheromone pheromone = new Pheromone(position, Constants.PHEROMONE_SIZE, Constants.PHEROMONE_COLOR);
		this.pheromoneMap[(int) position.getX()][(int) position.getY()] = 1.0;
		return true;
	}
	
	
	
	
	
	
}
