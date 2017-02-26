public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String [] args) {
		FileInput input = new FileInput();
		input.startUp();
		System.out.println(input.numberOfTasks);
		System.out.println(input.numberOfMachines);
		for(int i = 0; i < input.tasks.size(); i++) {
			System.out.print(input.tasks.get(i));
			System.out.print(" ");
			
		}
		System.out.println();
		for(int i = 0; i < input.machines.size(); i++) {
			System.out.print(input.machines.get(i));
			System.out.print(" ");
		}
		
		WriteResults results = new WriteResults();
		results.writeResults(25, results.test()); //replace 25 with actual time and test with actual 2darraylist
		
		
	}
}