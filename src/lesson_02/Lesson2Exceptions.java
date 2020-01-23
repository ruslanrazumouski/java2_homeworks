package lesson_02;

public class Lesson2Exceptions extends Exception{
    final static int NOT_A_MATRIX_4x4_EXCEPTION = 1;
    final static int NOT_A_NUMBER_EXCEPTION = 2;
    private int numException;

    Lesson2Exceptions(int numException) {
        this.numException = numException;
    }

    public int getNumException() {
        return numException;
    }
}
