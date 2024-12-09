package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class day2_partTwo {
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

                if (isSafe(levels)) {
                    System.out.println(Arrays.toString(levels) + " : Safe");
                    safeCount++;
                } else if (canBeMadeSafe(levels)) {
                    System.out.println(Arrays.toString(levels) + " : Safe (with Dampener)");
                    safeCount++;
                } else {
                    System.out.println(Arrays.toString(levels) + " : Unsafe");
                    unsafeCount++;
                }
            }

            System.out.println("Total Safe Lines: " + safeCount);
            System.out.println("Total Unsafe Lines: " + unsafeCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isSafe(int[] levels) {
        boolean allSafe = true;
        boolean trendDetected = false;
        boolean isIncreasing = false;

        for (int i = 0; i < levels.length - 1; i++) {
            int current = levels[i];
            int next = levels[i + 1];

            if (current == next) {
                return false;
            }

            if (!trendDetected) {
                if (current < next) {
                    isIncreasing = true;
                } else {
                    isIncreasing = false;
                }
                trendDetected = true;
            } else {
                if (isIncreasing && current > next) {
                    return false;
                } else if (!isIncreasing && current < next) {
                    return false;
                }
            }

            if (!(current >= next - 3 && current <= next + 3)) {
                return false;
            }
        }

        return allSafe;
    }

    private static boolean canBeMadeSafe(int[] levels) {
        for (int i = 0; i < levels.length; i++) {
            int[] modifiedLevels = new int[levels.length - 1];

            for (int j = 0, k = 0; j < levels.length; j++) {
                if (j != i) {
                    modifiedLevels[k++] = levels[j];
                }
            }
            if (isSafe(modifiedLevels)) {
                return true;
            }
        }

        return false;
    }
}
