/*
 * This source file was generated by the Gradle 'init' task
 */
package be.ses;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );

        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, 4, 4, 5);

        System.out.print("Resultaat: ");
        for (Integer i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
