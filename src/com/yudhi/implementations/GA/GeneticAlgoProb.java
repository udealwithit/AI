package com.yudhi.implementations.GA;

import com.yudhi.elements.Problem;

public interface GeneticAlgoProb extends Problem {

	public void selection(Population pop);
	
	public void crossover();
	
	public void mutation();
		
}
