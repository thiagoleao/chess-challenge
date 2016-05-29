package com.thiagoleao.chesschallenge.pieces;

public class Knight extends AbstractPiece {

	private static final String OUTPUT_LETTER = "N";

	public boolean isAttackPosition(int column, int row) {
		return false;
	}

	public String getOutputLetter() {
		return OUTPUT_LETTER;
	}
}
