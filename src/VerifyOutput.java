import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class VerifyOutput {
	String outputFile = "output.txt";
	int time;
	ArrayList<ArrayList<Integer>> Results;
	ArrayList<Integer> machines;
	ArrayList<Integer> tasks;
	
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}


	public VerifyOutput(String outputFile){
		super();
		this.outputFile = outputFile;
		try{
		this.readOutput();
		}catch(FileNotFoundException e)
		{
			System.out.println("Couldn't find one of the files");
		}
	}




	//check to make sure that their time matches the worst case scenario of their results, machines from FileInput
	public boolean verify( )
	{
		
		double thistime;
		double maxtime = 0;
		
		for(int i = 0; i< Results.size(); i++)
		{
			thistime = 0;
			for(int j = 0; j<Results.get(i).size(); j++)
			{
				thistime += Results.get(i).get(j);
			}
			thistime = thistime / machines.get(i); 
			if(thistime > maxtime)
			{
				maxtime = thistime;
			}
		}
		
		if(maxtime == time)
		return true;
		
		return false;
	}
	

	//called in ctor, initializes variables for verification
	private void readOutput() throws FileNotFoundException {
		
		FileInput fin = new FileInput();
		fin.startUp();
		int numMachines = fin.numberOfMachines;
		machines = fin.machines;
		tasks = fin.tasks;
		
		FileReader reader = new FileReader(outputFile);
		Scanner in = new Scanner(reader);
		String n = in.nextLine();
		time = Integer.parseInt(n);

		for(int j = 0; j<numMachines - 1; j++)
		{
			String ints = in.nextLine();
			String[] seperatedInts = ints.split(" ");
			for(int i = 0; i < seperatedInts.length; i++)
			{
				int temp = Integer.parseInt(seperatedInts[i]);
				Results.get(j).add(tasks.get(temp));
			}
		}
		
		in.close();
	}

	
	
	
}
