package com.thiagoleao.chesschallenge.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class RookTest implements PieceTest {

	private Rook rook = new Rook();
	
	@Test
	public void testOutputLetter() {
		assertEquals(new String("R"), rook.getOutputLetter());		
	}

	@Test
	public void testIsAttackPosition_true() {
		assertTrue(rook.isAttackPosition(-1, -1));
	}

	@Test
	public void testIsAttackPosition_false() {
		assertFalse(rook.isAttackPosition(0, 0));
	}

}
