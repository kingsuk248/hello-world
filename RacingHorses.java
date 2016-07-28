package com.chef.code;

public class RacingHorses {
	public static void main(String[] args) throws Exception {
		RacingHorses rh = new RacingHorses();
		rh.compute();
	}
	
	private void compute() throws Exception{
		java.util.Scanner scanner;
		scanner = new java.util.Scanner(new java.io.File("chef"));
		int notc = scanner.nextInt();
		java.util.List<Integer> outputs = new java.util.ArrayList<Integer>(notc);
		for (int i = 0; i < notc; i++) {
			outputs.add(readEachTestCaseData(scanner));
		}
		scanner.close();
		for (Integer i : outputs) {
			System.out.println(i);
		}
	}
	
	private int readEachTestCaseData(java.util.Scanner scanner) {
		scanner.nextLine();
		int noh = scanner.nextInt();
		java.util.List<Integer> horses = new java.util.ArrayList<Integer>();
		for (int i = 0; i < noh; i++) {
			horses.add(scanner.nextInt());
		}
		java.util.Collections.sort(horses);
		int min = horses.get(1) - horses.get(0);
		for (int i = 0; i < horses.size() - 2; i++) {
			if (horses.get(i+1) - horses.get(i) < min) {
				min = horses.get(i+1) - horses.get(i);
			}
		}
		return min;
	}
}
