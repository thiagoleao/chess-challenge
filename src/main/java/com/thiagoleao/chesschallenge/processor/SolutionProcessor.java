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
 * Class responsible for the magic, to find the solution for the challenge
 * @author Thiago Leao
 *
 */
public class SolutionProcessor {

	/**
	 * Process a chess {@link Board} to find all unique configurations 
	 * for the set of {@link Piece} inputed
	 * @param board
	 * @return a solution for the chess challenge
	 */
	public static Solution findSolution(Board board) {
		long start = System.currentTimeMillis();
		
		Solution solution = new Solution();
		
		Set<List<Piece>> shifts = new HashSet<List<Piece>>();
		
		recursiveShifts(shifts, new ArrayList<Piece>(), board.getPieceList());
		shifts.forEach(shift -> {  
				ChessBoardConfiguration configuration = new ChessBoardConfiguration(board.getHeigth(), board.getWidth());
				findConfigurations(configuration, shift, solution, 0, 0);
		});
		
		long stop = System.currentTimeMillis();
		
		solution.setElapsedTime(stop - start);
		
		return solution;
	}

	/**
	 * Fill {@link ChessBoardConfiguration} object with pieces on all possible positions
	 * @param configuration
	 * @param shift
	 * @param solution
	 */
	private static boolean findConfigurations(ChessBoardConfiguration configuration, List<Piece> pieces,
			Solution solution, int index, int startPosition) {
		if(index == pieces.size()) {
			solution.addConfiguration(configuration);
			return true;
		} else {
		
			Piece piece = pieces.get(index);
			int position = startPosition;
			
			while(position < configuration.getLength()) {
				int piecePosition = configuration.alocateAPieceInAnAvaliablePosition(piece, position);
				if(piecePosition == ChessBoardConfiguration.NULL) {
					break;
				} else {
					findConfigurations(configuration.clone(), pieces, solution, index + 1, piecePosition +1);
					configuration.removePiece(piece);
					position = piecePosition + 1;
				}
			}
			return false;
		}
	}
	/**
	 * Algorithm responsible to execute shifts between pieces in a chess board
	 * @param shifts
	 * @param gathering
	 * @param partition
	 */
	private static void recursiveShifts(Set<List<Piece>> shifts, 
										List<Piece> gathering, 
										List<Piece> partition) {
		int x = partition.size();
		//Overwritten equals method of Piece to keep no repeated elements in the set 
		if(x == 0) {
			shifts.add(gathering);
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
