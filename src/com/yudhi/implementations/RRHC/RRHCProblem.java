package com.yudhi.implementations.RRHC;

import com.yudhi.elements.Problem;
import com.yudhi.implementations.RRHC.RRHCState;

public interface RRHCProblem extends Problem{

	public RRHCState getMax(RRHCState[] states);
	
	public RRHCState getInitialState();
	
}
