package com.yudhi.algo.GAImpl;

import java.util.ArrayList;

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
	public GAState crossover(GAState s1, GAState s2) {
		GAStateImpl state1 = (GAStateImpl)s1;
		GAStateImpl state2 = (GAStateImpl)s2;
		GAStateImpl child1 = new GAStateImpl();
		GAStateImpl child2 = new GAStateImpl();
		
		String gene1 = state1.getGene();
		String gene2 = state2.getGene();
		
		int random = (int)(Math.random()*gene1.length());
		String childGene1 = gene1.substring(0, random) + gene2.substring(random, gene2.length());
		String childGene2 = gene2.substring(0, random) + gene1.substring(random, gene2.length());
		
		child1.setGene(childGene1);
		child2.setGene(childGene2);
		
		GAHeuristicImpl h1 = (GAHeuristicImpl)child1.getHeuristic();
		GAHeuristicImpl h2 = (GAHeuristicImpl)child2.getHeuristic();
		
		if(h1.getValue()>h2.getValue()) {
			return child1;
		}
		return child2;
	}

	@Override
	public void mutation(double probability, GAState s) {
		double val = Math.random()*100;
		
		if(val<probability) {
			GAStateImpl s1 = (GAStateImpl)s;
			String gene = s1.getGene();
			
			int pos = (int)(Math.random()*gene.length());
			String newGene = "";
			
			for(int i=0;i<gene.length();i++) {
				if(i==pos) {
					if(gene.charAt(i)=='0') {
						newGene += '1';
					}
					else {
						newGene += '0';
					}
				}
				else
				{
					newGene += gene.charAt(i);
				}
			}
			s1.setGene(newGene);
		}
	}

}
