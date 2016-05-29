package com.thiagoleao.chesschallenge.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChessBoardConfigurationTest {

	private ChessBoardConfiguration configuration;
	
	@Before
	public void init() {
		configuration = new ChessBoardConfiguration(7, 7);
	}
	
	@Test
	public void testConstructor() {
		assertEquals(new Integer(7), configuration.getWidth());
		assertEquals(new Integer(49), configuration.getLength());
		assertEquals(new Integer(0), configuration.getAttempt());
		assertEquals(new Integer(0), configuration.getId());
	}

}
