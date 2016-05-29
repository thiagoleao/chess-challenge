package com.thiagoleao.chesschallenge.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.thiagoleao.chesschallenge.pieces.King;
import com.thiagoleao.chesschallenge.pieces.Piece;

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
	
	@Test
	public void testAlocateAPieceInAnAvaliablePosition_sucess() {
		Piece piece = new King(); 
		int positionAlocated = configuration.alocateAPieceInAnAvaliablePosition(piece);
		assertEquals(0, positionAlocated);
	}
	
	@Test
	public void testRemovePieceFromAPosition_sucess() {
		Piece piece = new King();
		configuration.alocateAPieceInAnAvaliablePosition(piece);
		configuration.removePiece(piece);
	}

	@Test(expected = NoPieceWasFoundException.class)
	public void testRemovePieceFromAPosition_error() {
		Piece piece = new King();
		configuration.removePiece(piece);
	}
}
