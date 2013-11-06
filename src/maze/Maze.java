package maze;

public class Maze {
Room[][] maze = new Room[][];
Room finalExit;
Room entrance;
ArrayList<String> walls= new ArrayList<String>();
private int x, y;


public Maze(int rows, int columns){
  this.rows = rows;
  this.columns = columns;
  Room[][] maze = new Room[rows][columns];
  
  wallMaker();
  roomNumbers();
}




static private void wallMaker(){

for (int i = 0, p = 1; p < maze.length; i ++, p++){
  walls.add(i+":"+p);
}

 for(int i = x; i< maze.length; i+=(y+1)){
    walls.remove(i+":"+(i+1));
 }

for (int i = 0, p = (y+1), p<maze.length; i ++, p ++){
  walls.add(i+":"+p);
}


}//end wallMaker

public mazeMaker(){
  int x,y;
  
  Room curRoom = maze[1][0];
  entrance = curRoom;
  int visited=0;
  
  while(visited<maze.length()){
    //i the current room has any exists
              //get room number, then check the arrayList for that number
            //parse all elements in the array list for the roomNumber
    // randomly select 1, or 3 walls and remove them
    // they must be removed from the pairs ArrayList;
    //set room.visisted=true;
    //set teh current room to THAT room.
    
    curRoom = maze[0][0];
    rmNum= curRoom.roomNumber();
    //use a random generator to get either 1, 2, then 
    //search all elements of roomNumber ArrayList, remove that number, or until no more elements.
    
    //search for the walls in the array list
    
    
    
    
    
    }//while
  
  
  
  
}//mazeMaker
//go through each row, filling every column of the row, then
// go to the next row.

  private void roomNumbers(){
    number = 0;
    
    for(int x =0; x < rows; x ++){
      for(int y =0;y<columns; y ++){
      curRoom = maze[x][y];
      curRoom.setRoomNumber(number);
      number++;
      }//y loop
    }//x loop
  }//roomNumbers
}//end class
