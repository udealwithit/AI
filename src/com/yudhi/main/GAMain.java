package com.yudhi.main;

import java.util.ArrayList;

import com.yudhi.algo.GAImpl.GAHeuristicImpl;
import com.yudhi.algo.GAImpl.GAProbImpl;
import com.yudhi.algo.GAImpl.GAStateImpl;
import com.yudhi.algo.GAImpl.PopulationImpl;
import com.yudhi.implementations.GA.GAHeuristic;
import com.yudhi.implementations.GA.GAState;
import com.yudhi.implementations.GA.Population;

public class GAMain {

	public static void main(String[] args) {
		
		PopulationImpl population = generatePopulation(10,10);
		
		System.out.println("------Population------");
		population.display();
		System.out.println("------Population------");
		GAProbImpl ga = new GAProbImpl();
		
		GAHeuristicImpl threshold = new GAHeuristicImpl(30);
		int gen=0;
		
		while(gen<10) {
			PopulationImpl newPopulation = (PopulationImpl)ga.selection(threshold, population);
			
			ArrayList<GAState> newPop = newPopulation.getPopulation();
			
			GAStateImpl[] selectedStates = new GAStateImpl[2];
			int selected = 0;
			while(selected<2) {
				for(int i=0; i<newPop.size(); i++) {
					GAStateImpl gI = (GAStateImpl)newPop.get(i);
					GAHeuristicImpl h = (GAHeuristicImpl)gI.getHeuristic();
					int random = (int)(Math.random()*100);
					if(random<h.getValue()) {
						selectedStates[selected] = gI;
						selected++;
					}
					if(selected==2) {
						break;
					}
				}
			}
					
			GAStateImpl child = (GAStateImpl)ga.crossover(selectedStates[0], selectedStates[1]);
			System.out.println("\nGeneration----"+gen);
			System.out.println(child.getGene());
			newPop = population.getPopulation();
			newPop.add(child);
			population.setPopulation(newPop);
			gen++;
			threshold.setValue(threshold.getValue()+5);
		}
		
	}
	
	public static PopulationImpl generatePopulation(int size, int geneLength) {
		PopulationImpl pop = new PopulationImpl();
		ArrayList<GAState> poparr = new ArrayList<>();
		for(int i=0;i<size;i++) {
			String gene = new String("");
			for(int j=0;j<geneLength;j++) {
				int geneCell = (int)(Math.random()*2);
				gene += geneCell;
			}
			GAStateImpl gaState = new GAStateImpl();
			gaState.setGene(gene);
			poparr.add(gaState);
		}
		pop.setPopulation(poparr);
		return pop;
	}
	
}
