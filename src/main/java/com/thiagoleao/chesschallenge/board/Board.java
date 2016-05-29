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
	private List<Piece> pieceList;

	public Board(int heigth, int width) {
		this.heigth = heigth;
		this.width = width;
		this.pieceList = new ArrayList<Piece>();
	}
	
	public Board addKingList(List<King> kingList) {
		this.pieceList.addAll(kingList);
		return this;
	}
	
	public Board addQueenList(List<Queen> queenList) {
		this.pieceList.addAll(queenList);
		return this;
	}
	
	public Board addBishopList(List<Bishop> bishopList) {
		this.pieceList.addAll(bishopList);
		return this;
	}
	
	public Board addRookList(List<Rook> rookList) {
		this.pieceList.addAll(rookList);
		return this;
	}
	
	public Board addKnightList(List<Knight> knightList) {
		this.pieceList.addAll(knightList);
		return this;
	}
	
	public Board addPieceList(List<Piece> pieceList) {
		this.pieceList.addAll(pieceList);
		return this;
	}

	//GETTERS
	public Integer getHeigth() {
		return heigth;
	}
	
	public Integer getWidth() {
		return width;
	}
	
	public List<Piece> getPieceList() {
		return pieceList;
	}
	
	
	

}
