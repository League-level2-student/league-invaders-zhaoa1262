import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class LeagueInvaders implements KeyListener {
	JFrame frame;
	GamePanel gamePanel;

	public static final int frameWidth = 500;
	public static final int frameHeight = 800;

	LeagueInvaders() {
		frame = new JFrame();
		gamePanel = new GamePanel();
	}

	void setup() {
		frame.add(gamePanel);
		frame.setVisible(true);
		frame.setSize(frameWidth, frameHeight);
		frame.addKeyListener(gamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		LeagueInvaders thing = new LeagueInvaders();
		thing.setup();
		System.out.println();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
