package com.gl.dsa.question1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BuildingConstructionPlan {

	public static int numberOfFloors;
	public static int looprun = 0;
	public static int fSize;

	public static void main(String[] args) {

		ArrayList<Integer> floorSizes = new ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the total no of floors in the building");

		numberOfFloors = sc.nextInt();

		BuildingConstructionPlan bcp = new BuildingConstructionPlan();

		for (int i = 0; i < numberOfFloors; i++) {

			System.out.println("enter the floor size given on day : " + (i + 1));

			floorSizes.add(sc.nextInt());

		}

		bcp.floorPlan(numberOfFloors, floorSizes);

		sc.close();

	}

	private void floorPlan(int numberOfFloors, ArrayList<Integer> floorSizes) {
		Stack<Integer> stack = new Stack<Integer>();

		int j = 1;
		int noofDays = numberOfFloors;
		while (j <= noofDays) {

			stack.clear();
			if (j < floorSizes.size()) {

				for (int h = 0; h < j; h++) {

					stack.push(floorSizes.get(h));

				}

			} else {
				int dayleft = noofDays - j;

				if (dayleft >= 0) {
					for (int h = 0; h < (floorSizes.size() - dayleft); h++) {

						stack.push(floorSizes.get(h));

					}
				}

			}

			sortStack(stack);

			if (!stack.isEmpty() && stack.peek() == numberOfFloors) {

				System.out.println("Day :" + j);

				while (!stack.isEmpty() && stack.peek() == numberOfFloors) {

					fSize = stack.pop();
					System.out.print(fSize + " ");

					if (floorSizes.size() > 0) {
						floorSizes.remove(Integer.valueOf(fSize));
					}

					numberOfFloors = numberOfFloors - 1;

				}

				System.out.println();

			} else {

				System.out.println("Day :" + j);

			}

			j++;

		}

	}

	private static void sortStack(Stack<Integer> s) {
		// If stack is not empty
		if (!s.isEmpty()) {
			// Remove the top item
			int x = s.pop();

			// Sort remaining stack
			sortStack(s);

			// Push the top item back in sorted stack
			sortedInsert(s, x);
		}
	}

	private static void sortedInsert(Stack<Integer> stack, int x) {

		if (stack.isEmpty() || x > stack.peek()) {
			stack.push(x);
			return;
		}

		int temp = stack.pop();
		sortedInsert(stack, x);

		stack.push(temp);

	}

}
