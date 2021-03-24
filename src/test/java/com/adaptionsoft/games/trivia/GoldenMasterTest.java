package com.adaptionsoft.games.trivia;

import static org.approvaltests.Approvals.verify;
import static org.junit.Assert.*;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class GoldenMasterTest {
	private final ByteArrayOutputStream OUT_CONTENT = new ByteArrayOutputStream();
	private final int SEED = 100;

	//Use a random seed
	public void gameRuns() throws Exception {
		boolean notAWinner;
		Game game = new Game();
		game.add("Chet");
		game.add("Pat");
		game.add("Sue");
		Random rand = new Random(SEED);
		do {
			game.roll(rand.nextInt(5) + 1);
			if (rand.nextInt(9) == 7) {
				notAWinner = game.wrongAnswer();
			} else {
				notAWinner = game.wasCorrectlyAnswered();
			}

		} while (notAWinner);
	}

	@Test
	public void game_output() throws Exception {
		System.setOut(new PrintStream(OUT_CONTENT));
		gameRuns();
		verify(OUT_CONTENT.toString().trim());

	}

	//This test currently breaks the game as there can only be 6 players but you can
	// keep adding without an exception thrown
	@Test
	public void number_of_players_max() {
		Game game = new Game();
		game.add("Player1");
		game.add("Player2");
		game.add("Player3");
		game.add("Player4");
		game.add("Player5");
		var exception = assertThrows(Exception.class, () -> game.add("Player6"));
		assertEquals("Only 5 players allowed", exception.getMessage());
	}



}
