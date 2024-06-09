package lepse.BoxTask;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class BoxTaskSolver {

    public static void solve() {
        String filePath = "src/main/java/lepse/BoxTask/input.txt";
        var dimsMap = new HashMap<Integer, Integer>();
        int[][] values = new int[6][2];
        var pairs = new int[6];

        try (var fileScanner = new Scanner(new File(filePath))) {
            for (int i = 0; i < 6; i++) {
                int dim1 = fileScanner.nextInt();
                values[i][0] = dim1;
                dimsMap.put(dim1, 0);

                int dim2 = fileScanner.nextInt();
                values[i][1] = dim2;
                dimsMap.put(dim2, 0);
            }

            if (dimsMap.keySet().size() > 3) {
                System.err.println("Невозможно");
                return;
            }

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (isPair(i, j, values)) {
                        if ((pairs[i] < 2) && (pairs[j] < 2) && (pairs[i] == pairs[j])) {
                            pairs[i]++;
                            pairs[j]++;
                            dimsMap.put(values[i][0], dimsMap.get(values[i][0]) + 1);
                            dimsMap.put(values[i][1], dimsMap.get(values[i][1]) + 1);
                        }
                    }
                }
            }

            for (var pair: pairs) {
                if (pair != 2) {
                    System.err.println("Невозможно");
                    return;
                }
            }

            for (var entry : dimsMap.entrySet()) {
                if (entry.getValue() < 4) {
                    System.err.println("Невозможно");
                    return;
                }
            }

            System.out.println("Возможно");

        } catch (Exception e) {
            System.err.println("Невозможно");
        }
    }

    private static boolean isPair(int i, int j, int[][] values) {
        if ((i != j)
                && ((values[i][0] == values[j][0] && values[i][1] == values[j][1])
                || (values[i][0] == values[j][1] && values[j][0] == values[i][1]))) {
            return true;
        }
        return false;
    }
}
