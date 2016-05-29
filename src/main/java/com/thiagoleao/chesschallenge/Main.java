package com.thiagoleao.chesschallenge;

import java.io.PrintStream;
import java.util.Arrays;

import com.thiagoleao.chesschallenge.board.Board;
import com.thiagoleao.chesschallenge.pieces.Bishop;
import com.thiagoleao.chesschallenge.pieces.King;
import com.thiagoleao.chesschallenge.pieces.Knight;
import com.thiagoleao.chesschallenge.pieces.Queen;
import com.thiagoleao.chesschallenge.processor.Solution;
import com.thiagoleao.chesschallenge.processor.SolutionProcessor;

public class Main {

	public static void main(String[] args) {
		
		PrintStream out = System.out;
		
		out.println("==========================================================================");
		out.println("*                          CHESS CHALLENGE                               *");
		out.println("==========================================================================");
		out.println("							Author: Thiago Leao");
		out.println("							2016");
		
		//Board board = new Board(3,3);
		//Board board = new Board(4,4);
		Board board = new Board(7,7);
		
		//board.addKingList(Arrays.asList(new King(), new King())).addRookList(Arrays.asList(new Rook()));
		//board.addRookList(Arrays.asList(new Rook(), new Rook())).addKnightList(Arrays.asList(new Knight(), new Knight(), new Knight(), new Knight()));
		board.addKingList(Arrays.asList(new King(), new King())).addQueenList(Arrays.asList(new Queen(), new Queen())).addBishopList(Arrays.asList(new Bishop(), new Bishop())).addKnightList(Arrays.asList(new Knight()));
		 
		Solution solution = SolutionProcessor.findSolution(board);
		solution.printTotalUniqueConfigurations();
		solution.printElapsedTIme();
		solution.printChessBoards();
	
		out.println("==========================================================================");
	}
}
