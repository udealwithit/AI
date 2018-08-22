package com.yudhi.main;

import com.yudhi.algo.EightQueens.EightQueensHeuristic;
import com.yudhi.algo.EightQueens.EightQueensState;

public class Main {

	public static void main(String[] args) {
		int[] arr = {0,2,4,6,1,3,5,7};
		
		EightQueensState s = new EightQueensState();
		s.setArr(arr);
		EightQueensHeuristic h = (EightQueensHeuristic) s.getHeuristic();
		System.out.println(h.getValue());
	}
}
