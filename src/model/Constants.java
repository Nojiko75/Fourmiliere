package model;
import java.awt.Color;

public interface Constants {
	
	public static final int SIMULATION_TIME_INTERVAL = 16;
	
	// Fenêtre
	public static final String FRAME_TITLE = "Fourmiland";
	public static final int FRAME_WIDTH = 335;
	public static final int FRAME_HEIGHT = 263;
	
	// Environnement
	public static final int ENVIRONMENT_WIDTH = 10;
	public static final int ENVIRONMENT_HEIGHT = 7;
	public static final int ENVIRONMENT_TILE_SIZE = 16;
	public static final int ENVIRONMENT_SPACE_BETWEEN_TILES = 16;
	
	// Fourmi
	public static final int ANT_SIZE = 3;
	public static final int ANT_SPEED = 30;
	public static final Color ANT_COLOR = Color.BLACK;
	public static final String ANT_SPRITE_URL = "Ant_pt.png";
	
	// Fourmilière
	public static final int ANTHILL_ANT_CAPACITY = 50;
	public static final int ANTHILL_SIZE = 16;
	public static final Color ANTHILL_COLOR = Color.GRAY;
	
	// Phéromone
	public static final int PHEROMONE_SIZE = 10;
	public static final Color PHEROMONE_COLOR = Color.PINK;

	public static final int DIRECTION_DOWN = 0;
	public static final int DIRECTION_LEFT = 1;
	public static final int DIRECTION_RIGHT = 2;
	public static final int DIRECTION_UP = 3;
	
	
}
