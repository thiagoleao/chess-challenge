package com.thiagoleao.chesschallenge.pieces;

/**
 * This class represents the {@link Piece} {@link Bishop} for the chess game
 * @author Thiago Leao
 *
 */
public class Bishop extends AbstractPiece {
	
	private static final String OUTPUT_LETTER = "B";

	public boolean isAttackPosition(int column, int row) {
		return Math.abs(getColumn() - column) == Math.abs(getRow() - row);
	}

	public String getOutputLetter() {
		return OUTPUT_LETTER;
	}

}
