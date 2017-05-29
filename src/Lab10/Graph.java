package Lab10;

public class Graph{
	 public static void main(String[] args){

	 FileIO io = new FileIO();
	 String[] original = io.load("C:\\graph.txt");
	 int size=original.length-1;
	 int[][] array = new int[size][size];

	 for(int i=1;i<=size;i++){ //load up the data into array
	 for(int j=1;j<=size;j++){
	 array[i-1][j-1]=Integer.parseInt(original[i].split("\t")[j]);
	 }
	 }
	 int furthestdistance=0; //keep track of the longest path foun so far
	 String furthestroute="";
	 for(int i=0;i<size;i++){ //loop through all possible starting positions

	 int visited=0; //how many vertices have been visited so far?
	 Vertex[] vertices = new Vertex[size]; //initiate the vertex objects
	 for(int j=0;j<size;j++){
	 vertices[j]=new Vertex(original[0].split("\t")[j+1]);
	 }
	 vertices[i].visited=true; //we visit the startin position
	 visited++; //we've visited one vertex so far
	 vertices[i].distance=0; //set this vertex as startin point
	 for(int j=0;j<size;j++){ //update distances from starting point
	 if(array[j][i]>0){ //only update those that can be reached from here
	 vertices[j].distance=array[j][i];
	 }
	 }
	 while(visited<size){ //while not all vertices visited
		 while(visited<size){ //while not all vertices visited
			 int minvalue=Integer.MAX_VALUE; //set to infinity as default-there must be something shorter
			 int minvertex=-1; //a default which will crash if it is not superseded
			 for(int j=0;j<size;j++){ //find the next vertex to visit
			 if(vertices[j].visited==false){ //if it has not been visited
			 if(vertices[j].distance<minvalue){
			 minvalue=vertices[j].distance;
			 minvertex=j; //we are choosing the closest vertex to the starting position which has not been visited yet
			 }
			 }
			 }
			 vertices[minvertex].visited=true; //we have now visited it
			 visited++;
			 for(int j=0;j<size;j++){ //update distances from this new point

			if(array[j][minvertex]>0&&vertices[j].visited==false){ //if vertex is connected and not visited

			if(vertices[j].distance>vertices[minvertex].distance+array[j][minvertex]){

			vertices[j].distance=vertices[minvertex].distance+array[j][minvertex];
			//update if a new shorter route to this vertex has been found
			 vertices[j].route=minvertex; //track the path taken
			 }
			 }
			 }
			 }
	 }
	 for(int x=0;x<size;x++){ //check for a new record distance
	 if(vertices[x].distance>furthestdistance){ //go through all distances in the graph
	 furthestdistance=vertices[x].distance;
	int visiting=x;
	 String solution=""; //build up the path taken to get this particular record beating distance
	 while(visiting>=0){ //the starting position has route of -1
	 solution=vertices[visiting].label+""+solution;
	visiting=vertices[visiting].route; //step back along the route taken to generate this distance
	 }
	solution=vertices[i].label+""+solution; //this is the starting position
	 furthestroute=solution; //keep track of this record path
	 }
	 }
	 }
	 System.out.println(furthestdistance); //print out the results
	 System.out.println(furthestroute);
	 }
	}
	class Vertex{ //everything you need for a vertex
	 public boolean visited=false; //has it been visited?
	 int distance=Integer.MAX_VALUE; //the shortest route from starting position to this vertex
	 int route=-1; //keep track of the last step taken to reach this vertex for the shortest path - what vertex did it come from?
	 String label; //name of the vertex

	 public Vertex (String labelin){ //give the vertex a name when instantiated
	 label=labelin;
	 }
	} 