import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject {

	public static BufferedImage alien;
	public static boolean needImageAlien = true;
	public static boolean gotImageAlien = false;
	
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 1;
		if (needImageAlien) {
			loadAlien("alien.png");
		}
	}

	void update() {
		y += speed;
		 super.update();
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
		if (gotImageAlien) {
			g.drawImage(alien, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	
	void loadAlien(String imageFile) {
		if (needImageAlien) {
			try {
				alien = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
				gotImageAlien = true;
			} catch (Exception e) {

			}
			needImageAlien = false;
		}

	}
}
