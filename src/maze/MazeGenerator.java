package maze;
import java.util.ArrayList;

//maze generator based on disjoint sets algorithm

public class MazeGenerator {
	
	private final int DOWN = 0;
	private final int RIGHT = 1;
	private ArrayList<String> removedWalls = new ArrayList<String>();
	private int[] a; 
	private int[] b;
	private int[] c;
	private int row;
	private int col;
	private int entrance;
	private int exit;
	private Room[][] theMaze;
	
	public MazeGenerator()
	{
		// default maze 
		this(15,30);
	}
	
	public MazeGenerator(int row, int col)
	{
		this.row = row;
		this.col = col;
		entrance = row/2;     // entrance is the middle row on the left side of the maze, first column.
		exit = row-1;	      // exit last row, last column
		generateWallRemovalList();
	}
	// create a list of walls to remove. format is room1:room2
	// where : is the wall between room1 and room2.
	public void generateWallRemovalList()
	{
		a = new int [ ((row-1)*col) ];
		for (int aIdx=0; aIdx < ((row-1)*col); aIdx++)
			a[aIdx] = aIdx;
		
		b = new int [ row ];
		for (int bIdx=0; bIdx < row; bIdx++)	
			b[bIdx] = bIdx*col;
	
		c = new int [ col - 1 ];
		for (int cIdx=0; cIdx < col - 1; cIdx++)
			c[cIdx] = cIdx;
		
		int pickSquare1=0;
		int pickSquare2=0;
		
		DisjointSets dSets = new DisjointSets(row*col);
		
     while ( dSets.isDisjoint() )
     {
     	int direction  = (int)(Math.random() * 2);
			switch ( direction )
			{
			case DOWN  : pickSquare1 = (int)(Math.random() * a.length);
						 pickSquare2 = pickSquare1 + col;
						 break;
			case RIGHT : pickSquare1 = b[(int)(Math.random() * b.length)]
					                 + c[(int)(Math.random() * c.length)];
			             pickSquare2 = pickSquare1 + 1;
			             break;
			}
			
			if ( dSets.find(pickSquare1) != dSets.find(pickSquare2) )
			{
				dSets.union( dSets.find(pickSquare1), dSets.find(pickSquare2));
				removedWalls.add(pickSquare1+":"+pickSquare2);
			}
     }
		System.out.println("DONE!");
	}

	// translate the list of removed walls into an array of rooms
	// where each room has the removed walls represented with boolean variables
	// for exits facing North, East, South and West.
	public Room[][] translate()
	{
		theMaze = new Room[row][col];
		int room1=0;
		int room2=0;
		for (int r=0; r < theMaze.length; r++)
			for (int c=0; c < theMaze[r].length; c++)
				theMaze[r][c] = new Room(r,c);
		
		theMaze[entrance][0].setEntrance(true);
		theMaze[entrance][0].setExitWest(true);
		theMaze[exit][col-1].setExit(true);
		theMaze[exit][col-1].setExitEast(true);
		
		for ( String wall : removedWalls )
		{
			room1 = Integer.parseInt(wall.split(":")[0]);
			room2 = Integer.parseInt(wall.split(":")[1]);
			if ( Math.abs(room1-room2) == 1 )
			{
				theMaze[room1/col][room1%col].setExitEast(true); // room1
				theMaze[room2/col][room2%col].setExitWest(true); // room2
			}
			else
			{
				theMaze[room1/col][room1%col].setExitSouth(true); // room1
				theMaze[room2/col][room2%col].setExitNorth(true); // room2
			}
		}
		return theMaze;
	}
	
	public String toString()
	{
		String outStr = new String("    ");
		// top row
		for ( int c=0; c<theMaze[0].length; c++)
			outStr += (c<10?" ":" ")+c+(c<10?"  ":" ");
		outStr += "\n   +";
		for ( int c=0; c<theMaze[0].length; c++)
			outStr += "---+";
		outStr += "\n";
		// print vertical walls for each row
		for (int r=0; r < theMaze.length; r++)
		{
			for (int rowRepeat=0; rowRepeat < 1; rowRepeat++)
			{ 
				if ( theMaze[r][0].hasExitWest() )
					outStr += String.format("%2d  ",r);
				else
					outStr += String.format("%2d |",r);		
				for (int c=0; c < theMaze[r].length; c++)
				{
					outStr += "   ";
				    if ( theMaze[r][c].hasExitEast() ) 
				    	outStr += " ";
				    else 
				    	outStr += "|";
				}
				outStr += "\n";
			}	
			// print bottom of each cell
			outStr += "   +";
			for ( int c=0; c<theMaze[0].length; c++)
				if ( theMaze[r][c].hasExitSouth() ) 
			    	outStr += "   +";
			    else 
			    	outStr += "---+";
			outStr += "\n";
		}
		return outStr;
	}
}