package com.yudhi.algo.EightQueens;

import java.util.ArrayList;

import com.yudhi.implementations.RRHC.RRHCProblem;
import com.yudhi.implementations.RRHC.RRHCState;

public class EightQueensRRHC implements RRHCProblem {

	ArrayList<EightQueensState> exploredInitialStates = new ArrayList<>();
	
	@Override
	public RRHCState[] getNeighbours(RRHCState state) {
		EightQueensState s = (EightQueensState) state;
		EightQueensState[] neighbours = new EightQueensState[56];
		int[] arr1 = s.getArr();
		int location = 0;
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				int arr[] = new int[8];
				arr = arr1.clone();
				
				if(j==arr1[i]) {
					continue;
				}
				
				arr[i] = j;
				EightQueensState ns = new EightQueensState();
				ns.setArr(arr);
				neighbours[location] = ns;
				location++;
			}
		}
		return neighbours;
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
		EightQueensState state = new EightQueensState();
		
		//check if state has already been explored 
		while(true) {
			state = (EightQueensState) getInitialState();
			if(!contains(state)){
				break;
			}
		}
		
		exploredInitialStates.add(state);
		
		return state;
	}
	
	public boolean contains(EightQueensState state) {
		int[] arr1 = state.getArr();
		boolean explored = false; 
		for(EightQueensState s : exploredInitialStates) {
			explored = true;
			int[] arr = s.getArr();
			for(int i=0;i<8;i++) {
				if(arr[i]!=arr1[i]) {
					explored = false;
					break;
				}
			}
			
			if(explored) {
				return explored;
			}
		}
		return explored;
	}

}
