package com.thiagoleao.chesschallenge.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueenTest {

	private Queen queen = new Queen();
	
	@Test
	public void testOutputLetter() {
		assertEquals(new String("Q"), queen.getOutputLetter());
	}
	
	@Test
	public void testIsAttackPosition_true() {
		assertTrue(queen.isAttackPosition(0, 0));
	}

	@Test
	public void testIsAttackPosition_false() {
		assertFalse(queen.isAttackPosition(3, 0));
		
	}

}
