import java.util.ArrayList;
import java.util.Random;

public class ModelManagement {
  Rocketship rocket;
  ArrayList <Projectile> projectiles = new ArrayList<Projectile>();
  ArrayList <Alien> aliens = new ArrayList <Alien> ();
  Random random = new Random();
  
  ModelManagement(Rocketship rocket) {
	  
  }
  
  void addProjectile(Projectile object) {
	  projectiles.add(object);
  }
  
  void addAlien() {
	  aliens.add(new Alien(random.nextInt(LeagueInvaders.frameWidth),0,50,50));
  }
  
}
