package bowling.game.main;

public class Game {

    private int score = 0;

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
	rolls[currentRoll++] = pins;

    }

    public int score() {
	int rollNumber = 0;
	for (int frame = 0; frame < 10; frame++) {
	    if (isStrike(rollNumber)) {
		score += 10 + bonusForStrike(rollNumber);
		rollNumber++;
	    } else if (isSpare(rollNumber)) {
		score += 10 + bonusForSpare(rollNumber);
		rollNumber += 2;
	    } else {
		score += commonSumming(rollNumber);
		rollNumber += 2;
	    }
	}
	return score;
    }

    private boolean isStrike(int rollNumber) {
	return rolls[rollNumber] == 10;
    }

    private boolean isSpare(int rollNumber) {
	return rolls[rollNumber] + rolls[rollNumber + 1] == 10;
    }

    private int bonusForStrike(int rollNumber) {
	return rolls[rollNumber + 1] + rolls[rollNumber + 2];
    }

    private int bonusForSpare(int rollNumber) {
	return rolls[rollNumber + 2];
    }

    private int commonSumming(int rollNumber) {
	return rolls[rollNumber] + rolls[rollNumber + 1];

    }

}
