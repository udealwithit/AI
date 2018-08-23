package com.yudhi.main;

import java.util.ArrayList;

import com.yudhi.algo.EightQueens.EightQueensHeuristic;
import com.yudhi.algo.EightQueens.EightQueensRRHC;
import com.yudhi.algo.EightQueens.EightQueensState;
import com.yudhi.implementations.RRHC.RRHCState;

public class Main {

	public static void main(String[] args) {
		EightQueensRRHC rrhc = new EightQueensRRHC();
		for(int i=0; i<4; i++) {
			System.out.println("Restart No:"+i);
			EightQueensState state = (EightQueensState)rrhc.restart();
			System.out.println("---Starting state---");
			state.display();
			EightQueensState nextState = state;
			while(true) {
				ArrayList<RRHCState> bestStates = rrhc.getBest(rrhc.getNeighbours(nextState), nextState.getHeuristic());
				if(bestStates.size()==0) {
					break;
				}
				if(bestStates.size()>1) {
					int random = (int)((Math.random())*bestStates.size());
					nextState = (EightQueensState)bestStates.get(random);
				}
				else {
					nextState = (EightQueensState)bestStates.get(0);
				}
			}
			System.out.println("---Final state---");
			nextState.display();
			System.out.println("\n\n");
		}
	}
}
