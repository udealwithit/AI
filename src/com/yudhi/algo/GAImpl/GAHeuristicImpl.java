package com.yudhi.algo.GAImpl;

import com.yudhi.implementations.GA.GAHeuristic;

public class GAHeuristicImpl implements GAHeuristic{

	int value;

	public GAHeuristicImpl(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
