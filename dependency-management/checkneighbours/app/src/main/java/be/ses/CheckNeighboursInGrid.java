package be.ses;

import java.util.*;

public class CheckNeighboursInGrid {

    /**
     * This method takes a 1D Iterable and an element in the array and gives back an iterable containing
     * the indexes of all neighbours with the same value as the specified element
     * @return - Returns a 1D Iterable of ints, the Integers represent the indexes of all neighbours with
     * the same value as the specified element on index 'indexToCheck'.
     * @param grid - This is a 1D Iterable containing all elements of the grid. The elements are integers.
     * @param width - Specifies the width of the grid.
     * @param height - Specifies the height of the grid.
     * @param indexToCheck - Specifies the index of the element whose neighbours need to be checked
     */
    public static Iterable<Integer> getSameNeighboursIds(Iterable<Integer> grid, int width, int height, int indexToCheck){
        // TODO write your code below so you return the correct result
        List<Integer> result = new ArrayList<>();
        List<Integer> gridList = new ArrayList<>();
        for (Integer val : grid) {
          gridList.add(val);
        }

        int target = gridList.get(indexToCheck);
        int row = indexToCheck / width;
        int col = indexToCheck % width;

    // Alle richtingen (inclusief diagonaal)
        int[] dRow = {-1, -1, -1,  0, 0, 1, 1, 1};
        int[] dCol = {-1,  0,  1, -1, 1,-1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width) {
                int neighbourIndex = newRow * width + newCol;
                if (gridList.get(neighbourIndex) == target) {
                    result.add(neighbourIndex);
                }
            }
        }

            return result;
        }   
}
