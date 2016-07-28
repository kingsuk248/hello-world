package com.chef.code;

import java.util.Collections;
import java.util.List;

public class Main {
	java.util.List<Integer> notes;
	public static void main(String[] args) throws Exception {
		Main rh = new Main();
		rh.compute();
	}
	
	private void compute() throws Exception{
		java.util.Scanner scanner;
		scanner = new java.util.Scanner(new java.io.File("chef"));
		int notc = scanner.nextInt();
		java.util.List<String> outputs = new java.util.ArrayList<String>(notc);
		for (int i = 0; i < notc; i++) {
			outputs.add(readEachTestCaseData(scanner));
		}
		scanner.close();
		for (String i : outputs) {
			System.out.println(i);
		}
	}
	
	private String readEachTestCaseData(java.util.Scanner scanner) {
		scanner.nextLine();
		int nobn = scanner.nextInt();
		int md = scanner.nextInt();
		notes = new java.util.ArrayList<Integer>();
		for (int i = 0; i < nobn; i++) {
			notes.add(scanner.nextInt());
		}
		Collections.sort(notes);
		return calculate(md, notes);
	}

	private String calculate(int amount, List<Integer> notes) {
		int min = notes.get(0);
		int sum = 0;
		for (Integer i : notes) {
			sum += i;
		}
		int[] iamount = new int[amount+1];
		for (int i = min; i <= amount; i++) {
			iamount[min] = min;
//			if (amount < min) {
//				return "No";
//			} else if(sum < amount) {
//				return "No";
//			} else if(sum == amount) {
//				return "Yes";
//			}
			for (Integer n : notes) {
				if (iamount[i - 1] + n > i) {
					continue;
				} else if (min + n == i) {
					iamount[min] = iamount[i - 1] + n;
				}
			} 
		}
		return "No";
	}
}
