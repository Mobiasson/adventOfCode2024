package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day1 {

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
            Collections.sort(leftList);
            Collections.sort(rightList);
            int totalDistance = 0;

            int size = Math.min(leftList.size(), rightList.size());
            for (int i = 0; i < size; i++) {
                int difference = Math.abs(leftList.get(i) - rightList.get(i));
                System.out.println("Number: " + (i + 1) + ": " + difference);
                totalDistance += difference;
            }
            System.out.println("total distance " + totalDistance);

        } catch (IOException e) {
            System.out.println("File was not found");
            e.printStackTrace();
        }
    }
}