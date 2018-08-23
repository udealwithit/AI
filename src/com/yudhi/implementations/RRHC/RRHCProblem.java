package com.yudhi.implementations.RRHC;

import java.util.ArrayList;

import com.yudhi.elements.Problem;
import com.yudhi.implementations.RRHC.RRHCState;

public interface RRHCProblem extends Problem{
	
	public RRHCState[] getNeighbours(RRHCState state);

	public ArrayList<RRHCState> getBest(RRHCState[] states, RRHCHeuristic currentHeuristic);
	
	public RRHCState getInitialState();
	
	public RRHCState restart();
	
}
