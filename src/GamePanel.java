import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;

	Font titleFont;
	Font enterToStart;
	Font spaceForIntructions;
	Timer frameDraw;

	Rocketship rocketship = new Rocketship(250, 700, 50, 50);
	ObjectManager objectManager = new ObjectManager(rocketship);

	public static BufferedImage background;

	Timer alienSpawn;

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		enterToStart = new Font("Arial", Font.ROMAN_BASELINE, 30);
		spaceForIntructions = new Font("Arial", Font.ROMAN_BASELINE, 30);

		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();

		try {
			background = ImageIO.read(this.getClass().getResourceAsStream("space-1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		objectManager.update();
		if (rocketship.isActive == false) {
			currentState = END;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("LEAGUE INVADERS", 25, 150);

		g.setFont(enterToStart);
		g.setColor(Color.WHITE);
		g.drawString("Press ENTER to start", 100, 350);

		g.setFont(spaceForIntructions);
		g.setColor(Color.WHITE);
		g.drawString("Press SPACE for intructions", 60, 550);
	}

	void drawGameState(Graphics g) {
		g.drawImage(background, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		objectManager.draw(g);
		
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		g.setColor(Color.black);
		g.drawString("score: "+objectManager.getScore(), 10, 10);
	}

	void startGame() {
		alienSpawn = new Timer(1000, objectManager);
		alienSpawn.start();
		
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}

		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			}

			else {
				currentState++;

				if (currentState == END) {
					alienSpawn.stop();
					rocketship = new Rocketship(rocketship.x, rocketship.y, 50, 50);
					objectManager = new ObjectManager(rocketship);
				}

			}
			if (currentState == GAME) {
				startGame();
			}
		}
		if (currentState == MENU) {

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				JOptionPane.showMessageDialog(null, "Use arrow keys to move. Press SPACE to fire. Try not to die.");
				
			}
		}

		if (currentState == GAME) {

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				objectManager.addProjectile(rocketship.getProjectile());
				
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (rocketship.y <= 750) {
				System.out.println("DOWN");
				rocketship.down();

			}
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (rocketship.y >= 0) {
				System.out.println("UP");
				rocketship.up();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (rocketship.x >= 0) {
				System.out.println("LEFT");
				rocketship.left();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (rocketship.x <= 450) {
				System.out.println("RIGHT");
				rocketship.right();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
