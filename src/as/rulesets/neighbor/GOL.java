package as.rulesets.neighbor;

import as.DAutm;
import as.rulesets.RuleSetNeighbor;

public class GOL extends RuleSetNeighbor<Integer> {
	
	@Override
	public Integer select(DAutm<Integer> sim, Object[][] neighbors) {
		int curVal = (Integer) neighbors[1][1];
		
		int neighborVals = 0;
		neighborVals += (Integer) neighbors[0][0];
		neighborVals += (Integer) neighbors[0][1];
		neighborVals += (Integer) neighbors[0][2];
		neighborVals += (Integer) neighbors[1][0];
		neighborVals += (Integer) neighbors[1][2];
		neighborVals += (Integer) neighbors[2][0];
		neighborVals += (Integer) neighbors[2][1];
		neighborVals += (Integer) neighbors[2][2];
		
		if (curVal != 0) {
			if (neighborVals < 2)
				return 0;
			else if (neighborVals > 3)
				return 0;
			else
				return 1;
		} else {
			if (neighborVals == 3)
				return 1;
			else
				return 0;
		}
	}
	
}
