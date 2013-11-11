//Authors: Piotr Romanowski and David Hunsicker

package maze;

import java.util.ArrayList;
import java.util.Stack;

public class Maze {
static Object[][] maze;
Room finalExit;
Room entrance;
static ArrayList<String> walls= new ArrayList<String>();
private static int rows;
private static int columns;
private static int rmNum;

public Maze(int rows, int columns){
  this.rows = rows;
  this.columns = columns;
  maze = new Object[rows][columns];
  
  fillMaze();
  wallMaker();
  roomNumbers();
  mazeMaker();
} 

static private void wallMaker(){
	
for (int i = 0, p = 1; p < maze.length; i ++, p++){
  walls.add(i+":"+p);
  System.out.println(i +":"+ p + " are now a wall");
}

 for(int i = rows; i< maze.length; i+=(columns+1)){
    walls.remove(i+":"+(i+1));
 }

for (int i = 0, p = (columns+1); p<maze.length; i ++, p ++){
  walls.add(i+":"+p);
  System.out.println(i +":"+ p + " are now a wall");
}


}//end wallMaker

public void mazeMaker(){
  //Create stack that will be used to extract just the integers
  //from the wall list arraylist
  Room curRoom = (Room) maze[0][0];
  entrance = curRoom;
  int visited=0;
  Stack<Integer> roomStack = new Stack<Integer>();
  rmNum= curRoom.roomNumber();
  
  while(visited<maze.length){
	  
    
    int removals = (int) (Math.random()+1); 
    for(int i = 0; i < removals; i ++){
    	//parse walls array list to find relevant elements
    	for (int s =0; s< walls.size(); s++){
    		String pair = walls.get(s).toString();
    		int num1 = Integer.parseInt(pair.split(":")[0]);//This is the int before ":"
			int num2 = Integer.parseInt(pair.split(":")[1]);//This is the int after ":"
    		if(rmNum ==num1 || rmNum == num2){
    			walls.remove(s);
    			visited++;
    			if(rmNum == num1){
    				roomStack.push(num1);
    			}
    			else{
    				roomStack.push(num2);
    			}
    		}//If num1 or num2 are equal to the roomnumber, remove that wall
    		
	
    	}//walls iterator
    	rmNum= roomStack.pop();
    }//removal for loop
 
 
    }//while
   
}//mazeMaker

//go through each row, filling every column of the row, then
// go to the next row.

  private void roomNumbers(){
    int number = 0;
    
    for(int x =0; x < rows; x ++){
      for(int y =0;y<columns; y ++){
      ((Room) maze[x][y]).setRoomNumber(number);
      number++;
      }//y loop
    }//x loop
  }//roomNumbers
  
  
  public void fillMaze(){
	  for(int x =0; x < rows; x ++){
	      for(int y =0;y<columns; y ++){
	    	  maze[x][y] = new Room();
	      }
	  }
  }
}//end class
