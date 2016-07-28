package com.chef.code;

public class CleaningUp {
	private int[][] outputs;
	private int outputIndex;
	
	public static void main(String[] args) throws java.lang.Exception {
		CleaningUp cw = new CleaningUp();
		cw.go();
	}

	private void go() {
		readInputs();
		for (int i = 0; i < outputs.length; i++) {
			for (int j = 0; j < outputs[i].length; j++) {
				int x = outputs[i][j] ;
				if (x != 0) System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	
	private void readInputs() {
		java.util.Scanner scanner;
		try {
			scanner = new java.util.Scanner(new java.io.File("chef"));
			int notc = scanner.nextInt();
			outputs = new int[notc * 2][];
			for (int i = 0; i < notc; i++) {
				readEachTestCaseData(scanner);
			}
			scanner.close();
		} catch (java.io.FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void readEachTestCaseData(java.util.Scanner scanner) {
		scanner.nextLine();
		int[] nm = new int[2];
		nm[0] = scanner.nextInt();
		nm[1] = scanner.nextInt();
		java.util.List<Integer> jobsCompleted = new java.util.ArrayList<Integer>();
		for (int i = 0; i < nm[1]; i++) {
			jobsCompleted.add(scanner.nextInt());
		}
		computeJob(nm, jobsCompleted);
	}

	private void computeJob(int[] nm, java.util.List<Integer> jobsCompleted) {
		java.util.List<Integer> jobsUnfinished = new java.util.ArrayList<Integer>(nm[0]);
		for (int i = 1; i <= nm[0]; i++) {
			jobsUnfinished.add(i);
		}
		for (Integer i : jobsCompleted) {
			jobsUnfinished.remove(i);
		}
		outputs[outputIndex] = new int[jobsUnfinished.size()];
		outputs[outputIndex + 1] = new int[jobsUnfinished.size()];
		int y = 0;
		int z = 0;
		for (Integer i : jobsUnfinished) {
			int x = jobsUnfinished.indexOf(i);
			if (x % 2 == 0) {
				//chefs share
				outputs[outputIndex][y++] = i;
			} else {
				//assistants share
				outputs[outputIndex + 1][z++] = i;
			}
		}
		outputIndex+= 2;
	}
}
