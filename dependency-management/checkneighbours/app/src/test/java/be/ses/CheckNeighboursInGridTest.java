package be.ses;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class CheckNeighboursInGridTest {

    @Test
    public void test_middleOfGrid_returnsCorrectNeighbours() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );
        int width = 4;
        int height = 4;
        int indexToCheck = 5;

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // Print result
        System.out.println("test_middleOfGrid_returnsCorrectNeighbours: " + toList(result));

        // Assert
        List<Integer> expected = Arrays.asList(2, 4, 10);
        assertTrue(expected.containsAll((Collection<?>) result) && ((Collection<?>) result).containsAll(expected));
    }

    @Test
    public void test_leftEdge_returnsOnlyCorrectNeighbour() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            1, 0, 0,
            1, 2, 2,
            3, 3, 3
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 3;

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // Print result
        System.out.println("test_leftEdge_returnsOnlyCorrectNeighbour: " + toList(result));

        // Assert
        List<Integer> expected = Arrays.asList(0);
        assertTrue(expected.containsAll((Collection<?>) result) && ((Collection<?>) result).containsAll(expected));
    }

    @Test
    public void test_topLeftCorner_returnsCorrectNeighbours() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            1, 1, 0,
            0, 1, 2,
            2, 0, 3
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 0;

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // Print result
        System.out.println("test_topLeftCorner_returnsCorrectNeighbours: " + toList(result));

        // Assert
        List<Integer> expected = Arrays.asList(1, 4);
        assertTrue(expected.containsAll((Collection<?>) result) && ((Collection<?>) result).containsAll(expected));
    }

    @Test
    public void test_noMatchingNeighbours_returnsEmpty() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            1, 2, 3,
            4, 9, 6,
            7, 8, 0
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 4;

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // Print result
        System.out.println("test_noMatchingNeighbours_returnsEmpty: " + toList(result));

        // Assert
        assertFalse(result.iterator().hasNext());
    }

    @Test
    public void test_multipleSameNeighbours_returnsAll() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            0, 1, 0,
            1, 1, 1,
            0, 1, 0
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 4;

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // Print result
        System.out.println("test_multipleSameNeighbours_returnsAll: " + toList(result));

        // Assert
        List<Integer> expected = Arrays.asList(1, 3, 5, 7);
        assertTrue(expected.containsAll((Collection<?>) result) && ((Collection<?>) result).containsAll(expected));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_invalidIndex_throwsException() {
        // Arrange
        List<Integer> grid = Arrays.asList(1, 2, 3, 4);
        int width = 2;
        int height = 2;
        int indexToCheck = 10;

        // Act & Assert
        CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);
    }

    // Helper method om Iterable naar List te converteren voor nette output
    private static List<Integer> toList(Iterable<Integer> iterable) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : iterable) {
            list.add(i);
        }
        return list;
    }
}
