// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class TransposeMult {
    public static void main(String[] args) {
        int initialValue = 1;
        int rows = 3;
        int columns = 3;
        transposeMultMatrix(initialValue, rows, columns);
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int[][] transposeMultMatrix(int initialValue, int rows, int columns) {
        // INSERT YOUR CODE HERE
        int[][] result = new int[rows][columns];
        int[][] data1 = new int[rows][columns];
        int[][] data2 = new int[rows][columns];
        for (int i = 0; i < rows * columns; i++) {
            data1[i % 3][i / 3] = initialValue;
            data2[i / 3][i % 3] = initialValue;
            initialValue++;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i % 3 == 0)
                    result[i][j] = data1[i][j] * data2[j][i] + data1[i + 1][j] * data2[j][i + 1] + data1[i + 2][j] * data2[j][i + 2];
                if (i % 3 == 1)
                    result[i][j] = data1[i - 1][j] * data2[j][i - 1] + data1[i][j] * data2[j][i] + data1[i + 1][j] * data2[j][i + 1];
                if (i % 3 == 2)
                    result[i][j] = data1[i - 2][j] * data2[j][i - 2] + data1[i - 1][j] * data2[j][i - 1] + data1[i][j] * data2[j][i];
            }
        }
        return result;
    }
    // METHOD SIGNATURE ENDS
}
