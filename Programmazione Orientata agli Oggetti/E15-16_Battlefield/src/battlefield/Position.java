package battlefield;


/*
 * Da sistemare. Vedi PositionTest.
 * (vedi DOMANDA 1)
 */
public class Position {
	
	private int x, y;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
		
	@Override
	public String toString() {
		return this.x+"-"+this.y;
	}
	
	@Override
	public boolean equals(Object obj) {
		Position p = (Position) obj;
		return this.x == p.getX() && this.y == p.getY();
	}
	
	@Override
	public int hashCode() {
		return this.x + this.y * 3;
	}

}