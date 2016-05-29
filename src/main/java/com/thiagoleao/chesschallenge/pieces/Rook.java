package com.thiagoleao.chesschallenge.pieces;

public class Rook extends AbstractPiece {

	private static final String OUTPUT_LETTER = "R";

	public boolean isAttackPosition(int column, int row) {
		return getRow() == row || getColumn() == column;
	}

	public String getOutputLetter() {
		return OUTPUT_LETTER;
	}

}
