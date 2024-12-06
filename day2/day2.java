package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class day2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("day2/input.txt"))) {
            String line;
            int safeCount = 0;
            int unsafeCount = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                int[] levels = new int[parts.length];

                for (int i = 0; i < parts.length; i++) {
                    levels[i] = Integer.parseInt(parts[i]);
                }

                boolean allSafe = true;
                boolean trendDetected = false;
                boolean isIncreasing = false;

                for (int i = 0; i < levels.length - 1; i++) {
                    int current = levels[i];
                    int next = levels[i + 1];

                    if (current == next) {
                        allSafe = false;
                        break;
                    }

                    if (!trendDetected) {
                        if (current < next) {
                            isIncreasing = true;
                        } else if (current > next) {
                            isIncreasing = false;
                        }
                        trendDetected = true;
                    } else {

                        if (isIncreasing && current > next) {
                            allSafe = false;
                            break;
                        } else if (!isIncreasing && current < next) {
                            allSafe = false;
                            break;
                        }
                    }

                    if (!(current >= next - 3 && current <= next + 3)) {
                        allSafe = false;
                        unsafeCount++;
                        break;
                    }
                }

                System.out.println(Arrays.toString(levels));
                if (allSafe) {
                    System.out.println("Safe");
                    safeCount++;
                } else {
                    System.out.println("Unsafe");
                }
            }
            System.out.println("Total Safe Lines: " + safeCount);
            System.out.println("Total Unsafe Lines: " + unsafeCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
