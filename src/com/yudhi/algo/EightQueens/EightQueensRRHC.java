package com.yudhi.algo.EightQueens;

import java.util.ArrayList;

import com.yudhi.implementations.RRHC.RRHCProblem;
import com.yudhi.implementations.RRHC.RRHCState;

public class EightQueensRRHC implements RRHCProblem {

	ArrayList<EightQueensState> exploredInitialStates = new ArrayList<>();
	
	@Override
	public RRHCState[] getNeighbours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RRHCState getBest(RRHCState[] states) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RRHCState getInitialState() {
		int[] arr = new int[8];
		
		for(int i=0;i<8;i++) {
			arr[i] = (int)Math.random()*8;
		}
		EightQueensState s = new  EightQueensState();
		s.setArr(arr);
		return s;
	}

	@Override
	public RRHCState restart() {
		EightQueensState s = exploredInitialStates.get(0);
		
		//check if s has already been explored
		while(exploredInitialStates.contains(s)) {
			s = (EightQueensState) getInitialState();
		}
		exploredInitialStates.add(s);
		
		return s;
	}

}
