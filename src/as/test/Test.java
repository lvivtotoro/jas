package as.test;

import as.DAutm;
import as.rulesets.RuleSetNeighbor;

public class Test {
	
	public static void main(String[] args) throws Exception {
		RuleSetNeighbor<Integer> rules = new RuleSetNeighbor<Integer>() {
			@Override
			public Integer select(DAutm<Integer> sim, Object[][] neighbors) {
				int[] neighbs = { 0, 0, 0, 0 };
				
				for (int nx = 0; nx < 3; nx++) {
					for (int ny = 0; ny < 3; ny++) {
						neighbs[(Integer) neighbors[nx][ny]]++;
					}
				}
				
				if ((Integer) neighbors[1][1] == 0) {
					if (neighbs[1] > neighbs[2] && neighbs[1] > neighbs[3])
						return 1;
					else if (neighbs[2] > neighbs[1] && neighbs[2] > neighbs[3])
						return 2;
					else if (neighbs[3] > neighbs[2] && neighbs[3] > neighbs[1])
						return 3;
					else
						return 0;
				} else if ((Integer) neighbors[1][1] == 1) {
					if (neighbs[2] >= 3)
						return 2;
					else
						return 1;
				} else if ((Integer) neighbors[1][1] == 2) {
					if (neighbs[3] >= 3)
						return 3;
					else
						return 2;
				} else if ((Integer) neighbors[1][1] == 3) {
					if (neighbs[1] >= 3)
						return 1;
					else
						return 3;
				}
				return (Integer) neighbors[1][1];
			}
		};
		DAutm<Integer> a = new DAutm<>(rules);
		
		for (int x = -10; x <= 10; x++) {
			for (int y = -10; y <= 10; y++) {
				a.set(x, y, (int) Math.max(0, Math.random() * 20 - 16));
			}
		}
		
		for (int frame = 0; frame < 200; frame++) {
			for (int y = -10; y < 10; y++) {
				for (int x = -10; x < 10; x++) {
					a.get(x, y);
				}
			}
			
			a.step();
		}
	}
	
}
