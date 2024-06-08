package lepse.FormatCaseTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FormatCaseTaskSolver {

    public static void solve() {
        String filePath = "src/main/java/lepse/FormatCaseTask/input.txt";

        try (var fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if (Pattern.matches("^[a-z]+$", line)) {
                    System.out.println(line + " - " + line);
                } else if (Pattern.matches("^[a-z]+(_[a-z]+)+$", line)) {
                    String transformed = toCamelCase(line);
                    System.out.println(line + " - " + transformed);
                } else if (Pattern.matches("^[a-z]+([A-Z][a-z]*)+$", line)) {
                    String transformed = toSnakeCase(line);
                    System.out.println(line + " - " + transformed);
                } else {
                    System.out.println(line + " - " + "Error!");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String toCamelCase(String snakeCaseLine) {
        var wordsArray = snakeCaseLine.split("_");
        StringBuilder transformed = new StringBuilder(wordsArray[0]);

        for (int i = 1; i < wordsArray.length; i++) {
            transformed.append(wordsArray[i].substring(0, 1).toUpperCase())
                    .append(wordsArray[i].substring(1));
        }
        return transformed.toString();
    }

    private static String toSnakeCase(String camelCaseLine) {
        StringBuilder transformed = new StringBuilder();

        for (int i = 0; i < camelCaseLine.length(); i++) {
            char symbol = camelCaseLine.charAt(i);
            if (Character.isUpperCase(symbol)) {
                transformed.append("_")
                        .append(Character.toLowerCase(symbol));
            } else {
                transformed.append(symbol);
            }
        }
        return transformed.toString();
    }
}
