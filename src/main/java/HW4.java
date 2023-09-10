public class HW4 {

    int sum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            String[] row = arr[i];
            if (row.length != arr.length) {
                throw new MyArraySizeException("Array is not square", i);
            }
            for (int j=0; j<row.length; j++) {
                try {
                    sum += (int) Double.parseDouble(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Array element is not an number", i, j);
                } catch (NullPointerException e) {
                    throw new MyArrayDataException("Array element is null", i, j);
                }
            }
        }
        return sum;
    }

    public void printSum(String header, String[][] arr) {
        try {
            int sum = sum(arr);
            System.out.print(header + ": ");
            System.out.println("Sum: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
            System.out.println("Row: " + e.getRow());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
            System.out.println("Row: " + e.getRow());
            System.out.println("Col: " + e.getCol());
        }
    }
    public static void main(String[] args) {
        String[][] arr1 = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "0", "1"},
            {"3", "4", "5", "6"}
        };
        String[][] arr2 = {
            {"1", "2", "3", "4.1"},
            {"5", "6", "7e5", "8"},
            {"9", "0", "1", "q"},
            {"3", "4", "5", "6"}
        };
        String[][] arr3 = {
            {"1", "2", "3", "4"},
            {"5", "6", null, "8"},
            {"9", "0", "1", "-1"},
            {"3", "4", "5", "6"}
        };
        String[][] arr4 = {
            {"1", "2", "3", "4"},
            {"5", "6", "-15.3", "8"},
            {"9", "0", "1", "-1"},
            {"3", "4", "5", "6"}
        };

        HW4 hw4 = new HW4();

        hw4.printSum("arr1", arr1);
        hw4.printSum("arr2", arr2);
        hw4.printSum("arr3", arr3);
        hw4.printSum("arr4", arr4);

    }
}
