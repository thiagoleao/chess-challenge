package com.thiagoleao.chesschallenge.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmptySpaceTest implements PieceTest {

	private EmptySpace emptySpace = new EmptySpace();
	
	@Test
	public void testOutputLetter() {
		assertEquals(new String(" "), emptySpace.getOutputLetter());		
	}

	@Test
	public void testIsAttackPosition_true() {
		//not applicable
	}

	@Test
	public void testIsAttackPosition_false() {
		assertFalse(emptySpace.isAttackPosition(0, 0));		
	}

}
