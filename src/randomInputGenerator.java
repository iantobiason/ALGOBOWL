import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class randomInputGenerator {
	
//	public static void main(String[] args) {
//		// TODO Auto-generated constructor stub
//		randomInputGenerator p = new randomInputGenerator();
//		p.generateRandomInputs();
//	}
	
	private int n = 457;	//number of Tasks
	private int m = 37;
	int[] taskTime = new int[n];
	int[] machinePower = new int[m];
	public void generateRandomInputs(){
		Random rand = new Random();
		int abc = rand.nextInt(9999) + 1;
		for (int i = 0; i < n; i++){
			abc = rand.nextInt(9999)+1;
			taskTime[i] = abc;
			System.out.println(taskTime[i]);
			
		}
		for (int i = 0; i < m; i++){
			abc = rand.nextInt(19)+1;
			machinePower[i] = abc;
			System.out.println(machinePower[i]);
			
		}
		try{
			PrintWriter writer = new PrintWriter("input1.txt", "UTF-8");
			writer.println(n);
			writer.println(m);
			for (int i = 0; i < taskTime.length; i++){
				writer.print(taskTime[i] + " ");
			}
			writer.println();
			for (int i = 0; i < machinePower.length; i++){
				writer.print(machinePower[i] + " ");
			}
			writer.close();
		} catch (IOException e){
			
		}
		
	}
}
