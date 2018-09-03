package com.yudhi.implementations.GA;

import com.yudhi.elements.Problem;

public interface GeneticAlgoProb extends Problem {

	public Population selection(GAHeuristic threshold, Population pop);
	
	public GAState crossover(GAState s1, GAState s2);
	
	public void mutation(double probability, GAState s);
		
}
