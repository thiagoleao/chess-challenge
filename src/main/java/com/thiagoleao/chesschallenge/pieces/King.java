package com.thiagoleao.chesschallenge.pieces;

/**
 * This class represents the {@link Piece} {@link King} for the chess game
 * @author Thiago Leao
 *
 */
public class King extends AbstractPiece {

	private static final String OUTPUT_LETTER = "K";

	public boolean isAttackPosition(int column, int row) {
		if(Math.abs(getRow() - row) == 1 && Math.abs(getColumn() - column) == 1) {
			return true;
		}
		if((getRow() == row && Math.abs(getColumn() - column) == 1) || 
				(getColumn() == column && Math.abs(getRow() - row) == 1) ) {
			return true;
		}
		return false;
	}

	public String getOutputLetter() {
		return OUTPUT_LETTER;
	}

}
