package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day1_partTwo {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("day1/input.txt"))) {
            String line;
            List<Integer> leftList = new ArrayList<>();
            List<Integer> rightList = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                int firstInt = Integer.parseInt(parts[0]);
                int secondInt = Integer.parseInt(parts[1]);
                leftList.add(firstInt);
                rightList.add(secondInt);
            }
            int sum = 0;

            for (int i : leftList) {
                int count = Collections.frequency(rightList, i);
                if (count == 0) {
                } else {
                    int similarity = i * count;
                    sum += similarity;
                    System.out.println(i + " Occurance is " + count + " and the similarity " + similarity);
                }
            }
            System.out.println(sum);

        } catch (IOException e) {
            System.out.println("File was not found");
            e.printStackTrace();
        }
    }
}
