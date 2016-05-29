package com.thiagoleao.chesschallenge.pieces;

public abstract class AbstractPiece implements Piece {

	private Integer row = -1;
	private Integer column = -1;
	
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	public Integer getColumn() {
		return column;
	}
	public void setColumn(Integer column) {
		this.column = column;
	}
	
	@Override
	public String toString() {
		return getOutputLetter();
	}
	
	@Override
	public boolean equals(Object piece) {
		if(piece == null){
			return false;
		}
		return getOutputLetter().equals(((Piece)piece).getOutputLetter());
	}
	
	@Override
	public int hashCode() {
		return getOutputLetter().charAt(0);
	}
	
	
	
	
	
}
