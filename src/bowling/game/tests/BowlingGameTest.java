package bowling.game.tests;

import bowling.game.main.Game;
import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {

    private Game g;

    protected void setUp() throws Exception {
	g = new Game();
    }

    public void rollMany(int n, int pins) {
	for (int i = 0; i < n; i++)
	    g.roll(pins);
    }

    public void testGutterGame() throws Exception {
	rollMany(20, 0);
	assertEquals(0, g.score());
    }

    public void testAllones() throws Exception {
	rollMany(20, 1);
	assertEquals(20, g.score());
    }

    public void testOnSpare() throws Exception {
	rollSpare();
	g.roll(3);
	rollMany(17, 0);
	assertEquals(16, g.score());
    }

    public void testRollStrike() throws Exception {
	g.roll(5);
	g.roll(4);
	rollStrike();
	g.roll(3);
	rollMany(15, 0);
	assertEquals(25, g.score());
    }

    public void testOneStrike() throws Exception {
	g.roll(10);
	g.roll(3);
	g.roll(4);
	rollMany(16, 0);
	assertEquals(24, g.score());
    }
    
    public void testForPerfectGame(){
	rollMany(12,10);
	assertEquals(300,g.score());
	
    }
    
    public void testWithBonuses(){
	
	g.roll(5);
	g.roll(10);
    	g.roll(3);
    	g.roll(7);
    	rollMany(15,1);
    	assertEquals(46,g.score());
    }

    public void rollSpare() {
	g.roll(5);
	g.roll(5);
    }

    public void rollStrike() {
	g.roll(10);
    }
}
