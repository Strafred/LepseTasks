package lepse.BoxTask;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BoxTaskSolver {

    public static void solve() {
        ArrayList<Tile> tiles = new ArrayList<>();

        String filePath = "src/main/java/lepse/BoxTask/input.txt";

        try (var fileScanner = new Scanner(new File(filePath))) {
            for (int i = 0; i < 6; i++) {
                int dim1 = fileScanner.nextInt();
                int dim2 = fileScanner.nextInt();

                if (dim1 < dim2) {
                    tiles.add(new Tile(dim1, dim2));
                } else {
                    tiles.add(new Tile(dim2, dim1));
                }
            }

            tiles.sort(Comparator.comparingInt(Tile::getHeight).thenComparingInt(Tile::getWidth));

            boolean isBoxPossible = tiles.get(0).getHeight() == tiles.get(1).getHeight() &&
                    tiles.get(1).getHeight() == tiles.get(2).getHeight() &&
                    tiles.get(2).getHeight() == tiles.get(3).getHeight() &&
                    tiles.get(0).getWidth() == tiles.get(1).getWidth() &&
                    tiles.get(1).getWidth() == tiles.get(4).getHeight() &&
                    tiles.get(4).getHeight() == tiles.get(5).getHeight() &&
                    tiles.get(2).getWidth() == tiles.get(3).getWidth() &&
                    tiles.get(3).getWidth() == tiles.get(4).getWidth() &&
                    tiles.get(4).getWidth() == tiles.get(5).getWidth();

            System.out.println(isBoxPossible ? "Возможно" : "Невозможно");

        } catch (Exception ex) {
            System.err.println("Невозможно");
        }
    }
}