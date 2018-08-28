package com.yudhi.algo.GAImpl;

import java.util.ArrayList;

public class Population {

	ArrayList<GAStateImpl> population = new ArrayList<>();

	public ArrayList<GAStateImpl> getPopulation() {
		return population;
	}

	public void setPopulation(ArrayList<GAStateImpl> population) {
		this.population = population;
	}
}
