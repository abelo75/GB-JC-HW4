import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HW4Test {

    @Test
    void sum() {
        HW4 hw4 = new HW4();

        String[][] arr1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "0", "1"},
                {"3", "4", "5", "6"}
        };

        MyArraySizeException sizeException = assertThrows(MyArraySizeException.class, () -> hw4.sum(arr1));
        assertEquals("Array is not square", sizeException.getMessage());
        assertEquals(2, sizeException.getRow());

        String[][] arr2 = {
                {"1", "2", "3", "4.1"},
                {"5", "6", "7e5", "8"},
                {"9", "0", "1", "q"},
                {"3", "4", "5", "6"}
        };

        MyArrayDataException exception1 = assertThrows(MyArrayDataException.class, () -> hw4.sum(arr2));
        assertEquals("Array element is not an number", exception1.getMessage());
        assertEquals(2, exception1.getRow());
        assertEquals(3, exception1.getCol());


        String[][] arr3 = {
                {"1", "2", "3", "4"},
                {"5", "6", null, "8"},
                {"9", "0", "1", "-1"},
                {"3", "4", "5", "6"}
        };
        MyArrayDataException exception2 = assertThrows(MyArrayDataException.class, () -> hw4.sum(arr3));
        assertEquals("Array element is null", exception2.getMessage());
        assertEquals(1, exception2.getRow());
        assertEquals(2, exception2.getCol());
        String[][] arr4 = {
                {"1", "2", "3", "4"},
                {"5", "6", "-15.3", "8"},
                {"9", "0", "1", "-1"},
                {"3", "4", "5", "6"}
        };
        assertEquals(41, hw4.sum(arr4));
    }
}