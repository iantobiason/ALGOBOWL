import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Algorithm {

	ArrayList<ArrayList<Integer>> assignedTasks;
	ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
	ArrayList<Double> machineTimes = new ArrayList<Double>();
	double totalTime;
	Map taskMap = new HashMap();
	ArrayList<Integer> visited = new ArrayList<Integer>();

	public Algorithm() {
		FileInput input = new FileInput();
		input.startUp();

		assignedTasks = new ArrayList<ArrayList<Integer>>(input.numberOfMachines);

		for (int i = 0; i < input.tasks.size(); i++) {
			taskMap.put(input.tasks.get(i), i + 1);
		}

		Collections.sort(input.tasks);
		Collections.sort(input.machines);

		// System.out.println(input.tasks.toString());

		for (int j = 0; j < (input.numberOfMachines); j++) {
			assignedTasks.add(new ArrayList<Integer>());
			temp.add(new ArrayList<Integer>());
		}
		int n = 0;

		for (int i = 0; i < input.numberOfTasks / input.numberOfMachines; i++) {
			for (int j = 0; j < (input.numberOfMachines); j++) {
				assignedTasks.get(j).add(input.tasks.get(input.numberOfTasks - n - 1));
				n++;
			}
		}

		n = 0;
		if (input.numberOfTasks % input.numberOfMachines != 0) {
			for (int i = 0; i < input.numberOfTasks % input.numberOfMachines; i++) {
				assignedTasks.get(i).add(input.tasks.get(i));
			}
		}

		System.out.println(assignedTasks.toString());

		double sum = 0;
		for (int i = 0; i < input.numberOfMachines; i++) {
			for (int j = 0; j < assignedTasks.get(i).size(); j++) {
				sum += assignedTasks.get(i).get(j);
			}
			machineTimes.add((double) sum / (input.machines.get(input.machines.size() - i - 1)));
			sum = 0;
		}
		System.out.println(machineTimes.toString());

		sum = 0;
		for (int i = 0; i < machineTimes.size(); i++) {
			sum += machineTimes.get(i);
		}
		totalTime = sum;
		System.out.println(totalTime);

		for (int i = 0; i < assignedTasks.size(); i++) {
			for (int j = 0; j < assignedTasks.get(i).size(); j++) {

				int key = assignedTasks.get(i).get(j);
				int value = (int) taskMap.get(key);
				temp.get(i).add(value);
				visited.add(value);

			}
		}
		System.out.println(temp.toString());
		assignedTasks = temp;

	}

}
