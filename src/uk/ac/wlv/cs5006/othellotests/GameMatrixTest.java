package uk.ac.wlv.cs5006.othellotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import uk.ac.wlv.cs5006.othello.GameMatrix;
import uk.ac.wlv.cs5006.othello.GamePiece;

class GameMatrixTest {

	@Test
	public void testDefaultConstructor() {
		GameMatrix gMatrix = new GameMatrix(4, 4);
		assertEquals(4, gMatrix.getNumRows());
		assertEquals(4, gMatrix.getNumColumns());
	}

	@Test
	public void testClear() {
		GameMatrix gMatrix = new GameMatrix(4, 4);
		gMatrix.clear();
		for (int i = 0; i < gMatrix.getNumRows(); i++) {
			for (int j = 0; j < gMatrix.getNumColumns(); j++) {
				assertEquals("EMPTY", gMatrix.getGamePiece(i, j).getValue());
			}
		}

	}

	@Test
	public void testSetGamePieceValue() {
		GameMatrix gMatrix = new GameMatrix(4, 4);
		assertTrue(gMatrix.setGamePieceValue(3, 3, "BLACK"));
		assertFalse(gMatrix.setGamePieceValue(-2, -2, "BLACK"));
		assertFalse(gMatrix.setGamePieceValue(5, 5, "BLACK"));
	}

	@Test
	public void testGetGamePieceValue() {
		GamePiece gPiece = new GamePiece("BLACK");
		GameMatrix gMatrix = new GameMatrix(4, 4);
		gMatrix.setGamePieceValue(3, 3, "BLACK");
		assertEquals(gPiece.getValue(), gMatrix.getGamePiece(3, 3).getValue());
	}

	@Test
	public void testGetGamePieceValueNull() {
		GameMatrix gMatrix = new GameMatrix(4, 4);
		gMatrix.setGamePieceValue(3, 3, "BLACK");
		assertEquals(null, gMatrix.getGamePiece(7, 7));
	}

	@Test
	public void testIsOnMatrix() {
		GameMatrix gMatrix = new GameMatrix(4, 4);
		assertTrue(gMatrix.isOnGameMatrix(3, 3));
		assertFalse(gMatrix.isOnGameMatrix(3, 5));
		assertFalse(gMatrix.isOnGameMatrix(5, 3));
		assertFalse(gMatrix.isOnGameMatrix(-2, 3));
	}

	@Test
	public void testGameMatrixIsFull() {
		GameMatrix gMatrix = new GameMatrix(4, 4);
		for (int i = 0; i < gMatrix.getNumRows(); i++) {
			for (int j = 0; j < gMatrix.getNumColumns(); j++) {
				gMatrix.getGamePiece(i, j).setValue("BLACK");
			}
		}
		assertTrue(gMatrix.gameMatrixIsFull());
		gMatrix.clear();
		assertFalse(gMatrix.gameMatrixIsFull());
	}

	@Test
	public void testGameMatrixHasSingleValue() {
		GameMatrix gMatrix = new GameMatrix(4, 4);
		gMatrix.getGamePiece(0, 1).setValue("BLACK");

		assertTrue(gMatrix.gameMatrixHasSingleValue());
		gMatrix.getGamePiece(1, 1).setValue("WHITE");
		assertFalse(gMatrix.gameMatrixHasSingleValue());
	}
	
	@Test
    public void testGettersAndSettersAndClear() {
        GameMatrix board1 = new GameMatrix(5, 6);
        board1.setGamePieceValue(2, 2, "BLACK");
        assertTrue(board1.getGamePiece(2, 2).getValue() == "BLACK");
        board1.setGamePieceValue(4, 1, "Test Value");
        assertTrue(board1.getGamePiece(4, 1).getValue() == "Test Value");
        // This is making sure you cant set a value on an invalid area.
        assertTrue(board1.setGamePieceValue(10, 10, "SHOULD FAIL") == false);
        // Clears the board
        board1.clear();
        // Tests if they have been set to empty now.
        assertTrue(board1.getGamePiece(2, 2).getValue() == "EMPTY");
        assertTrue(board1.getGamePiece(4, 1).getValue() == "EMPTY");
    }

    @Test
    public void testIsOnGameMatrix() {
        GameMatrix board1 = new GameMatrix(5, 6);

        board1.setGamePieceValue(2, 2, "BLACK");
        // These checks make sure all of the if statement is covered. Just
        // simply different values to check valid, too small, and too large
        // numbers.
        assertTrue(board1.isOnGameMatrix(0, 0) == true);
        // Numbers too small for the board.
        assertTrue(board1.isOnGameMatrix(-1, -1) == false);
        assertTrue(board1.isOnGameMatrix(1, 1) == true);
        assertTrue(board1.isOnGameMatrix(1, -1) == false);
        assertTrue(board1.isOnGameMatrix(-1, -1) == false);
        // Numbers too big for the board.
        assertTrue(board1.isOnGameMatrix(10, 11) == false);
        assertTrue(board1.isOnGameMatrix(10, 2) == false);
        assertTrue(board1.isOnGameMatrix(2, 11) == false);

    }

    @Test
    public void testGameMatrixIsFullandSingleValue() {
        GameMatrix board1 = new GameMatrix(5, 6);
        board1.setGamePieceValue(2, 3, "WHITE");
        board1.setGamePieceValue(1, 4, "BLACK");
        // Should be false since we only have 2 pieces, not a full board.
        assertTrue(board1.gameMatrixIsFull() == false);
        // Fills the board up with tokens. These tokens are all white.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                board1.setGamePieceValue(i, j, "WHITE");
            }
        }
        // Checks the board is full.
        assertTrue(board1.gameMatrixIsFull() == true);
        // We can now test the MatrixHasSingleValue() method since they are all
        // white.
        assertTrue(board1.gameMatrixHasSingleValue() == true);
        // Change it so one of them is black again.
        board1.setGamePieceValue(2, 3, "BLACK");
        // Makes sure the same statement is no longer true because they are not
        // all black.
        assertFalse(board1.gameMatrixHasSingleValue() == true);
        // Need to do it for empty as well.
        board1.setGamePieceValue(2, 3, "EMPTY");
        // It's true because all white + empty means the board still only has
        // white counters.
        assertTrue(board1.gameMatrixHasSingleValue() == true);

    }

}
