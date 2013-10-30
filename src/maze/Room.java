package maze;

public class Room {
	private boolean	isEntrance = false;
	private boolean isExit = false;
	private boolean northExit = false;
	private boolean eastExit = false;
	private boolean westExit = false;
	private boolean southExit = false;
	Room last = new Room();
	public Room()
	{
	
	}
	public boolean isEntrance() {
		return isEntrance;
	}
	public void setEntrance(boolean isEntrance) {
		this.isEntrance = isEntrance;
	}
	public boolean isExit() {
		return isExit;
	}
	public void setExit(boolean isExit) {
		this.isExit = isExit;
	}
	public boolean isNorthExit() {
		return northExit;
	}
	public void setNorthExit(boolean northExit) {
		this.northExit = northExit;
	}
	public boolean isEastExit() {
		return eastExit;
	}
	public void setEastExit(boolean eastExit) {
		this.eastExit = eastExit;
	}
	public boolean isWestExit() {
		return westExit;
	}
	public void setWestExit(boolean westExit) {
		this.westExit = westExit;
	}
	public boolean isSouthExit() {
		return southExit;
	}
	public void setSouthExit(boolean southExit) {
		this.southExit = southExit;
	}
	public Room getLast() {
		return last;
	}
	public void setLast(Room last) {
		this.last = last;
	}
	
	
}
