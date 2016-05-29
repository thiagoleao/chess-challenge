package com.thiagoleao.chesschallenge.board;

import java.util.HashMap;

import com.thiagoleao.chesschallenge.pieces.EmptySpace;
import com.thiagoleao.chesschallenge.pieces.Piece;

/**
 * This class keeps all information about the configuration of 
 * pieces in the chess board.
 * @author Thiago Leao
 *
 */
public class ChessBoardConfiguration implements Cloneable {

	public static final int NULL = -1;
	public static final Piece EMPTY_SPACE;
	
	static {
		EMPTY_SPACE = new EmptySpace();
	}
	
	private Integer width;
	private Integer length;
	private Integer attempt;
	private Integer id;
	
	private HashMap<Integer, Piece> piecesPosition;

	public ChessBoardConfiguration(Integer heigth, Integer width) {
		this.width = width;
		this.attempt = 0;
		this.length = width * heigth;
		this.id = 0;
		this.piecesPosition = new HashMap<>(length);
	}
	
	@SuppressWarnings("unchecked")
	private ChessBoardConfiguration(Integer width, Integer lenght, int attempt, HashMap<Integer, Piece> piecesPosition) {
		this.width = width;
		this.attempt = attempt;
		this.piecesPosition = (HashMap<Integer, Piece>) piecesPosition.clone();
		this.length = lenght;
		this.id = 0;
	}

	//GETTERS AND SETTERS
	public Integer getLength() {
		return length;
	}
	
	public void setAttempt(Integer attempt) {
		this.attempt = attempt;
	}
	
	public Integer getAttempt() {
		return attempt;
	}
	
	public Integer getWidth() {
		return width;
	}
	
	public Integer getId() {
		Integer _id = this.id;
		if(_id == 0 && piecesPosition.size() > 0) {
			for(int i = 0;i < length;i++) {
				Piece piece = piecesPosition.get((Integer) i);
				if(piece == null) {
					piece = EMPTY_SPACE; 
				}
				_id = 31 * _id + (int) piece.getOutputLetter().charAt(0);
			}
			this.id = _id;
		}
		return _id;
	}

	public int alocateAPieceInAnAvaliablePosition(Piece piece) {
		return alocateAPieceInAnAvaliablePosition(piece, 0);
	}
	
	public int alocateAPieceInAnAvaliablePosition(Piece piece, int startPosition) {
		for(int position = startPosition; position < length; position++) {
			if(piecesPosition.get((Integer) position) == null) {
				int column = position % width; 
				int row = 	position / width;
				if(isPositionAvaliable(piece, column, row)) {
					alocatePieceAtPosition(piece, column, row);
					return position;
				}
			}
		}
		return NULL;
	}
	
	private void alocatePieceAtPosition(Piece piece, int column, int row) {
		piece.setColumn(column);
		piece.setRow(row);
		piecesPosition.put(row * width + column, piece);
		
	}

	private boolean isPositionAvaliable(Piece _piece, int column, int row) {
		for(Piece piece : piecesPosition.values()) {
			if(piece.isAttackPosition(column, row)) {
				return false;
			}
			_piece.setColumn(column);
			_piece.setRow(row);
			if(_piece.isAttackPosition(piece.getColumn(), piece.getRow())) {
				return false;
			}
		}
		return true;
	}
	
	public void removePiece(Piece piece) {
		int position = piece.getColumn() + width * piece.getRow();
		if(piecesPosition.remove((Integer) position) == null) {
			throw new NoPieceWasFoundException();
		}		
	}

	@Override
	public ChessBoardConfiguration clone() {
		return new ChessBoardConfiguration(width , length, attempt ,piecesPosition);
	}

	public String boardConfigurationToString() {
		StringBuilder builder = new StringBuilder();
		return printBoardHeaderAndFooter(builder)
				.printBoardBody(builder)
				.printBoardHeaderAndFooter(builder)
				.getText(builder);
	}

	private String getText(StringBuilder builder) {
		builder.append("*");
		return builder.toString();
	}

	private ChessBoardConfiguration printBoardBody(StringBuilder builder) {
		int height = length / width;
		int position = 0;
		for(int row = 0; row < height ; row++) {
			if(row != 0) {
				printBoardHeaderAndFooter(builder);
			}
			builder.append("*\n");
			for(int column = 0; column < width; column++) {
				builder.append("|");
				Piece piece = piecesPosition.get(Integer.valueOf(position++));
				if(piece == null) {
					piece = EMPTY_SPACE;
				}
				builder.append(piece.getOutputLetter());
			}
			builder.append("|\n");
		}
		return this;
	}
	private ChessBoardConfiguration printBoardHeaderAndFooter(StringBuilder builder) {
		for(int column = 0; column < width; column++) {
			builder.append("*");
			builder.append("-");
		}
		return this;
	}

}
