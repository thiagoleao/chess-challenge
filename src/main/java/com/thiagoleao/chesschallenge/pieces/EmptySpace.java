package com.thiagoleao.chesschallenge.pieces;

/**
 * This class represents the {@link EmptySpace} for the chess board
 * @author Thiago Leao
 *
 */
public class EmptySpace extends AbstractPiece {

	private static final String OUTPUT_LETTER = " ";

	public boolean isAttackPosition(int column, int row) {
		return false;
	}

	public String getOutputLetter() {
		return OUTPUT_LETTER;
	}
}
