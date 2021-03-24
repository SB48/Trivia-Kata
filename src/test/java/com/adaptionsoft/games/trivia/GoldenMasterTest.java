package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class GoldenMasterTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	//Use a random seed
	@Test
	public void gameRuns() throws Exception {
		boolean notAWinner;
		Game game = new Game();
		game.add("Chet");
		game.add("Pat");
		game.add("Sue");
		Random rand = new Random();
		do {
			game.roll(rand.nextInt(5) + 1);
			if (rand.nextInt(9) == 7) {
				notAWinner = game.wrongAnswer();
			} else {
				notAWinner = game.wasCorrectlyAnswered();
			}

		} while (notAWinner);
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

//	@Test
//	public void check_current_player_index(){
//		Game game = new Game();
//		String expectedOutput = outContent.toString();
//
//		assertEquals(outContent.toString()), (
//				"Paul was added\n" +
//						"They are player number 1\n" +
//						"Paul is the current player\n" +
//						"They have rolled a 7\n" +
//						"Paul's new location is 7\n" +
//						"The category is Rock\n" +
//						"Rock Question 0\n");
//		)
//
//	}

}
