import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Rocketship extends GameObject {
	public static BufferedImage rocket;
	public static boolean needImageRocket = true;
	public static boolean gotImageRocket = false;

	

	

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImageRocket) {
			loadRocket("rocket.png");
		}
		
		
	}

	void draw(Graphics g) {
		
		if (gotImageRocket) {
			g.drawImage(rocket, x, y, width, height, null);
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

	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
} 

	
}
