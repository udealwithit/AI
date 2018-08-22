package com.yudhi.implementations.RRHC;

import com.yudhi.elements.Problem;
import com.yudhi.implementations.RRHC.RRHCState;

public interface RRHCProblem extends Problem{
	
	public RRHCState[] getNeighbours();

	public RRHCState getMax(RRHCState[] states);
	
	public RRHCState getInitialState();
	
	public RRHCState restart();
	
}
