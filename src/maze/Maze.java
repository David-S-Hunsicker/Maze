package maze;

public class Maze {
Room[][] maze = new Room[][];
Room finalExit;
Room entrance;
ArrayList<String> walls= new ArrayList<String>();
int[] rmNmbr = new int[];
private int x, y;


public Maze(int rows, int columns){
  this.rows = rows;
  this.columns = columns;
  Room[][] maze = new Room[rows][columns];
  int[] rmNums =[(rows*columns)]
  
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
  
  
  
  
  
  
}//mazeMaker
private void roomNumbers(){
  for(int i = 0; i < rmNumbs.length; i++){
    rmNumbs[i]= i;
}//for

}//end class
