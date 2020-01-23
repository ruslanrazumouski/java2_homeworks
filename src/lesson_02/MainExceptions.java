package lesson_02;

public class MainExceptions {

    private static final int NUM = 4;

    static String[][] strToMatrix(String inpString) throws Lesson2Exceptions, ArrayIndexOutOfBoundsException {
        String[][] matrix = new String[NUM][NUM];

        String[] rows = inpString.split("\n");
        int i = 0;
        for (String row: rows) {
            String[] ch = row.split(" ");
            for (int j = 0; j < ch.length; j++) {
                matrix[i][j] = ch[j];
            }
            i++;
        }

        if ( !isSquareMatrix(matrix) ) {
          throw new Lesson2Exceptions(Lesson2Exceptions.NOT_A_MATRIX_4x4_EXCEPTION);
        }
        return matrix;
    }

    public static boolean isDigit(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }

        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() == 1) {
                return false;
            }
            i = 1;
        }

        char ch;
        for (; i < string.length(); i++) {
            ch = string.charAt(i);
            if (!(ch >= '0' && ch <= '9')) {
                return false;
            }
        }
        return true;
    }

    static double calcMatrix(String[][] matrix) throws Lesson2Exceptions {
        int sum = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                if ( !isDigit(matrix[i][j] )  ) {
                    throw new Lesson2Exceptions(Lesson2Exceptions.NOT_A_NUMBER_EXCEPTION);
                }
                    sum += Integer.parseInt(matrix[i][j]);
            }
        }
        return sum/2;
    }

    static boolean isSquareMatrix(String[][] matrix) {
        int cnt = 0;
        for (int i=0; i<NUM; i++) {
            for (int j=0; j<NUM; j++) {
                if ( matrix[i][j] != null ) cnt++;
            }
        }
        return cnt % (NUM * NUM) == 0;
    }

    static void printMatrix(String[][] matrix) {
        for (int i=0; i<NUM; i++) {
            for (int j=0; j<NUM; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String inputStr = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        try {
            String[][] matrix = strToMatrix(inputStr);
            System.out.println("Матрица:");
            printMatrix(matrix);
            System.out.printf("Результат: %.0f", calcMatrix(matrix));
        } catch (Lesson2Exceptions e) {
            if (e.getNumException() == Lesson2Exceptions.NOT_A_MATRIX_4x4_EXCEPTION) {
                System.out.println("Матрица не 4x4 " + "код ошибки: " + e.getNumException() );
                e.printStackTrace();
            } else if (e.getNumException() == Lesson2Exceptions.NOT_A_NUMBER_EXCEPTION) {
                System.out.println("Элемент не является числом\n" + "код ошибки = " + e.getNumException() );
                e.printStackTrace();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за границы диапазона");
            e.printStackTrace();
        }

    }
}