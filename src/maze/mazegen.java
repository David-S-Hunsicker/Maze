package maze;

import java.util.ArrayList;

public class mazegen {
int rows,columns;
Room[][] maze;
int disjrooms[];
ArrayList<String> box = new ArrayList<String>();
	
	public mazegen(int s1,int s2){
		rows = s1;
		columns = s2;
		maze = new Room[s1+1][s2+1];
		setRoomNames(maze);
		disjrooms = new int[Roomsize(s1,s2)];
		setdisrooms();
		createwalls();
	}
	
	//Method that numbers the rooms array
	public void setRoomNames(Room[][] aray){
		int g = 0;
		for(int i=0;i<(rows+1);i++){
			for(int k = 0;k<(columns+1);k++){
			aray[i][k] = g;
			g++;
			}
		}
	}
	
	//This method calculates the number of rooms
	public int Roomsize(int size1, int size2){
		int size =0 ;
		for(int p =0;p<size1+1;p++){
			for(int k = 0;k<size2+1;k++){
				size++;
			}
		}
		return size;
	}
	//Method that creates all the walls
	public void createwalls(){
		for(int i =0 ,p = 1;p<disjrooms.length;p++, i++){
			box.add(i+":" + p);
		}
		for(int i = rows; i<maze[rows][columns]; i+=(columns+1)){
			box.remove(i +":" + (i+1));
		}
		for(int f = 0,q=columns+1;q<disjrooms.length;f++,q++){
			box.add(f + ":"+q);
		}
	}
	
	public void setdisrooms(){
		for(int p=0;p<disjrooms.length;p++){
			disjrooms[p] = -1;
		}
	}
	
}
