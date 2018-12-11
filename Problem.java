package com.AI;

import java.util.ArrayList;

public class Problem implements Comparable<Problem>{
	
	ArrayList<Integer> board = new ArrayList<Integer>();
	int loc0;
	int g;
	int h;
	int f;
	String move;
	Problem pu,pd,pl,pr,parent;
	
	public Problem(ArrayList<Integer> board, String str) {
		parent = null;
		this.board = board;
		loc0 = board.indexOf(0);
		this.move = str;
	}
	
	public void calcF(Problem p_final,int steps){
		if(this == null)
			return;
		int j = 0;
		for(int i=1; i<9; i++) {
			int l1 = p_final.board.indexOf(i);
			int l2 = this.board.indexOf(i);
			int r1 = l1/3;
			int r2 = l2/3;
			int c1 = l1%3;
			int c2 = l2%3;
			
			j += Math.abs(r1-r2)+Math.abs(c1-c2);
		}
		this.h = j;
		this.g = steps+1;
		this.f = this.g+this.h;
	}
	
	public void moveUp() {
		ArrayList<Integer> up = new ArrayList<Integer>(this.board);
		if(this.loc0/3==0) {
			this.pu = null;
			return;
		}
		int temp = up.get(this.loc0-3);
		up.set(this.loc0-3, 0);
		up.set(this.loc0, temp);
		this.pu = new Problem(up,"move up");
		this.pu.parent = this;
	}
	
	public void moveDown() {
		ArrayList<Integer> down = new ArrayList<Integer>(this.board);
		if(this.loc0/3==2) {
			this.pd = null;
			return;
		}
		int temp = down.get(this.loc0+3);
		down.set(this.loc0+3, 0);
		down.set(this.loc0, temp);
		this.pd = new Problem(down,"move down");
		this.pd.parent = this;
	}
	
	public void moveLeft() {
		ArrayList<Integer> left = new ArrayList<Integer>(this.board);
		if(this.loc0%3==0) {
			this.pl = null;
			return;
		}
		int temp = left.get(this.loc0-1);
		left.set(this.loc0-1, 0);
		left.set(this.loc0, temp);
		this.pl = new Problem(left,"move left");
		this.pl.parent = this;
	}
	
	public void moveRight() {
		ArrayList<Integer> right = new ArrayList<Integer>(this.board);
		if(this.loc0%3==2) {
			this.pr = null;
			return;
		}
		int temp = right.get(this.loc0+1);
		right.set(this.loc0+1, 0);
		right.set(this.loc0, temp);
		this.pr = new Problem(right,"move right");
		this.pr.parent = this;
	}
	
	public void display() {
		int cnt = 0;
		System.out.println(this.move);
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print("|"+board.get(cnt));
				cnt++;
			}
			System.out.print("|\n");
		}
	}

	@Override
	public int compareTo(Problem o) {
		Integer f_n1 = new Integer(this.f);
		Integer f_n2 = new Integer(o.f);
		return f_n1.compareTo(f_n2);
	}
	

}
