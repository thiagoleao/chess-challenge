package com.thiagoleao.chesschallenge.processor;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.thiagoleao.chesschallenge.board.Board;
import com.thiagoleao.chesschallenge.pieces.Bishop;
import com.thiagoleao.chesschallenge.pieces.King;
import com.thiagoleao.chesschallenge.pieces.Knight;
import com.thiagoleao.chesschallenge.pieces.Piece;
import com.thiagoleao.chesschallenge.pieces.Queen;
import com.thiagoleao.chesschallenge.pieces.Rook;

public class SolutionProcessorTest {

	
	@Test
	public void testFindSolutionWith_board3x3_2King_1Rook_sucess() {
		Solution solution = SolutionProcessor.findSolution(getBoard(3, 3, 
				Arrays.asList(new Rook(), new King(), new King())));
		assertEquals(4, solution.getUniqueConfigurations().size());
	}

	@Test
	public void testFindSolutionWith_board4x4_2Rook_4Knight_sucess() {
		Solution solution = SolutionProcessor.findSolution(getBoard(4, 4, 
				Arrays.asList(new Rook(), new Rook(), 
				new Knight(), new Knight(), 
				new Knight(), new Knight())));
		assertEquals(8, solution.getUniqueConfigurations().size());
	}

	@Test
	public void testFindSolutionWith_board7x7_2King_2Queen_2Bishop_1Knight_sucess() {
		Solution solution = SolutionProcessor.findSolution(getBoard(7, 7, 
				Arrays.asList(new King(), new King(), new Queen(), new Queen(), 
						new Bishop(), new Bishop(), new Knight())));
		assertEquals(0, solution.getUniqueConfigurations().size());
	}



	private Board getBoard(int heigth, int width, List<Piece> pieceList) {
		return new Board(heigth, width).addPieceList(pieceList);
	}

}
