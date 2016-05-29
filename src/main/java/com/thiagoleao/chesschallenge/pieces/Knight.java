package com.thiagoleao.chesschallenge.pieces;

public class Knight extends AbstractPiece {

	private static final String OUTPUT_LETTER = "N";

	public boolean isAttackPosition(int column, int row) {
		int _row = Math.abs(getRow() - row);
		int _column = Math.abs(getColumn() - column);
		return ((_row == 2 && _column == 1) || (_row == 1 && _column == 2));
	}

	public String getOutputLetter() {
		return OUTPUT_LETTER;
	}
}
