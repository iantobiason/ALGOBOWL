import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class WriteResults {
	//private String path;

	//make sure WriteResults works
	public ArrayList<ArrayList<Integer>> test()
	{
		ArrayList<Integer> line1 = new ArrayList<Integer>(Arrays.asList(1,2,3));
		ArrayList<Integer> line2 = new ArrayList<Integer>(Arrays.asList(4,5));
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>(1);
		results.add(line1);
		results.add(line2);
		
		return results;
		
	}


	//Write the results of our algorithm to a file called "output.txt"
	public void writeResults(double time, ArrayList<ArrayList<Integer>> Results) {
		
		try{
		FileWriter write = new FileWriter("output.txt", false);
		PrintWriter print_line = new PrintWriter(write);
		
		print_line.printf("%f%n",time);
		
		for(int i = 0; i<Results.size(); i++)
		{
			for(int j = 0; j<Results.get(i).size() - 1; j++)
			{
				int temp = Results.get(i).get(j);
				print_line.printf("%d ", temp);
			}
			int temp = Results.get(i).get((Results.get(i).size() - 1)); // in case the extra white space ruins something
			print_line.printf("%d%n", temp);
		}
		
		print_line.close();
				
		}catch(IOException e){
			System.out.println("Problem with the file");
		}
		
	}

	
	
}
