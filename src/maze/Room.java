package maze;

public class Room {
	private int x;
	private int y;
	private boolean northExit = false;
	private boolean eastExit = false;
	private boolean westExit = false;
	private boolean southExit = false;
	private int roomNumber;
	Room last = new Room();
	public Room()
	{
	
	}
	public Room(int x, int y)
	{
	this.x=x;
	this.y=y;
	}
	public boolean hasNorthExit() {
		return northExit;
	}
	public void setNorthExit(boolean northExit) {
		this.northExit = northExit;
	}
	public boolean hasEastExit() {
		return eastExit;
	}
	public void setEastExit(boolean eastExit) {
		this.eastExit = eastExit;
	}
	public boolean hasWestExit() {
		return westExit;
	}
	public void setWestExit(boolean westExit) {
		this.westExit = westExit;
	}
	public boolean hasSouthExit() {
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
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setRoomNumber(int n){
		roomNumber = n;
	}
	public int roomNumber(){
		return roomNumber;
	}
	
	
}
