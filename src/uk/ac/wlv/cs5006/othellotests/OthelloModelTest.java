package uk.ac.wlv.cs5006.othellotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import uk.ac.wlv.cs5006.othello.Controller;
import uk.ac.wlv.cs5006.othello.GamePiece;
import uk.ac.wlv.cs5006.othello.OthelloModel;

class OthelloModelTest {

	@Test
	public void testSetInitialState() {

		OthelloModel model1 = new OthelloModel(4, 4);
		// Sets the board up for turn 1
		model1.setInitialState();
		// Should be 2 black and 2 white pieces together in these spots.
		assertTrue(model1.getGamePiece(1, 1).getValue() == "BLACK");
		assertTrue(model1.getGamePiece(2, 2).getValue() == "BLACK");
		assertTrue(model1.getGamePiece(1, 2).getValue() == "WHITE");
		assertTrue(model1.getGamePiece(2, 1).getValue() == "WHITE");
		// Also making sure the other pieces are empty.
		assertTrue(model1.getGamePiece(0, 0).getValue() == "EMPTY");
		assertTrue(model1.getGamePiece(3, 3).getValue() == "EMPTY");

		assertEquals("BLACK", model1.getGamePiece(1, 1).getValue());

	}

	@Test
	public void testGettersAndAttemptPlay() {
		// This code has already been tested in the Controller test class, just
		// copying them and modifying them from there.
		OthelloModel model = new OthelloModel(4, 4);

		assertTrue(model.getOpponent("WHITE") == "BLACK");
		assertTrue(model.getOpponent("BLACK") == "WHITE");
		assertTrue(model.getOpponent("invalid") == "EMPTY");

		GamePiece token1 = new GamePiece("WHITE");

		// Should currently be a draw of 2 black 2 white (starting pieces)
		assertTrue(model.getWinner() == "NONE");
		// Plays a white piece at 0,1
		model.attemptPlay(0, 1, token1);
		// So this should return whites as the winner now with 3 to 2
		assertTrue(model.getWinner() == "WHITE");
		// Plays a black piece
		GamePiece token2 = new GamePiece("BLACK");
		assertTrue(model.attemptPlay(2, 0, token2) == true);
		// Plays a second black piece so it's now winning (although against the
		// rules).
		assertTrue(model.attemptPlay(0, 2, token2) == true);
		assertTrue(model.getWinner() == "BLACK");
		// Testing some invalid plays to get full coverage.
		assertTrue(model.attemptPlay(0, 2, null) == false);
		assertTrue(model.attemptPlay(55, 55, token1) == false);
		// Invalid token
		GamePiece token3 = new GamePiece("EMPTY");
		assertTrue(model.attemptPlay(0, 2, token3) == false);
	}

	@Test
	public void testAttemptPlay() {
		OthelloModel model = new OthelloModel(4, 4);
		GamePiece gamePiece = new GamePiece("WHITE");
		assertTrue(model.attemptPlay(3, 2, gamePiece));
		assertFalse(model.attemptPlay(1, 2, gamePiece));
	}

	@Test
	public void testAttemptPlayTokenNull() {
		// create the model
		OthelloModel otmodel = new OthelloModel(4, 4);
		assertFalse(otmodel.attemptPlay(1, 2, null));

	}

	@Test
	public void testAttemptPlayNotInMatix() {
		// create the model
		OthelloModel otmodel = new OthelloModel(4, 4);
		GamePiece gPiece = new GamePiece("WHITE");
		assertFalse(otmodel.attemptPlay(6, 5, gPiece));

	}

//	@Test
//	public void testGameMatrixIsFull() {
//		OthelloModel otmodel = new OthelloModel(4, 4);
//		assertFalse(otmodel.gameMatrixIsFull());
//	}

