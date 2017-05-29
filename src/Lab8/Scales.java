package Lab8;
	import java.util.*;
	public class Scales{

		public static void main (String[] args){
			Scanner myscanner = new Scanner(System.in);
			int items = myscanner.nextInt();
			int[] contents = new int[items];
			for(int i=0;i<items;i++){
				contents[i]=myscanner.nextInt();
			}
			int[] contents2 = new int[items];
			for(int i=0;i<items;i++){
				contents2[i]=contents[i];
			}
			int[] solution = solve(contents2);
			long subset1=0;
			long subset2=0;

			for(int i=0;i<items;i++){
				if(solution[i]==-1){
					subset1+=contents[i];
				}else if(solution[i]==1){
					subset2+=contents[i];
				}
			}
			System.out.println(Math.abs(subset1-subset2));
		}

		public static int[] solve(int[] contents){

			//fill this in
			//return a solution array using symbols {-1,0,1}

			int[] solution = new int[contents.length];
			for(int i=0;i<contents.length;i++){
				solution[i]=0;
			}

			//let's just find the smallest difference between any 2 numbers inthis array
			int smallest=Integer.MAX_VALUE;
			int firstnumber=0;
			int secondnumber=0;
			for(int i=0;i<contents.length;i++){
				for(int j=0;j<contents.length;j++){
					if(Math.abs(contents[i]-contents[j])<smallest&&i!=j){
						smallest=Math.abs(contents[i]-contents[j]);
						firstnumber=i;
						secondnumber=j;
					}
				}
			}
			solution[firstnumber]=-1;
			solution[secondnumber]=1;
			return solution;
		}
	}