import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput {
	String File = "good.txt";
	int numberOfTasks;
	int numberOfMachines;
	ArrayList<Integer> tasks = new ArrayList<Integer>();
	ArrayList<Integer> machines = new ArrayList<Integer>();


	public FileInput() {
		
	}

	public void startUp() {
		try {
			readInPoints();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void readInPoints() throws FileNotFoundException {
		FileReader reader = new FileReader(File);
		Scanner in = new Scanner(reader);
		String n = in.nextLine();
		numberOfTasks = Integer.parseInt(n);
		n = in.nextLine();
		numberOfMachines = Integer.parseInt(n);

		String ints = in.nextLine();
		String[] seperatedInts = ints.split(" ");
		for(int i = 0; i < seperatedInts.length; i++){
			int temp = Integer.parseInt(seperatedInts[i]);
			tasks.add(temp);
		}


		ints = in.nextLine();
		seperatedInts = ints.split(" ");
		for(int i = 0; i < seperatedInts.length; i++){
			int temp = Integer.parseInt(seperatedInts[i]);
			machines.add(temp);
		}

		in.close();
	}

}
