package lepse.SaddlePointTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SaddlePointTaskSolver {
    public static void solve() {
        String filePath = "src/main/java/lepse/SaddlePointTask/input.txt";

        try (var fileScanner = new Scanner(new File(filePath))) {
            int rowsNumber = fileScanner.nextInt();
            int columnsNumber = fileScanner.nextInt();

            int[][] matrix = new int[rowsNumber][columnsNumber];

            for (int i = 0; i < rowsNumber; i++) {
                for (int j = 0; j < columnsNumber; j++) {
                    matrix[i][j] = fileScanner.nextInt();
                }
            }

            findSaddlePoints(matrix, rowsNumber, columnsNumber);

        } catch (FileNotFoundException e) {
            System.err.println(filePath + " not found");
        } catch (NoSuchElementException e) {
            System.err.println("Not enough elements in the file");
        }
    }

    private static void findSaddlePoints(int[][] matrix, int rowsNumber, int columnsNumber) {
        var minRowsValues = new int[rowsNumber];

        for (int i = 0; i < rowsNumber; i++) {
            var minValue = matrix[i][0];

            for (int j = 0; j < columnsNumber; j++) {
                if ((matrix[i][j] < minValue)) {
                    minValue = matrix[i][j];
                }
            }
            minRowsValues[i] = minValue;
        }

        var maxColsValues = new int[columnsNumber];

        for (int i = 0; i < columnsNumber; i++) {
            var maxValue = matrix[0][i];

            for (int j = 0; j < rowsNumber; j++) {
                if (matrix[j][i] > maxValue) {
                    maxValue = matrix[j][i];
                }
            }
            maxColsValues[i] = maxValue;
        }

        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < columnsNumber; j++) {
                if (minRowsValues[i] == maxColsValues[j]) {
                    System.out.println("Saddle point: " + matrix[i][j] + " at row " + (i + 1) + " and column " + (j + 1));
                }
            }
        }
    }
}