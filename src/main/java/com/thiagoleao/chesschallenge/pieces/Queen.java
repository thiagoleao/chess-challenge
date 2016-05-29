package com.thiagoleao.chesschallenge.pieces;

public class Queen extends AbstractPiece {
	
	private static final String OUTPUT_LETTER = "Q";

	public boolean isAttackPosition(int column, int row) {
		if(Math.abs(getRow() - row) == Math.abs(getColumn() - column)) {
			return true;
		}
		if(getRow() == row || getColumn() == column) {
			return true;
		}
		return false;
	}

	public String getOutputLetter() {
		return OUTPUT_LETTER;
	}
}
