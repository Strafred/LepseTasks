package lepse.BracketsTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BracketsTaskSolver {
    private static final Map<Character, Character> BRACKETS_MAP = Map.of(
            '(', ')',
            '[', ']',
            '{', '}'
    );

    public static void solve() {
        String filePath = "src/main/java/lepse/BracketsTask/input.txt";

        try (var fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                boolean hasCorrectBrackets = isCorrectBracketsSequence(line);

                if (hasCorrectBrackets) {
                    System.out.println(line + " - правильная скобочная последовательность");
                } else {
                    System.out.println(line + " - неправильная скобочная последовательность");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(filePath + " not found");
        }
    }

    private static boolean isCorrectBracketsSequence(String line) {
        var bracketsStack = new ArrayDeque<Character>();

        for (char symbol : line.toCharArray()) {
            if (BRACKETS_MAP.containsKey(symbol)) {
                bracketsStack.push(symbol);
            }
            if (BRACKETS_MAP.containsValue(symbol)) {
                if (bracketsStack.isEmpty()) {
                    return false;
                }
                Character lastOpeningBracket = bracketsStack.pop();
                if (BRACKETS_MAP.get(lastOpeningBracket) != symbol) {
                    return false;
                }
            }
        }
        return bracketsStack.isEmpty();
    }
}