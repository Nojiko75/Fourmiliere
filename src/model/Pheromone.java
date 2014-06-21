package model;

import java.awt.Color;
import java.awt.Point;

public class Pheromone {
	private Point position;
	private int size;
	private Color color;
	
	public Pheromone(Point position, int size, Color color) {
		super();
		this.position = position;
		this.size = size;
		this.color = color;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public void setPosition(Point position) {
		this.position = position;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Pheromone [position=" + position + ", size=" + size
				+ ", color=" + color + "]";
	}

	
	
	
}
