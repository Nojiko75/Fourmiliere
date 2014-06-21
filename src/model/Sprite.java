package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	private BufferedImage image;
	private BufferedImage[] sprites;
	private String imageUrl;
	private int nbrOfPoses;
	private int nbrOfDirections;
	
	public Sprite(String imageUrl, int nbrOfPoses, int nbrOfDirections) {
		this.imageUrl = imageUrl;
		this.nbrOfPoses = nbrOfPoses;
		this.nbrOfDirections = nbrOfDirections;
		this.image = null;
		try {
			this.image = ImageIO.read(new File(this.imageUrl));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		final int width = this.image.getWidth() / this.nbrOfPoses;
		final int height = this.image.getHeight() / this.nbrOfDirections;
		this.sprites = new BufferedImage[this.nbrOfDirections * this.nbrOfPoses];
		for (int i = 0; i < this.nbrOfDirections; i++) {
			for (int j = 0; j < this.nbrOfPoses; j++) {
				sprites[(i * this.nbrOfPoses) + j] = this.image.getSubimage(j * width, i * height, width, height);
			}
		}
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public int getNbrOfPoses() {
		return nbrOfPoses;
	}

	public void setNbrOfPoses(int nbrOfPoses) {
		this.nbrOfPoses = nbrOfPoses;
	}

	public int getNbrOfDirections() {
		return nbrOfDirections;
	}

	public void setNbrOfDirections(int nbrOfDirections) {
		this.nbrOfDirections = nbrOfDirections;
	}

	public int getWidth() {
		return this.image.getWidth(null);
	}

	public int getHeight() {
		return this.image.getHeight(null);
	}

	public void draw(Graphics g, int frame, int x, int y) {
		g.drawImage(this.sprites[frame], x, y, null);
	}

	public void draw(Graphics g, int col, int row, int x, int y) {
		int frame = this.nbrOfPoses * row + col;
		this.draw(g, frame, x, y);
	}
	
}

