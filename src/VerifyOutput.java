import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class VerifyOutput {
	String outputFile = "output.txt";
	double time;
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
		Results = new ArrayList<ArrayList<Integer>>();
		ArrayList templist = new ArrayList<Integer>();
		
		FileInput fin = new FileInput();
		fin.startUp();
		machines = fin.machines;
		tasks = fin.tasks;
		
		FileReader reader = new FileReader(outputFile);
		Scanner in = new Scanner(reader);
		String n = in.nextLine();
		time = Integer.parseInt(n);

		//System.out.println("number of machines" + machines.size());
		for(int j = 0; j<machines.size(); j++)
		{
			Results.add(new ArrayList<Integer>());
			String ints = in.nextLine();
			String[] seperatedInts = ints.split(" ");
			//System.out.println("Machine number " + (j+1));
			for(int i = 0; i < seperatedInts.length; i++)
			{
				int temp = Integer.parseInt(seperatedInts[i]);
				//System.out.println("Trying to add " + tasks.get(temp-1));
				Results.get(j).add(tasks.get(temp-1));
			}
		}
		
		in.close();
	}

	
	
	
}
