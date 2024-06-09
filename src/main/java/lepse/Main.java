package lepse;

import lepse.BoxTask.BoxTaskSolver;
import lepse.BracketsTask.BracketsTaskSolver;
import lepse.FormatCaseTask.FormatCaseTaskSolver;
import lepse.SaddlePointTask.SaddlePointTaskSolver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose task to complete (enter '1', '2', '3' or '4'):");
        try {
            int taskNumber = System.in.read();
            switch (taskNumber) {
                case '1':
                    BracketsTaskSolver.solve();
                    break;
                case '2':
                    SaddlePointTaskSolver.solve();
                    break;
                case '3':
                    FormatCaseTaskSolver.solve();
                    break;
                case '4':
                    BoxTaskSolver.solve();
                    break;
                default:
                    System.out.println("Invalid task number");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading input");
            e.printStackTrace();
        }
    }
}