	@Test
	public void testGameMatrixHasFullandSingleValue() {
//		OthelloModel otmodel = new OthelloModel(4, 4);
//		assertFalse(otmodel.gameMatrixHasSingleValue());

		OthelloModel model = new OthelloModel(4, 4);

		GamePiece token1 = new GamePiece("WHITE");
		GamePiece token2 = new GamePiece("BLACK");
		// False since it's only half filled as it's a new game.
		assertTrue(model.gameMatrixIsFull() == false);
		// It should be 2 black 2 white, so we can check this to be false.
		assertTrue(model.gameMatrixHasSingleValue() == false);
		// Loops through every square and sets the value of it to White
		// regardless of if it's a legal play.
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				model.getGamePiece(i, j).setValue("WHITE");
			}
		}
		// It should all be filled now
		assertTrue(model.gameMatrixIsFull() == true);
		// It should also be all white pieces.
		assertTrue(model.gameMatrixHasSingleValue() == true);
	}

	@Test
	public void testGetWinnerWhite() {

		OthelloModel otmodel = new OthelloModel(4, 4);
		Controller controller = new Controller(otmodel);
		GamePiece gPiece = new GamePiece("WHITE");
		controller.attemptPlay(3, 2, gPiece);
		assertEquals("WHITE", otmodel.getWinner());

	}

	@Test
	public void testGetWinnerBlack() {

		OthelloModel model = new OthelloModel(4, 4);
		Controller con1 = new Controller(model);

//         GamePiece token1 = new GamePiece("WHITE");
		GamePiece token2 = new GamePiece("BLACK");

		// Should currently be a draw of 2 black 2 white (starting pieces)
		assertTrue(con1.getWinner() == "NONE");

		// Plays a black piece
		con1.attemptPlay(2, 0, token2);
		// Plays a second black piece so it's now winning (although against the rules).
		// Plays a second black piece so it's now winning (although against the rules)
		con1.attemptPlay(0, 2, token2);
		assertTrue(con1.getWinner() == "BLACK");

		con1.attemptPlay(3, 1, token2);
		assertEquals("BLACK", model.getWinner());
	}

	@Test
	public void testGetWinnerNone() {
		OthelloModel otmodel = new OthelloModel(4, 4);
		assertEquals("NONE", otmodel.getWinner());
	}

	@Test
	public void testGetOpponentAndWinner() {
		OthelloModel model = new OthelloModel(4, 4);

		assertTrue(model.getOpponent("WHITE") == "BLACK");
		assertTrue(model.getOpponent("BLACK") == "WHITE");
		assertTrue(model.getOpponent("invalid") == "EMPTY");
		assertEquals("EMPTY", model.getOpponent("EMPTY"));

		GamePiece token1 = new GamePiece("WHITE");
		GamePiece token2 = new GamePiece("BLACK");
		model.attemptPlay(0, 1, token1);

		// So this should return whites as the winner now with 3 to 2
		assertTrue(model.getWinner() == "WHITE");
		// Plays a black piece
		model.attemptPlay(2, 0, token2);
		// Plays a second black piece so it's now winning (although against the rules).
		model.attemptPlay(0, 2, token2);
		assertTrue(model.getWinner() == "BLACK");				
	}

	@Test
	public void testNotSuccessfullAttempt() {
		OthelloModel otmodel = new OthelloModel(4, 4);
		Controller controller = new Controller(otmodel);
		GamePiece gPiece = new GamePiece("BLACK");
		assertFalse(controller.attemptPlay(3, 2, gPiece));
	}	

	@Test
    public void testIllegalMove() {
        OthelloModel model = new OthelloModel(8, 8);

        GamePiece token1 = new GamePiece("WHITE");
        GamePiece token2 = new GamePiece("BLACK");

        // This is the issue. Before fix this should be correct, however it
        // returns as incorrect because the illegal move will allow it to be
        // valid.
        // Having fixed the OthelloModel (making sure the adjacent boolen is
        // false when there is no counter next to it) now it is a correct
        // statement.
        assertTrue(model.attemptPlay(7, 3, token2) == false);
    }
}
