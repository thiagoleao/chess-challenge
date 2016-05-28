package com.thiagoleao.chesschallenge.board;

import java.util.ArrayList;
import java.util.List;

import com.thiagoleao.chesschallenge.pieces.Bishop;
import com.thiagoleao.chesschallenge.pieces.King;
import com.thiagoleao.chesschallenge.pieces.Knight;
import com.thiagoleao.chesschallenge.pieces.Piece;
import com.thiagoleao.chesschallenge.pieces.Queen;
import com.thiagoleao.chesschallenge.pieces.Rook;

public class Board {
	
	private Integer heigth;
	private Integer width;
	private List<Piece> pieces;

	public Board(int heigth, int width) {
		this.heigth = heigth;
		this.width = width;
		this.pieces = new ArrayList<Piece>();
	}
	
	public Board addKing(List<King> kingList) {
		this.pieces.addAll(kingList);
		return this;
	}
	
	public Board addQueen(List<Queen> queenList) {
		this.pieces.addAll(queenList);
		return this;
	}
	
	public Board addBishop(List<Bishop> bishopList) {
		this.pieces.addAll(bishopList);
		return this;
	}
	
	public Board addRook(List<Rook> rookList) {
		this.pieces.addAll(rookList);
		return this;
	}
	
	public Board addKnight(List<Knight> knightList) {
		this.pieces.addAll(knightList);
		return this;
	}

	//GETTERS
	public Integer getHeigth() {
		return heigth;
	}
	
	public Integer getWidth() {
		return width;
	}
	
	public List<Piece> getPieces() {
		return pieces;
	}
	
	
	

}
