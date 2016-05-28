package com.thiagoleao.chesschallenge.processor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.thiagoleao.chesschallenge.board.Board;
import com.thiagoleao.chesschallenge.board.ChessBoardConfiguration;
import com.thiagoleao.chesschallenge.pieces.Piece;

/**
 * 
 * Class responsible for the magic, to find the solution to the challenge
 * 
 * @author Thiago Leao
 *
 */
public class SolutionProcessor {

	/**
	 * Process a chess {@link Board} to find all unique configurations 
	 * for the set of {@link Piece}
	 * @param board
	 * @return a solution filled with the process results
	 */
	public static Solution findSolution(Board board) {
		Solution solution = new Solution();
		
		Set<List<Piece>> shifts = new HashSet<List<Piece>>();
		
		recursiveShifts(shifts, new ArrayList<Piece>(), board.getPieces());
		
		shifts.forEach(shift -> { 
				ChessBoardConfiguration configuration = new ChessBoardConfiguration(board.getHeigth(), board.getWidth());
				fillBoardConfigurationWithPieces(configuration, shift, solution, 0, 0);	
				});
		
		
		return solution;
	}

	/**
	 * Fill a {@link ChessBoardConfiguration} with pieces on all possible positions
	 * @param configuration
	 * @param shift
	 * @param solution
	 */
	//TODO needs refactor
	private static void fillBoardConfigurationWithPieces(ChessBoardConfiguration configuration, List<Piece> pieces,
			Solution solution, int index, int offset) {
		if(index == pieces.size()) {
			solution.addConfiguration(configuration);
			return;
		}
		
		Piece piece = pieces.get(index);
		int _offset = offset;
		
		while(_offset < configuration.getLength()) {
			int piecePosition = configuration.alocateAPieceInAnAvaliablePosition(piece, _offset);
			if(piecePosition == ChessBoardConfiguration.NULL) {
				break;
			} else {
				fillBoardConfigurationWithPieces(configuration.clone(), pieces, solution, index + 1, piecePosition +1);
				configuration.removePiece(piece);
			}
		}
	}
	/**
	 * Algorithm responsible to execute shifts between pieces to find configurations
	 * @param shifts
	 * @param gathering
	 * @param partition
	 */
	private static void recursiveShifts(Set<List<Piece>> shifts, List<Piece> gathering, List<Piece> partition) {
		int x = partition.size();
		
		if(x == 0) {
			shifts.add(partition);
		} else {
			for(int i = 0; i < x; i++) {
				List<Piece> _gathering = new ArrayList<Piece>(gathering);
				List<Piece> _partition = new ArrayList<Piece>(partition);
			
				_gathering.add(_partition.remove(i));
				
				recursiveShifts(shifts, _gathering, _partition);
			}
		}
		
	}

}
