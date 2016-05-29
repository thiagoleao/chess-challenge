package com.thiagoleao.chesschallenge.pieces;

/**
 * This interface represents a chess {@link Piece} and it declare all
 * shared methods
 * @author Thiago Leao
 *
 */
public interface Piece {

	Integer getRow();

	Integer getColumn();

	boolean isAttackPosition(int column, int row);

	void setColumn(Integer column);

	void setRow(Integer row);
	
	String getOutputLetter();
	
	

}
