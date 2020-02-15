import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	public static BufferedImage rocket;
	public static boolean needImageRocket = true;
	public static boolean gotImageRocket = false;

	public static BufferedImage alien;
	public static boolean needImageAlien = true;
	public static boolean gotImageAlien = false;

	public static BufferedImage bullet;
	public static boolean needImageBullet = true;
	public static boolean gotImageBullet = false;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImageRocket) {
			loadRocket("rocket.png");
		}
		if (needImageAlien) {
			loadAlien("rocket.png");
		}
		if (needImageBullet) {
			loadBullet("rocket.png");
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		if (gotImageRocket) {
			g.drawImage(rocket, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		
		if (gotImageAlien) {
			g.drawImage(alien, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		
		if (gotImageBullet) {
			g.drawImage(bullet, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

	public void right() {
		x += speed;
	}

	public void left() {
		x -= speed;
	}

	public void up() {
		y -= speed;
	}

	public void down() {
		y += speed;
	}

	void loadRocket(String imageFile) {
		if (needImageRocket) {
			try {
				rocket = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
				gotImageRocket = true;
			} catch (Exception e) {

			}
			needImageRocket = false;
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

	void loadBullet(String imageFile) {
		if (needImageBullet) {
			try {
				bullet = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
				gotImageBullet = true;
			} catch (Exception e) {

			}
			needImageBullet = false;
		}

	}
}
