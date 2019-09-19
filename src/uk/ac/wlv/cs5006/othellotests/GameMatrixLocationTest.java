package uk.ac.wlv.cs5006.othellotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import uk.ac.wlv.cs5006.othello.GameMatrixLocation;

class GameMatrixLocationTest {

	@Test
	public void testDefaultInvalid() {
		// Set up the default construct
		GameMatrixLocation location1 = new GameMatrixLocation();
		// It should be true as a empty construct = -1 -1, invalid location
		assertTrue(location1.isInvalid() == true);
	}

	@Test
	public void testDefaultConstructor() {
		GameMatrixLocation gMatrixLocation = new GameMatrixLocation();
		assertEquals(-1, gMatrixLocation.getRow());
		assertEquals(-1, gMatrixLocation.getCol());
	}

	@Test
	public void testParameterisedConstructor() {
		GameMatrixLocation gMatrixLocation = new GameMatrixLocation(4, 4);
		assertEquals(4, gMatrixLocation.getRow());
		assertEquals(4, gMatrixLocation.getCol());
	}

	@Test
	public void testInvalidRowCol() {
		GameMatrixLocation gMatrixLocation = new GameMatrixLocation(-1, -1);
		assertTrue(gMatrixLocation.isInvalid());
	}

	@Test
	public void testParamConstructorAndGetSet() {
		// sets up the constructors
		GameMatrixLocation location1 = new GameMatrixLocation(3, 4);
		// Makes sure it's valid + makes sure the false route has been tested.
		assertTrue(location1.isInvalid() == false);

		// Creates more locations.
		GameMatrixLocation location2 = new GameMatrixLocation(2, 1);
		GameMatrixLocation location3 = new GameMatrixLocation(1, 6);
		// Tests the constructor and the getter
		assertTrue(location1.getCol() == 4);
		assertTrue(location2.getCol() == 1);
		assertTrue(location3.getRow() == 1);
	}

	@Test
	public void testGettersAndSetters() {
		GameMatrixLocation location1 = new GameMatrixLocation(1, 6);
		location1.setRow(2);
		assertFalse(location1.getRow() == 1);
		assertTrue(location1.getRow() == 2);

		location1.setCol(4);
		assertFalse(location1.getCol() == 6);
		assertTrue(location1.getCol() == 4);
	}
	
	@Test
    public void testSetInvalid() {
        GameMatrixLocation location1 = new GameMatrixLocation(1, 6);
        location1.setInvalid();
        assertTrue(location1.getRow() == -1);
        assertTrue(location1.getCol() == -1);
    }

	@Test
	public void testValidRowCol() {
		GameMatrixLocation gMatrixLocation = new GameMatrixLocation(4, 4);
		assertFalse(gMatrixLocation.isInvalid());
	}

	@Test
	public void testValidRow() {
		GameMatrixLocation gMatrixLocation = new GameMatrixLocation(-1, 4);
		assertTrue(gMatrixLocation.isInvalid());
	}

	@Test
	public void testValidCol() {
		GameMatrixLocation gMatrixLocation = new GameMatrixLocation(4, -1);
		assertTrue(gMatrixLocation.isInvalid());
	}

	@Test
	public void testSetRow() {
		GameMatrixLocation gMatrixLocation = new GameMatrixLocation();
		gMatrixLocation.setRow(4);
		assertEquals(4, gMatrixLocation.getRow());
	}

	@Test
	public void testSetCol() {
		GameMatrixLocation gMatrixLocation = new GameMatrixLocation();
		gMatrixLocation.setCol(4);
		assertEquals(4, gMatrixLocation.getCol());
	}

}
