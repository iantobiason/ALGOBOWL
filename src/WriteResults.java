import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteResults {
	//private String path;
	private ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> line1 = new ArrayList<Integer>(Arrays.asList(1,2,3));
	ArrayList<Integer> line2 = new ArrayList<Integer>(Arrays.asList(4,5));

	private ArrayList<ArrayList<Integer>> FLCP = new ArrayList<ArrayList<Integer>>();
	FLCP.add(new ArrayList<Integer>());
	FLCP.get(0).add(new Integer(0));

	
	
	
	public void writeResults(ArrayList<ArrayList<Integer>> Results) {
		
		try{
		FileWriter write = new FileWriter("output.txt", false);
		PrintWriter print_line = new PrintWriter(write);
		
		for(int i = 0; i<Results.size(); i++)
		{
			for(int j = 0; j<Results.get(i).size() - 1; j++)
			{
				int temp = Results.get(i).get(j);
				print_line.printf("%d ", temp);
			}
			int temp = Results.get(i).get((Results.get(i).size() - 1)); // in case the extra white space ruins something
			print_line.printf("%d\n", temp);
		}
		
		print_line.close();
				
		}catch(IOException e){
			System.out.println("Problem wiht the file");
		}
		
		
		
	}

	
	
}
