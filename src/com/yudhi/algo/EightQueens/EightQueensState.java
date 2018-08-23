package com.yudhi.algo.EightQueens;

import com.yudhi.implementations.RRHC.RRHCHeuristic;
import com.yudhi.implementations.RRHC.RRHCState;

public class EightQueensState implements RRHCState {

	int[] arr;
	
	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public EightQueensState() {
		this.arr = new int[8];
		for(int i=0;i<8;i++) {
			arr[i] = 0;
		}
	}

	@Override
	public RRHCHeuristic getHeuristic() {
		int count = 0;
		
		for(int c=0;c<8;c++) {
			int r = arr[c];
			
			//search for queens in the same row
			for(int i=c+1;i<8;i++) {
				if(arr[i]==r){
					count++;
				}
			}
			
			//search for queens diagonally up
			for(int i=c+1, j=r-1;i<8 && j>-1;i++, j--) {
				if(arr[i]==j) {
					count++;
				}
			}
			
			//search for queens diagonally down
			for(int i=c+1, j=r+1;i<8 && j<8;i++, j++) {
				if(arr[i]==j) {
					count++;
				}
			}
		}
		
		return new EightQueensHeuristic(count);
	}

	public void display() {
		EightQueensHeuristic h = (EightQueensHeuristic)getHeuristic();
		int val = h.getValue();
		System.out.print("[");
		for(int i=0;i<8;i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.print("]---------"+val+"\n");
	}

}
