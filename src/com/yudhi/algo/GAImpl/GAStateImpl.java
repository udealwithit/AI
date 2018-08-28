package com.yudhi.algo.GAImpl;

import com.yudhi.elements.Heuristic;
import com.yudhi.implementations.GA.GAState;

public class GAStateImpl implements GAState {

	String gene;
	
	public String getGene() {
		return gene;
	}

	public void setGene(String gene) {
		this.gene = gene;
	}

	//write your fitness function which assigns a value to the state
	@Override
	public Heuristic getHeuristic() {
		int count = 0;
		for (int i = 0; i < gene.length(); i++) {
			if(gene.charAt(i)=='1')
				count++;
		}
		int value = (count/gene.length())*100;
		return new GAHeuristicImpl(value);
	}

}
