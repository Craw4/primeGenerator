package literateProgramming;

public class NumberPrinter {
    private final int rowsPerPage;
    private final int columnsPerPage;
    private int[] numbers;

    public NumberPrinter(int rowsPerPage, int columnsPerPage) {
        this.rowsPerPage = rowsPerPage;
        this.columnsPerPage = columnsPerPage;
    }

    void print(int[] numbers, String title) {
        this.numbers = numbers;
        int pageNumber = 1;
        while (needToPrintMorePages(pageNumber)) {
            printHeader(title, pageNumber);
            printNumbersOnPage(pageNumber);
            System.out.println("\f");
            pageNumber++;
        }
    }

    private boolean needToPrintMorePages(int pageNumber) {
        return getPageOffset(pageNumber) <= getNumberOfNumbers();
    }

    private void printHeader(String title, int pageNumber) {
        System.out.printf("%s --- Page %d\n%n", title, pageNumber);
    }

    private void printNumbersOnPage(int pageNumber) {//18 min
        for (int row = 0; row < rowsPerPage; row++) {
            for (int col = 0; col <= columnsPerPage - 1; col++)
                printNumberAt(getPageOffset(pageNumber) + row +  col * rowsPerPage);
            System.out.println();
        }
    }

    private void printNumberAt(int index) {
        if (index <= getNumberOfNumbers())
            System.out.printf("%10d", numbers[index]);
    }

    public int getPageOffset(int pageNumber) {
        return (pageNumber -1) * rowsPerPage * columnsPerPage + 1;
    }

    public int getNumberOfNumbers() {
        return numbers.length - 1;
    }
}
