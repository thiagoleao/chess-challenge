package com.thiagoleao.chesschallenge.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class BishopTest implements PieceTest {

	private Bishop bishop = new Bishop();
	
	@Test
	public void testOutputLetter() {
		assertEquals(new String("B"), bishop.getOutputLetter());
	}
	
	@Test
	public void testIsAttackPosition_true() {
		assertTrue(bishop.isAttackPosition(0, 0));
	}

	@Test
	public void testIsAttackPosition_false() {
		assertFalse(bishop.isAttackPosition(-1, 0));
		
	}

}
