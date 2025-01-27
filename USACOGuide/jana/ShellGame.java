// note: copied over from working in usaco.guide's ide lmao


import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class ShellGame {
	public static void main(String[] args) throws IOException {
        Scanner ear = new Scanner(new File("shell.in"));
		int swaps = ear.nextInt();

		int[] places1 = {1, 0, 0};
        int[] places2 = {0, 1, 0};
        int[] places3 = {0, 0, 1};
        int[] counts = {0, 0, 0};

        for (int i = 0; i < swaps; i++ ) {
            int a = ear.nextInt();
            int b = ear.nextInt();
            int g = ear.nextInt(); 

            int temp1 = places1[a - 1]; // store the place of a to put into b later
            int temp2 = places1[b - 1]; // same
            places1[b - 1] = temp1; // put a's val into b
            places1[a - 1] = temp2; 
                                            
            temp1 = places2[a - 1]; // store the place of a to put into b later
            temp2 = places2[b - 1]; // same
            places2[b - 1] = temp1; // put a's val into b
            places2[a - 1] = temp2; 

            temp1 = places3[a - 1]; // store the place of a to put into b later
            temp2 = places3[b - 1]; // same
            places3[b - 1] = temp1; // put a's val into b
            places3[a - 1] = temp2; 

            if (places1[g - 1] == 1) { // if it is the one with the shell
                counts[0] = counts[0] + 1;
            }
            if (places2[g - 1] == 1) { // if it is the one with the shell
                counts[1] = counts[1] + 1;
            }
            if (places3[g - 1] == 1) { // if it is the one with the shell
                counts[2] = counts[2] + 1;
            }          
        }
        int maximumValue = counts[0];
        System.out.println(Arrays.toString(counts));
        for (int num : counts) {
            if (num > maximumValue) {
                maximumValue = num;
            }
        }
        FileWriter writer = new FileWriter("shell.out");
        writer.writeln(maximumValue);
        writer.close();
	}
}