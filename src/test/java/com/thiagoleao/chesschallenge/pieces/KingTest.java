package com.thiagoleao.chesschallenge.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class KingTest implements PieceTest {

	private King king = new King();
	
	@Test
	public void testOutputLetter() {
		assertEquals(new String("K"), king.getOutputLetter());
	}
	
	@Test
	public void testIsAttackPosition_true() {
		assertTrue(king.isAttackPosition(0, 0));
	}

	@Test
	public void testIsAttackPosition_false() {
		assertFalse(king.isAttackPosition(1, 1));
		
	}

}
