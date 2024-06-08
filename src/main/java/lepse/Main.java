package lepse;

import lepse.BracketsTask.BracketsTaskSolver;

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
//                    Task2.main();
                    break;
                case '3':
//                    Task3.main();
                    break;
                case '4':
//                    Task4.main();
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