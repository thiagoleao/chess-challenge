package com.thiagoleao.chesschallenge.processor;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import com.thiagoleao.chesschallenge.board.ChessBoardConfiguration;

/**
 * This class represents the solution for the challenge
 * @author Thiago Leão
 *
 */
public class Solution {
	
	private Integer attempts;
	private Integer nonUniqueConfigurations;
	private PrintStream output;
	private long elapsedTime;
	

	private Map<Integer, ChessBoardConfiguration> uniqueConfigurations;
	
	public Solution() {
		init();
	}

	public Map<Integer, ChessBoardConfiguration> getUniqueConfigurations() {
		return uniqueConfigurations;
	}
	
	public Integer getAttempts() {
		return attempts;
	}

	public Integer getNonUniqueConfigurations() {
		return nonUniqueConfigurations;
	}
	
	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	
	public void addConfiguration(ChessBoardConfiguration configuration) {
		attempts++;
		configuration.setAttempt(attempts);
		Integer id = (Integer) configuration.getId();
		ChessBoardConfiguration preceding = uniqueConfigurations.get(id);
		
		if(preceding == null) {
			uniqueConfigurations.put(id, configuration);
		} else {
			nonUniqueConfigurations++;
		}
	}
	
	public void printTotalUniqueConfigurations() {
		output.println("Total unique configurations: "+uniqueConfigurations.size());
	}
	
	public void printElapsedTIme() {
		output.println("Elapsed time: " + (double) elapsedTime / 1000 +" seconds");
	}

	public void printChessBoards() {
		uniqueConfigurations.values()
		.forEach(config -> {output.println(config.boardConfigurationToString());});
	}

	private void init() {
		this.uniqueConfigurations = new HashMap<>();
		this.nonUniqueConfigurations = new Integer(0);
		this.attempts = new Integer(0);
		this.output = System.out;
	}
}
