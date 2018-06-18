package as;

import java.util.HashMap;

public class DAutm<T extends Number> {
	
	public static class Pos {
		public final long x, y;
		
		public Pos(long x, long y) {
			this.x = x;
			this.y = y;
		}
		
		public Pos(Pos p) {
			this.x = p.x;
			this.y = p.y;
		}

		@Override
		public int hashCode() {
			int hash = 17;
			hash = hash * 23 + Long.hashCode(x);
			hash = hash * 23 + Long.hashCode(y);
			return hash;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pos other = (Pos) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	
	@FunctionalInterface
	public static interface RuleSet<T extends Number> {
		public void handle(DAutm<T> sim);
	}
	
	private final RuleSet<T> rules;
	
	public DAutm(RuleSet<T> rules) {
		this.rules = rules;
	}
	
	private HashMap<Pos, T> oldCells = new HashMap<>();
	private HashMap<Pos, T> cells = new HashMap<>();
	
	public void step() {
		step(1);
	}
	
	public void step(int n) {
		for (int i = 0; i < n; i++) {
			oldCells.clear();
			HashMap<Pos, T> temp = cells;
			cells = oldCells;
			oldCells = temp;
			
			rules.handle(this);
		}
	}
	
	public HashMap<Pos, T> getOldCells() {
		return oldCells;
	}
	
	public HashMap<Pos, T> getCells() {
		return cells;
	}
	
	public void set(long x, long y, T val) {
		cells.put(new Pos(x, y), val);
	}
	
	public T get(long x, long y) {
		return cells.get(new Pos(x, y));
	}
	
}
