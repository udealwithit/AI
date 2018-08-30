package com.yudhi.algo.GAImpl;

import java.util.ArrayList;
import java.util.Collections;

import com.yudhi.implementations.GA.GAHeuristic;
import com.yudhi.implementations.GA.GAState;
import com.yudhi.implementations.GA.GeneticAlgoProb;
import com.yudhi.implementations.GA.Population;

public class GAProbImpl implements GeneticAlgoProb {

	@Override
	public Population selection(GAHeuristic threshold, Population pop) {
		ArrayList<GAState> selected_pop = new ArrayList<>();
		PopulationImpl popImpl = (PopulationImpl) pop;
		ArrayList<GAState> total_pop = popImpl.getPopulation();
		
		GAHeuristicImpl thresholdImpl = (GAHeuristicImpl) threshold;
		int thresholdValue = thresholdImpl.getValue();
		
		//loop to find all states greater than threshold
		for(GAState g : total_pop) {
			GAStateImpl gImpl = (GAStateImpl) g;
			GAHeuristicImpl stateHeuristic = (GAHeuristicImpl) gImpl.getHeuristic();
			if(stateHeuristic.getValue() >= thresholdValue) {
				selected_pop.add(gImpl);
			}
		}
		
		PopulationImpl newPop = new PopulationImpl();
		newPop.setPopulation(selected_pop);
		return newPop;
	}

	@Override
	public void crossover() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mutation() {
		// TODO Auto-generated method stub

	}

}
