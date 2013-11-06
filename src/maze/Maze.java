package maze;

public class Maze {
Room[][] maze = new Room[][];
Room finalExit;
Room entrance;
ArrayList<String> walls= new ArrayList<String>();
private int x, y;


public Maze(int rows, int columns){
  x = rows;
  y = columns;
  Room[][] maze = new Room[x][y];
}




public void mazeMaker(){
//create the maze by setting up rooms to have exits
Room curRoom = maze[x][y];
entrance = curRoom;

for (int i = 0, p = 1; p < maze.length; i ++, p++){
  walls.add(i+":"+p);
}

 for(int i = x; i< maze.length; i+=(y+1)){
    walls.remove(i+":"+(i+1));
 }

for (int i = 0, p = (y+1), p<maze.length; i ++, p ++){
  walls.add(i+":"+p);
}


}//end mazemaker
}//end class
