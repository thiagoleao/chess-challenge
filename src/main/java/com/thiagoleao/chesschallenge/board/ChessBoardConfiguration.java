package com.thiagoleao.chesschallenge.board;

import java.util.HashMap;

import com.thiagoleao.chesschallenge.pieces.Piece;

public class ChessBoardConfiguration implements Cloneable {

	public static final int NULL = -1;
	private Integer heigth;
	private Integer width;
	private Integer length;
	private Integer attempt;
	
	private HashMap<Integer, Piece> piecesPosition;

	public ChessBoardConfiguration(Integer heigth, Integer width) {
		this.heigth = heigth;
		this.width = width;
		this.length = heigth * width;
	}
	
	@SuppressWarnings("unchecked")
	private ChessBoardConfiguration(Integer width, Integer lenght, int attempt, HashMap<Integer, Piece> piecesPosition) {
		this.width = width;
		this.attempt = attempt;
		this.piecesPosition = (HashMap<Integer, Piece>) piecesPosition.clone();
		this.length = lenght;
	}

	public Integer getLength() {
		return length;
	}

	public int alocateAPieceInAnAvaliablePosition(Piece piece, int _offset) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public ChessBoardConfiguration clone() {
		return new ChessBoardConfiguration(heigth, width, attempt ,piecesPosition);
	}

	public void removePiece(Piece piece) {
		// TODO Auto-generated method stub
		
	}
}
