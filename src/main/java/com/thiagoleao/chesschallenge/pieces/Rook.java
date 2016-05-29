package com.thiagoleao.chesschallenge.pieces;

/**
 * This class represents the {@link Piece} {@link Rook} for the chess game
 * @author Thiago Leao
 *
 */
public class Rook extends AbstractPiece {

	private static final String OUTPUT_LETTER = "R";

	public boolean isAttackPosition(int column, int row) {
		return getRow() == row || getColumn() == column;
	}

	public String getOutputLetter() {
		return OUTPUT_LETTER;
	}

}
