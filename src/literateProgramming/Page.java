package literateProgramming;

public class Page {
    final int rowsPerPage;
    final int columnsPerPage;
    int[] numbers;
    int pageNumber;

    public Page(int rowsPerPage, int columnsPerPage) {
        this.rowsPerPage = rowsPerPage;
        this.columnsPerPage = columnsPerPage;
        pageNumber = 0;
    }

    boolean hasNext() {
        return getNextPageOffset() <= getNumberOfNumbers();
    }

    void nextPage() {
        pageNumber += 1;
    }

    boolean hasEntry(int row, int col) {
        return getIndexFor(row, col) <= getNumberOfNumbers();
    }

    int getEntryAt(int row, int col) {
        return numbers[getIndexFor(row, col)];
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public int getColumnsPerPage() {
        return columnsPerPage;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
    public int getPageNumber() {
        return pageNumber;
    }

    private int getIndexFor(int row, int col) {
        return getPageOffset() + row + col * rowsPerPage;
    }

    private int getNextPageOffset() {
        return pageNumber * rowsPerPage * columnsPerPage + 1;
    }

    private int getPageOffset() {
        return (pageNumber - 1) * rowsPerPage * columnsPerPage + 1;
    }

    private int getNumberOfNumbers() {
        return numbers.length - 1;
    }
}