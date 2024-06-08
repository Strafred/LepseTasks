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
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < columnsNumber; j++) {
                if (isSaddlePoint(matrix, i, j, rowsNumber, columnsNumber)) {
                    System.out.println("Saddle point: " + matrix[i][j] + " at row " + (i + 1) + " and column " + (j + 1));
                }
            }
        }
    }

    private static boolean isSaddlePoint(int[][] matrix, int i, int j, int rowsNumber, int columnsNumber) {
        return isMinInRow(matrix, i, j, columnsNumber) && isMaxInColumn(matrix, i, j, rowsNumber);
    }

    private static boolean isMinInRow(int[][] matrix, int i, int j, int columnsNumber) {
        boolean isMin = true;
        for (int k = 0; k < columnsNumber; k++) {
            if (matrix[i][k] < matrix[i][j]) {
                isMin = false;
                break;
            }
        }
        return isMin;
    }

    private static boolean isMaxInColumn(int[][] matrix, int i, int j, int rowsNumber) {
        boolean isMax = true;
        for (int k = 0; k < rowsNumber; k++) {
            if (matrix[k][j] > matrix[i][j]) {
                isMax = false;
                break;
            }
        }
        return isMax;
    }
}