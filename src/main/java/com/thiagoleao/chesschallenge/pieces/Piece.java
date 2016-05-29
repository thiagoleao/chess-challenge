package com.thiagoleao.chesschallenge.pieces;

public interface Piece {

	Integer getRow();

	Integer getColumn();

	boolean isAttackPosition(int column, int row);

	void setColumn(Integer column);

	void setRow(Integer row);
	
	String getOutputLetter();
	
	

}
