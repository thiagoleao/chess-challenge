package com.thiagoleao.chesschallenge.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnightTest {

	private Knight knight = new Knight();
	
	@Test
	public void testOutputLetter() {
		assertEquals(new String("N"), knight.getOutputLetter());
	}
	
	@Test
	public void testIsAttackPosition_true() {
		knight.setColumn(0);
		knight.setRow(2);
		assertTrue(knight.isAttackPosition(2, 3));
	}

	@Test
	public void testIsAttackPosition_false() {
		assertFalse(knight.isAttackPosition(1, 1));
		
	}

}
