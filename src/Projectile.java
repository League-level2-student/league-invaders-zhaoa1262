import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Projectile extends GameObject {
	public static BufferedImage bullet;
	public static boolean needImageBullet = true;
	public static boolean gotImageBullet = false;
	
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImageBullet) {
			loadBullet("b.png");
		}
	}

	void update() {
		y -= speed;
		 super.update();
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		if (gotImageBullet) {
			g.drawImage(bullet, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
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
