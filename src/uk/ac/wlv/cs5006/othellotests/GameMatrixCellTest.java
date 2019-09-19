package uk.ac.wlv.cs5006.othellotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import uk.ac.wlv.cs5006.othello.GameMatrixCell;
import uk.ac.wlv.cs5006.othello.GameMatrixLocation;
import uk.ac.wlv.cs5006.othello.GamePiece;


class GameMatrixCellTest {

	@Test
    public void testConstructor() {
        
        GamePiece token1 = new GamePiece("WHITE");
        GamePiece token2 = new GamePiece("BLACK");
        
        GameMatrixCell cellBlock1 = new GameMatrixCell(1, 2, token1);
        GameMatrixCell cellBlock2 = new GameMatrixCell(2, 5, token2);
        GameMatrixLocation gMatrixLocation = new GameMatrixLocation(4, 4);
        GameMatrixCell gMatrixCell = new GameMatrixCell(4, 4, token2);
        
        assertTrue(cellBlock1.getGamePiece() == token1);
        assertTrue(cellBlock2.getGamePiece() == token2);
        
        assertEquals(token2, gMatrixCell.getGamePiece());
        assertEquals(gMatrixLocation.getRow(), gMatrixCell.getLocation().getRow());
        assertEquals(gMatrixLocation.getCol(), gMatrixCell.getLocation().getCol());
        // Returns the locations column number for cell block 2
        assertTrue(cellBlock2.getLocation().getCol() == 5);
    }

    @Test
    public void testSetValue() {
        GamePiece gPiece = new GamePiece("BLACK");
        GameMatrixCell gMatrixCell = new GameMatrixCell(4, 4, gPiece);
        gMatrixCell.setValue("BLACK");
        assertEquals(gPiece.getValue(), gMatrixCell.getGamePiece().getValue());
    }

    @Test
    public void testSetGamePiece() {
        GamePiece gPiece = new GamePiece("BLACK");
        GameMatrixCell gMatrixCell = new GameMatrixCell(4, 4, gPiece);
        gMatrixCell.setGamePiece(gPiece);
        assertEquals(gPiece, gMatrixCell.getGamePiece());
    }
    
    @Test
    public void testSetters() {
        GamePiece token1 = new GamePiece("WHITE");
        GamePiece token2 = new GamePiece("BLACK");

        GameMatrixCell cellBlock1 = new GameMatrixCell(1, 2, token1);
        assertTrue(cellBlock1.getGamePiece().getValue() == "WHITE");
        cellBlock1.setGamePiece(token2);
        assertTrue(cellBlock1.getGamePiece().getValue() == "BLACK");

        cellBlock1.setValue("TEST VALUE");
        assertTrue(cellBlock1.getGamePiece().getValue() == "TEST VALUE");
    }
}
