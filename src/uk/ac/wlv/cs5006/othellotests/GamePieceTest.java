package uk.ac.wlv.cs5006.othellotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import uk.ac.wlv.cs5006.othello.GamePiece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


class GamePieceTest {

    @Test
    public void testConstructor() {
        GamePiece gPiece = new GamePiece("BLACK");
        assertEquals("BLACK", gPiece.getValue());
    }

    @Test
    public void testGamePieceSet() {
        GamePiece gPiece = new GamePiece("BLACK");
        gPiece.setValue("WHITE");
        assertEquals("WHITE", gPiece.getValue());
    }

    @Test
    public void testEqualsTrue() {
        GamePiece gPiece = new GamePiece("BLACK");
        GamePiece gPieceOther = new GamePiece("BLACK");
        assertTrue(gPiece.equals(gPieceOther));
    }

    @Test
    public void testEqualsFalse() {
        GamePiece gPiece = new GamePiece("BLACK");
        GamePiece gPieceOther = new GamePiece("WHITE");
        assertFalse(gPiece.equals(gPieceOther));
    }
    
    @Test
    public void testWhiteConstructor() {
        GamePiece whitePiece = new GamePiece("WHITE");
        assertTrue(whitePiece.getValue() == "WHITE");
    }

    @Test
    public void testBlackConstructor() {
        GamePiece blackPiece = new GamePiece("BLACK");
        assertTrue(blackPiece.getValue() == "BLACK");
    }

    @Test
    public void testSetValue() {
        // We know the getValue works already from the above two tests.
        GamePiece piece = new GamePiece("BLACK");
        piece.setValue("WHITE");
        // If setValue works it will equal white now, is that the case?
        assertTrue(piece.getValue() == "WHITE");
        assertEquals(piece.getValue(), "WHITE");
        // and not black (is it false? if it is, good! it passes)
        assertFalse(piece.getValue() == "BLACK");
    }

    @Test
    public void testEquals() {
        GamePiece pieceOne = new GamePiece("BLACK");
        GamePiece pieceTwo = new GamePiece("BLACK");
        GamePiece pieceThree = new GamePiece("WHITE");

        assertTrue(pieceOne.equals(pieceTwo));
        assertTrue(pieceTwo.equals(pieceOne));
        assertFalse(pieceThree.equals(pieceOne));
    }

}
