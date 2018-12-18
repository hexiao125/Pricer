package com.pricer.solution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number of buildings:");
        int size = Integer.parseInt(scanner.nextLine());

        int[] input = new int[size];
        for(int i = 0; i < input.length; i++) {
            System.out.println("Please enter the height of building" + (i+1) + ":" );
            input[i] = Integer.parseInt(scanner.nextLine());
        }
        int result = solution(input);

        System.out.println("The minimum number of brushstrokes is: " + result);
    }

    /**
     * New strokes are needed only when the right building is higher than the adjacent left one.
     * The number of strokes needed is the difference between the two heights. The minimum number
     * of strokes is a sum of the height difference.
     */
    public static int solution(int[] heights) {
        int nStokes = heights[0];

        for(int i = 1; i < heights.length; i++) {
            if(heights[i] > heights[i-1]) {
                nStokes += heights[i] - heights[i-1];
                if (nStokes > 1000000000) {
                    return -1;
                }
            }
        }
        return nStokes;
    }

}
