public class MyArrayDataException extends RuntimeException {
    private int row;
    private int col;
    private MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException(String message, int row, int col) {
        this(message);
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
