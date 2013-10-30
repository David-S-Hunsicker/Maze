package maze;

public class mazedriver {

	public static void main(String[] args){
		mazegen example = new mazegen(3,3);
		
		System.out.print("2d maze ");
		for(int t =0; t<example.rows+1;t++){ //This prints out the rooms in the 2d array
			for(int p = 0;p<example.columns+1;p++){
			System.out.print(example.maze[t][p]+" ");
			}
		}
		
		System.out.println();
		System.out.print("walls ");
		System.out.println(example.box); //prints out the walls
		
		
		System.out.print("set of rooms ");
		for(int t =0; t<example.disjrooms.length;t++){//This prints out the rooms respective names
		System.out.print(example.disjrooms[t]+" ");
		}
		
		
	}
}
