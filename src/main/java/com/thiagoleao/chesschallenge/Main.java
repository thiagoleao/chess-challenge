package com.thiagoleao.chesschallenge;

import java.util.Arrays;

import com.thiagoleao.chesschallenge.board.Board;
import com.thiagoleao.chesschallenge.pieces.King;
import com.thiagoleao.chesschallenge.pieces.Rook;
import com.thiagoleao.chesschallenge.processor.Solution;
import com.thiagoleao.chesschallenge.processor.SolutionProcessor;

public class Main {

	public static void main(String[] args) {
		
		Board board = new Board(3,3);
		
		board.addKingList(Arrays.asList(new King(), new King())).addRookList(Arrays.asList(new Rook()));
		//board.addRook(Arrays.asList(new Rook(), new Rook())).addKnight(Arrays.asList(new Knight(), new Knight(), new Knight(), new Knight()));
		//board.addKing(Arrays.asList(new King(), new King())).addQueen(Arrays.asList(new Queen(), new Queen())).addBishop(Arrays.asList(new Bishop(), new Bishop())).addKnight(Arrays.asList(new Knight()));
		 
		Solution solution = SolutionProcessor.findSolution(board);
		
		System.out.println("Total unique configurations: "+solution.getUniqueConfigurations().size());	
	}
}
