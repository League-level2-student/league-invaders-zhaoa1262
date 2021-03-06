import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	int score = 0;

	int getScore() {
		return score;

	}

	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	void addProjectile(Projectile object) {
		projectiles.add(object);
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
		System.out.println("bob");
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien alien = aliens.get(i);
			alien.update();
			
				checkCollision();
				purgeObjects();
			
			if (alien.y > 800 || alien.x < 0) {
				alien.isActive = false;
			}
		}

		for (int i = 0; i < projectiles.size(); i++) {
			Projectile projectile = projectiles.get(i);
			projectile.update();
			if (rocket.isActive == false) {
				checkCollision();
				purgeObjects();
			}
		}

	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			Alien alien = aliens.get(i);
			alien.draw(g);
		}
		for (int x = 0; x < projectiles.size(); x++) {
			Projectile projectile = projectiles.get(x);
			projectile.draw(g);
		}
	}

	void checkCollision() {
		for (Alien alien : aliens) {
			
			if (rocket.collisionBox.intersects(alien.collisionBox)) {
				rocket.isActive = false;
				alien.isActive = false;

			}

		}

		for (Projectile projectile : projectiles) {

			for (Alien alienx : aliens) {
				
				if (projectile.collisionBox.intersects(alienx.collisionBox)) {
					alienx.isActive = false;
					projectile.isActive = false;
					score = score + 1;

				}
			}
		}

	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien alien = aliens.get(i);
			if (alien.isActive == false) {
				aliens.remove(i);
			}
		}
		for (int x = 0; x < projectiles.size(); x++) {
			Projectile projectile = projectiles.get(x);
			if (projectile.isActive == false) {
				projectiles.remove(x);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();

	}

}
