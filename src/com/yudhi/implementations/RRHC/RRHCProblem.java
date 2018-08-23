package com.yudhi.implementations.RRHC;

import com.yudhi.elements.Problem;
import com.yudhi.implementations.RRHC.RRHCState;

public interface RRHCProblem extends Problem{
	
	public RRHCState[] getNeighbours(RRHCState state);

	public RRHCState getBest(RRHCState[] states);
	
	public RRHCState getInitialState();
	
	public RRHCState restart();
	
}
