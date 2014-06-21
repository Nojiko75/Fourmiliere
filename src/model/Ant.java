package model;

import java.awt.Color;
import java.awt.Point;

public class Ant {
	private Point position;
	private int size;
	private int speed;
	private Color color;
	private boolean caringFood;
	private int movingState;
	private int direction;
	
	public Ant(Point position, int size, int speed, Color color) {
		super();
		this.position = position;
		this.size = size;
		this.speed = speed;
		this.color = color;
		this.caringFood = false;
		this.movingState = -1;
		this.direction = 0;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isCaringFood() {
		return caringFood;
	}

	public void setCaringFood(boolean caringFood) {
		this.caringFood = caringFood;
	}

	public int getMovingState() {
		return movingState;
	}

	public void setMovingState(int movingState) {
		this.movingState = movingState;
	}
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Ant [position=" + position + ", size=" + size + ", speed="
				+ speed + ", color=" + color + ", caringFood=" + caringFood
				+ ", movingState=" + movingState + ", direction=" + direction
				+ "]";
	}

	public Point getNextTile(int direction) {
		Point position = new Point(this.position);
		switch (direction) {
			case Constants.DIRECTION_DOWN:
				position.setLocation(this.position.x, this.position.y + 1);
				break;
			case Constants.DIRECTION_LEFT:
				position.setLocation(this.position.x - 1, this.position.y);
				break;
			case Constants.DIRECTION_RIGHT:
				position.setLocation(this.position.x + 1, this.position.y);
				break;
			case Constants.DIRECTION_UP:
				position.setLocation(this.position.x, this.position.y - 1);
				break;
		}
		return position;
	}
	
	public boolean move(int direction) {
		if (this.movingState >= 0) {
			return false;
		}
		
		this.direction = direction;
		
		Point nextPosition = this.getNextTile(direction);
		if (nextPosition.x < 0 || nextPosition.y < 0 || nextPosition.x >= Constants.ENVIRONMENT_WIDTH || nextPosition.y >= Constants.ENVIRONMENT_HEIGHT) {
			return false;
		}
		
		this.movingState = 1;
		
		this.position = new Point(nextPosition);
		
		return true;
	}
	
	public int chooseNextDirection() {
		return (int) (Math.random() * 4);
	}
	
	
}
