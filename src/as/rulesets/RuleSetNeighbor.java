package as.rulesets;

import java.util.ArrayList;
import java.util.List;

import as.DAutm;
import as.DAutm.Pos;

public abstract class RuleSetNeighbor<T extends Number> implements DAutm.RuleSet<T> {
	
	@SuppressWarnings("unchecked")
	@Override
	public void handle(DAutm<T> sim) {
		List<Pos> testNext = new ArrayList<>(64);
		
		for (Pos p : sim.getOldCells().keySet()) {
			Object[][] neighbors = new Object[3][3];
			
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					Pos np = new Pos(p.x + i, p.y + j);
					
					T n = sim.getOldCells().get(np);
					if (n == null) {
						testNext.add(np);
						neighbors[i + 1][j + 1] = (T) (Integer) 0;
					} else {
						neighbors[i + 1][j + 1] = n;
					}
				}
			}
			
			sim.getCells().put(new Pos(p), select(sim, neighbors));
		}
		
		for (Pos p : testNext) {
			Object[][] neighbors = new Object[3][3];
			
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					Pos np = new Pos(p.x + i, p.y + j);
					
					T n = sim.getOldCells().get(np);
					if (n == null) {
						neighbors[i + 1][j + 1] = (T) (Integer) 0;
					} else {
						neighbors[i + 1][j + 1] = n;
					}
				}
			}
			
			sim.getCells().put(new Pos(p), select(sim, neighbors));
		}
	}
	
	public abstract T select(DAutm<T> sim, Object[][] neighbors);
	
}
