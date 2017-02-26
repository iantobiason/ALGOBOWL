import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Algorithm {

	ArrayList<ArrayList<Integer>> assignedTasks;
	ArrayList<Double> machineTimes = new ArrayList<Double>();
	double totalTime;

	public Algorithm() {
		FileInput input = new FileInput();
		input.startUp();

		assignedTasks = new ArrayList<ArrayList<Integer>>(input.numberOfMachines);



		Collections.sort(input.tasks);
		Collections.sort(input.machines);

		System.out.println(input.tasks.toString());

		for(int j = 0; j < (input.numberOfMachines); j++) {
			assignedTasks.add(new ArrayList<Integer>());
		}
		int n = 0;


		for(int i = 0; i < input.numberOfTasks/input.numberOfMachines; i++) {
			for(int j = 0; j < (input.numberOfMachines); j++) {
				assignedTasks.get(j).add(input.tasks.get(input.numberOfTasks - n - 1));
				n++;
			}
		}

		n = 0;
		if(input.numberOfTasks % input.numberOfMachines != 0) {
			for(int i = 0; i < input.numberOfTasks % input.numberOfMachines; i++) {
				assignedTasks.get(i).add(input.tasks.get(i));
			}
		}

		System.out.println(assignedTasks.toString());
		
		double sum = 0;
		for(int i = 0; i < input.numberOfMachines; i++) {
			for(int j = 0; j < assignedTasks.get(i).size(); j++) {
				sum += assignedTasks.get(i).get(j);
			}
			machineTimes.add((double)sum/(input.machines.get(input.machines.size() - i - 1)));
			sum = 0;
		}
		System.out.println(machineTimes.toString());
		
		sum = 0;
		for(int i = 0; i < machineTimes.size(); i++) {
			sum += machineTimes.get(i);
		}
		totalTime = sum;
		System.out.println(totalTime);


	}

}
