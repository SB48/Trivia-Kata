package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class GameUnitTest {

    @Test
    public void circular_board_max_location(){
        //reset position on circular board if player is above 11
        Game game = new Game();
        game.add("Sue");
        game.roll(12);
        String actualOutput = game.resetPlayerLocation();
        String expectedOutput = "Sue's new location is 2";
        assertEquals(expectedOutput, actualOutput);
    }


}
