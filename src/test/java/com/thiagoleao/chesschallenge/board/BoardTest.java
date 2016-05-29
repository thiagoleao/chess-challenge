package com.thiagoleao.chesschallenge.board;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.thiagoleao.chesschallenge.pieces.Bishop;
import com.thiagoleao.chesschallenge.pieces.King;
import com.thiagoleao.chesschallenge.pieces.Knight;
import com.thiagoleao.chesschallenge.pieces.Queen;
import com.thiagoleao.chesschallenge.pieces.Rook;

public class BoardTest {

	private Board board;
	
	@Before
	public void init() {
		board = new Board(7, 7);
	}
	
	@Test
	public void testConstructor() {
		assertEquals(new Integer(7), board.getHeigth());
		assertEquals(new Integer(7), board.getWidth());
		assertNotNull(board.getPieceList());
	}
	
	@Test
	public void testAddKingList_sucess() {
		board.addKingList(Arrays.asList(new King(), new King(), new King()));
		assertEquals(3, board.getPieceList().size());
	}
	
	@Test
	public void testAddQueenList_sucess() {
		board.addQueenList(Arrays.asList(new Queen(), new Queen()));
		assertEquals(2, board.getPieceList().size());
	}
	
	@Test
	public void testAddBishopList_sucess() {
		board.addBishopList(Arrays.asList(new Bishop(), new Bishop(), new Bishop(), new Bishop(), new Bishop()));
		assertEquals(5, board.getPieceList().size());
	}
	
	@Test
	public void testAddRookList_sucess() {
		board.addRookList(Arrays.asList(new Rook()));
		assertEquals(1, board.getPieceList().size());
	}
	
	@Test
	public void testAddKnightList_sucess() {
		board.addKnightList(Arrays.asList(new Knight(), new Knight(), new Knight(), new Knight()));
		assertEquals(4, board.getPieceList().size());
	}

}
