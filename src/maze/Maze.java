//Authors: Piotr Romanowski and David Hunsicker

package maze;

import java.util.ArrayList;
import java.util.Stack;

public class Maze {
static Room[][] maze;
Room finalExit;
Room entrance;
static ArrayList<String> walls= new ArrayList<String>();
private static int rows;
private static int columns;
private static int rmNum;

public Maze(int rows, int columns){
  this.rows = rows;
  this.columns = columns;
  Room[][] maze = new Room[rows][columns];
  
  wallMaker();
  roomNumbers();
  mazeMaker();
} 

static private void wallMaker(){
	
for (int i = 0, p = 1; p < maze.length; i ++, p++){
  walls.add(i+":"+p);
}

 for(int i = rows; i< maze.length; i+=(columns+1)){
    walls.remove(i+":"+(i+1));
 }

for (int i = 0, p = (columns+1); p<maze.length; i ++, p ++){
  walls.add(i+":"+p);
}


}//end wallMaker

public void mazeMaker(){
  //Create stack that will be used to extract just the integers
  //from the wall list arraylist
  Room curRoom = maze[1][0];
  entrance = curRoom;
  int visited=0;
  
  while(visited<maze.length){
	  
	  curRoom = maze[0][0];
    rmNum= curRoom.roomNumber();
    
    
    int removals = (int) (Math.random()+1); 
    for(int i = 0; i < removals; i ++){
    	//parse walls array list to find relevant elements
    	for (int s =0; s< walls.size(); s++){
    		String pair = walls.get(s).toString();
    		int num1 = Integer.parseInt(pair.split(":")[0]);//This is the int before ":"
			int num2 = Integer.parseInt(pair.split(":")[1]);//This is the int after ":"
    		if(rmNum ==num1 || rmNum == num2){
    			walls.remove(s);
    		}//If num1 or num2 are equal to the roomnumber, remove that wall
    		
	
    	}//walls iterator
    }//removal for loop
              //get room number, then check the arrayList for that number
            //parse all elements in the array list for the roomNumber
    // randomly select 1 or 2 walls and remove them
    // they must be removed from the pairs ArrayList;
    //set room.visisted=true;
    //set the current room to THAT room.
     
    
    //use a random generator to get either 1, 2, then 
    //search all elements of roomNumber ArrayList,
    //parse the number from the string
    //remove that number, or until no more elements.
    
 
    }//while
   
}//mazeMaker

//go through each row, filling every column of the row, then
// go to the next row.

  private void roomNumbers(){
    int number = 0;
    
    for(int x =0; x < rows; x ++){
      for(int y =0;y<columns; y ++){
      Room curRoom = maze[x][y];
      curRoom.setRoomNumber(number);
      number++;
      }//y loop
    }//x loop
  }//roomNumbers
  

  
}//end class
