public class MyArraySizeException extends RuntimeException {
    private int row;
    private MyArraySizeException(String message) {
        super(message);
    }

    public MyArraySizeException(String message, int row) {
        this(message);
        this.row = row;
    }

    public int getRow() {
        return row;
    }
}
