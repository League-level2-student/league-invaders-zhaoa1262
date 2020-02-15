import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
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
	

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		enterToStart = new Font("Arial", Font.ROMAN_BASELINE, 30);
		spaceForIntructions = new Font("Arial", Font.ROMAN_BASELINE, 30);

		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();

	}

	void updateMenuState() {

	}

	void updateGameState() {
		objectManager.update();
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
		setBackground("space.png");
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		objectManager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
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
		System.out.println("action");
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
			} else {
				currentState++;
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
