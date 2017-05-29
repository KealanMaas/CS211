package Lab3;

public class SortGreatest {
	String data;
	int highest;
	
	public SortGreatest(String data){
		this.data = data;
		highest = Integer.MIN_VALUE;
		
		for(int i =0; i<data.length();i++)
		{
			if((int)data.charAt(i) > highest)
			{
				highest = (int)data.charAt(i);
			}
		}
	}
}