package lesson_05;

public class ThreadCalc extends Thread {
    private float[] arr;
    private String nameFlow;
    private int startPos;

    public ThreadCalc(float[] arr, int startPos, String nameFlow) {
        super(nameFlow);
        this.arr = arr;
        this.startPos = startPos;
        start();
    }

    public float[] getArr() {
        return arr;
    }

    @Override
    public void run() {
        System.out.println( getName() + " started" );
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i+startPos) / 5) * Math.cos(0.2f + (i+startPos) / 5) * Math.cos(0.4f + (i+startPos) / 2));
        }
        System.out.println( getName() + " finished" );
    }
}
