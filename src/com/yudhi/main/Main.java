package com.yudhi.main;

import com.yudhi.algo.EightQueens.EightQueensHeuristic;
import com.yudhi.algo.EightQueens.EightQueensRRHC;
import com.yudhi.algo.EightQueens.EightQueensState;
import com.yudhi.implementations.RRHC.RRHCState;

public class Main {

	public static void main(String[] args) {
		int[] arr = {0,2,4,6,1,3,5,7};
		
		EightQueensState s = new EightQueensState();
		s.setArr(arr);
		EightQueensHeuristic h = (EightQueensHeuristic) s.getHeuristic();
		System.out.println(h.getValue());
		
		EightQueensRRHC rrhc = new EightQueensRRHC();
		RRHCState[] neighbours = rrhc.getNeighbours(s);
		
		for(RRHCState r : neighbours) {
			EightQueensState state = (EightQueensState)r;
			int[] arrays = state.getArr();
			System.out.print("[");
			for(int j=0;j<8;j++) {
				System.out.print(arrays[j]+", ");
			}
			System.out.print("]\n");
		}
	}
}
