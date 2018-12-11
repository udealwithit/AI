package com.AI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProblemSolver {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = 0;
		ArrayList<Integer> board_start = new ArrayList<Integer>();
		ArrayList<Integer> board_final = new ArrayList<Integer>();
		
		ArrayList<Problem> closed = new ArrayList<Problem>();
		ArrayList<Problem> boundary = new ArrayList<Problem>();
		ArrayList<Problem> solutionSet = new ArrayList<Problem>();
		int i = 0;
		System.out.println("Enter Starting Position");
		while(i<9) {
			System.out.println("Enter tile number from 0-8 for location "+i+": ");
			num = Integer.parseInt(sc.nextLine());
			if(board_start.contains(num) || (num>8) || (num<0)) {
				continue;
			}
			else {
				board_start.add(num);
				i++;
			}
		}
		Problem p_start = new Problem(board_start,"Start state");
		
		i=0;
		System.out.println("Enter Final Position");
		while(i<9) {
			System.out.println("Enter tile number from 0-8 for location "+i+": ");
			num = Integer.parseInt(sc.nextLine());
			if(board_final.contains(num) || (num>8) || (num<0)) {
				continue;
			}
			else {
				board_final.add(num);
				i++;
			}
		}
		Problem p_final = new Problem(board_final,"Final state");
		
		p_start.display();
		System.out.println("\n");
		p_final.display();
		
		Problem temp = p_start;
		temp.calcF(p_final, -1);
		while(temp.h != 0){
			closed.add(temp);
			temp.moveUp();
			temp.moveDown();
			temp.moveLeft();
			temp.moveRight();
			
			for(Problem p : closed) {
				if((temp.pu!=null)&&(p.board.equals(temp.pu.board))) {
					//System.out.println("making up move null");
					temp.pu = null;
				}
				if((temp.pd!=null)&&(p.board.equals(temp.pd.board))) {
					//System.out.println("making down move null");
					temp.pd = null;
				}
				if((temp.pl!=null)&&(p.board.equals(temp.pl.board))) {
					//System.out.println("making left move null");
					temp.pl = null;
				}
				if((temp.pr!=null)&&(p.board.equals(temp.pr.board))) {
					//System.out.println("making right move null");
					temp.pr = null;
				}
			}
			
			if(temp.pu!=null)
				temp.pu.calcF(p_final, temp.g);
			if(temp.pd!=null)
				temp.pd.calcF(p_final, temp.g);
			if(temp.pl!=null)
				temp.pl.calcF(p_final, temp.g);
			if(temp.pr!=null)
				temp.pr.calcF(p_final, temp.g);
			
			if(temp.pu!=null)
				boundary.add(temp.pu);
			if(temp.pd!=null)
				boundary.add(temp.pd);
			if(temp.pl!=null)
				boundary.add(temp.pl);
			if(temp.pr!=null)
				boundary.add(temp.pr);
			
			Collections.sort(boundary);
			temp = boundary.get(0);
			boundary.remove(0);
		}
		
		while(temp!=null) {
			solutionSet.add(temp);
			temp = temp.parent;
		}
		
		System.out.println("\nThe solution is");
		int steps = solutionSet.size();
		for(i=steps-1; i>=0; i--) {
			solutionSet.get(i).display();
			System.out.print("\n");
		}
		
		sc.close();
	}
}
