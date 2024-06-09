package lepse.BoxTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoxTaskSolver {

    public static void solve() {
        String filePath = "src/main/java/lepse/BoxTask/input.txt";
        Set<Integer> dimensionsSet = new HashSet<>();
        int[][] values = new int[6][6];

        try (var fileScanner = new Scanner(new File(filePath))) {
            for (int i = 0; i < 6; i++) {
                int dim1 = fileScanner.nextInt();
                dimensionsSet.add(dim1);
                values[i][0] = dim1;

                int dim2 = fileScanner.nextInt();
                dimensionsSet.add(dim2);
                values[i][1] = dim2;
            }

            int[] dimensionsArray = new int[3];

            if (dimensionsSet.size() == 3) {
                var i = 0;
                for (int dim : dimensionsSet) {
                   dimensionsArray[i] = dim;
                   i++;
                }

                if (hasTwo(dimensionsArray[0], dimensionsArray[1], values)
                        && hasTwo(dimensionsArray[1], dimensionsArray[2], values)
                        && hasTwo(dimensionsArray[0], dimensionsArray[2], values)) {
                    System.out.println("Возможно");
                } else {
                    System.err.println("Невозможно");
                }
            } else {
                System.err.println("Невозможно");
            }
        } catch (FileNotFoundException e) {
            System.err.println(filePath + " not found");
        }
    }

    private static boolean hasTwo(int dim1, int dim2, int[][] values) {
        var counter = 0;
        for (int i = 0; i < 6; i++) {
            if (values[i][0] != -1 && values[i][1] != -1) {
                if ((values[i][0] == dim1 && values[i][1] == dim2) || (values[i][0] == dim2 && values[i][1] == dim1)) {
                    counter++;
                    values[i][0] = -1;
                    values[i][1] = -1;
                }
            }
        }
        return counter == 2;
    }
}
