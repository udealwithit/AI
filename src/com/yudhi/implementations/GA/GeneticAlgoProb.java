package com.yudhi.implementations.GA;

import com.yudhi.elements.Problem;

public interface GeneticAlgoProb extends Problem {

	public Population selection(GAHeuristic threshold, Population pop);
	
	public void crossover();
	
	public void mutation();
		
}
