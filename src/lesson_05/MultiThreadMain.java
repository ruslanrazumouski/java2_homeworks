package lesson_05;

import java.util.Arrays;

public class MultiThreadMain {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    private static long calcTimeFirstMethod(float[] arr) {
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i=0; i<size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return System.currentTimeMillis() - a;
    }

    private static long calcTimeSecondMethod(float[] arr) {
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        ThreadCalc t1 = new ThreadCalc(a1, 0,"flow_01");
        ThreadCalc t2 = new ThreadCalc(a2, h,"flow_02");

        try {
            if ( t1.isAlive() & t2.isAlive() ) {
                t1.join();
                t2.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy( t1.getArr(), 0, arr, 0, h );
        System.arraycopy( t2.getArr(), 0, arr, h, h);

        return System.currentTimeMillis() - a;
    }

    public static void main(String[] args) {
        float[] arr = new float[size];

        // 1.
        System.out.println(Thread.currentThread().getName() + " started");
        System.out.printf( "Time for first operation (ms): %d\n", calcTimeFirstMethod(arr) );

        // 2.
        System.out.printf( "Time for second operation (ms): %d\n", calcTimeSecondMethod(arr) );
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
