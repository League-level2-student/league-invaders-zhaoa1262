import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	public static final int frameWidth = 500;
	public static final int frameHeight = 800;
	
	LeagueInvaders () {
		frame = new JFrame();
	}
	
	void setup() {
		frame.setVisible(true);
		frame.setSize(frameWidth, frameHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	
public static void main(String[] args) {
	LeagueInvaders thing = new LeagueInvaders();
	thing.setup();
}
}
