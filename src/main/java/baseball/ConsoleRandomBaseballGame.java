package baseball;

import baseball.baseball.Digits;
import baseball.baseball.RandomBaseballGame;
import baseball.baseball.Result;

public class ConsoleRandomBaseballGame {
    private final RandomBaseballGame randomBaseballGame;
    private final GameConsole gameConsole;

    public ConsoleRandomBaseballGame(RandomBaseballGame randomBaseballGame, GameConsole gameConsole) {
        this.randomBaseballGame = randomBaseballGame;
        this.gameConsole = gameConsole;
    }

    public void play() {
        gameConsole.printInit();

        while (true) {
            playOneGame();
            boolean shallReplay = gameConsole.inputShallReplay();

            if (!shallReplay) break;
        }
    }

    private void playOneGame() {
        randomBaseballGame.newGame();

        while (true) {
            if (playOneTurn()) break;
        }
    }

    /**
     * @return 게임 종료 여부
     */
    private boolean playOneTurn() {
        Digits digits = gameConsole.readDigits();
        Result result = randomBaseballGame.match(digits);

        return gameConsole.printGameResult(result);
    }
}
