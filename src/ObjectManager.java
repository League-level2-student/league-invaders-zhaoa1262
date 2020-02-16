import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random; 

public class ObjectManager implements ActionListener{
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();

	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	void addProjectile(Projectile object) {
		projectiles.add(object);
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien alien = aliens.get(i);
			alien.update();
			if (LeagueInvaders.HEIGHT > 800 || LeagueInvaders.HEIGHT < 0) {
				alien.isActive = false;
			}
		} 
		
		for(int i = 0; i < projectiles.size(); i++) {
			Projectile projectile = projectiles.get(i);
			projectile.update();
		}
		System.out.println(projectiles.size());

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
		
	}
	
	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien alien = aliens.get(i);
			if (alien.isActive == false) {
				aliens.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}

}
