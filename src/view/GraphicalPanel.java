package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JPanel;

import model.Ant;
import model.Anthill;
import model.Constants;
import model.Environment;
import model.Pheromone;
import model.Sprite;

public class GraphicalPanel extends JPanel {
	
	private Environment environment;
	private Sprite antSprite;
	
	public GraphicalPanel(Environment environment) {
		this.environment = environment;
		this.antSprite = new Sprite(Constants.ANT_SPRITE_URL, 4, 4);
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		List<Ant> ants = this.environment.getAnts();
		Anthill anthill = this.environment.getAnthill();
		double[][] pheromoneMap = this.environment.getPheromoneMap();
		double[][] foodMap = this.environment.getFoodMap();
		
		// Environment
		int cols = (int) this.environment.getDimension().getWidth();
		int rows = (int) this.environment.getDimension().getHeight();
		int s = Constants.ENVIRONMENT_TILE_SIZE;
		int d = Constants.ENVIRONMENT_SPACE_BETWEEN_TILES;
		int dd = d / 2;
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				int x = i * (s + d) + (d / 2);
				int y = j * (s + d) + (d / 2);
//				g.fillRect(x, y, s, s);
				g.fillOval(x, y, s, s);
			}
		}
		
		// Anthill
		g.setColor(anthill.getColor());
		g.fillRect((anthill.getPosition().x * (s + d)) + dd, (anthill.getPosition().y * (s + d)) + dd, s, s);
		
		// Food
		Point food = this.environment.getFoodPosition();
		g.setColor(Color.GREEN);
		g.fillRect((food.x * (s + d)) + dd, (food.y * (s + d)) + dd, s, s);
		// Food map
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				double value = foodMap[i][j];
				if (value > 0.0) {
					int delta = (s - s) / 2;
					g.fillRect(i * (s + d) + dd + delta, j * (s + d) + dd + delta, s, s);
				}
			}
		}

		// Pheromones
		g.setColor(Constants.PHEROMONE_COLOR);
		int pheromoneSize = Constants.PHEROMONE_SIZE;
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				double value = pheromoneMap[i][j];
				if (value > 0.0) {
					int delta = (s - pheromoneSize) / 2;
					g.fillRect(i * (s + d) + dd + delta, j * (s + d) + dd + delta, pheromoneSize, pheromoneSize);
				}
			}
		}
		
		// Ants
//		for (Ant ant : ants) {
//			int delta = (s - ant.getSize()) / 2;
//			g.setColor(ant.getColor());
//			g.fillRect(ant.getPosition().x * (s + d) + dd + delta, ant.getPosition().y * (s + d) + dd + delta, ant.getSize(), ant.getSize());
//		}
		for (Ant ant : ants) {
			int frame = 0;
			int deltaX = 0;
			int deltaY = 0;
			int movingState = ant.getMovingState();
			if (movingState >= ant.getSpeed()) {
				ant.setMovingState(-1);
			}
			else if (movingState >= 0) {
				frame = movingState / (ant.getSpeed() / 4);
				if (frame > 3) {
					frame %= 4;
				}
				
				int pixels = s + d - ((s + d) * movingState / ant.getSpeed());
				int direction = ant.getDirection();
				switch (direction) {
					case Constants.DIRECTION_DOWN:
						deltaY = -pixels;
						break;
					case Constants.DIRECTION_LEFT:
						deltaX = pixels;
						break;
					case Constants.DIRECTION_RIGHT:
						deltaX = -pixels;
						break;
					case Constants.DIRECTION_UP:
						deltaY = pixels;
						break;
				}
				ant.setMovingState(movingState + 1);
			}
			int delta = s - ant.getSize() + 2;
			g.setColor(ant.getColor());
			int x = ant.getPosition().x * (s + d) + delta + deltaX;
			int y = ant.getPosition().y * (s + d) + delta + deltaY;
			g.fillRect(x, y, ant.getSize(), ant.getSize());
//			this.antSprite.draw(g, frame, ant.getDirection(), x, y);

		}
		

		
	}
	
	
}







