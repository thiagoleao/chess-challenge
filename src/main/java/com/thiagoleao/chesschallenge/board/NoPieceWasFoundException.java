package com.thiagoleao.chesschallenge.board;

public class NoPieceWasFoundException extends RuntimeException {

	private static final long serialVersionUID = -758946175344778239L;

	@Override
	public String getMessage() {
		return "No piece was found!";
	}
	
}
