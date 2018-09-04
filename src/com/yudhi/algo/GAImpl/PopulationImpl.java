package com.yudhi.algo.GAImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.yudhi.implementations.GA.GAState;
import com.yudhi.implementations.GA.Population;

public class PopulationImpl implements Population{

	ArrayList<GAState> population = new ArrayList<>();

	public ArrayList<GAState> getPopulation() {
		return population;
	}

	public void setPopulation(ArrayList<GAState> population) {
		this.population = population;
	}
	
	public void display() {
		for(GAState g : population) {
			GAStateImpl gI = (GAStateImpl)g;
			System.out.println(gI.gene);
		}
	}
}
