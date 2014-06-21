package model;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

public class Anthill {
	private List<Ant> ants;
	private Point position;
	private int size;
	private Color color;
	
	public Anthill(List<Ant> ants, Point position, int size, Color color) {
		super();
		this.ants = ants;
		this.position = position;
		this.size = size;
		this.color = color;
	}

	public List<Ant> getAnts() {
		return ants;
	}

	public void setAnts(List<Ant> ants) {
		this.ants = ants;
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
		return "Anthill [ants=" + ants + ", position=" + position + ", size="
				+ size + "]";
	}
	
	
	
	
}
