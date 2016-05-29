package com.thiagoleao.chesschallenge.processor;

import java.util.HashMap;
import java.util.Map;

import com.thiagoleao.chesschallenge.board.ChessBoardConfiguration;

public class Solution {
	
	private Integer attempts;
	private Integer nonUniqueConfigurations;
	

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
	
	private void init() {
		this.uniqueConfigurations = new HashMap<>();
		this.nonUniqueConfigurations = new Integer(0);
		this.attempts = new Integer(0);
	}
}
