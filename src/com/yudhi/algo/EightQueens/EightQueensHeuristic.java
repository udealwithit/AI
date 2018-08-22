package com.yudhi.algo.EightQueens;

import com.yudhi.implementations.RRHC.RRHCHeuristic;

public class EightQueensHeuristic implements RRHCHeuristic {

	int value;

	public EightQueensHeuristic(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
