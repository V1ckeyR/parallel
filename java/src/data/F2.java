package data;

import java.util.Arrays;

public class F2 implements Runnable {
    private final int N;
    private final Data.Method method;
    int[][] ML, MH, MG;

    public F2(int N, Data.Method method) {
        this.N = N;
        this.method = method;
    }

    @Override
    public void run() {
        Data d = new Data(N);
        if (N > 1000) {
            switch (method) {
                case File -> {
                    ML = d.getFiledMatrix("asset/ML.txt");
                    MH = d.getFiledMatrix("asset/MH.txt");
                    MG = d.getFiledMatrix("asset/MG.txt");
                }
                case Number -> {
                    ML = d.getNumberedMatrix(1);
                    MH = d.getNumberedMatrix(1);
                    MG = d.getNumberedMatrix(1);
                }
                case Random -> {
                    ML = d.getRandomizedMatrix();
                    MH = d.getRandomizedMatrix();
                    MG = d.getRandomizedMatrix();
                }
                default -> throw new Error();
            }
        } else {
            if (method == Data.Method.Keyboard) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (System.in) {
                    synchronized (System.out) {
                        ML = d.getKeyboardMatrix();
                        MH = d.getKeyboardMatrix();
                        MG = d.getKeyboardMatrix();
                    }
                }
            } else {
                throw new Error();
            }
        }

        int[][] MK = Data.matricesSum(ML, Data.matricesMulti(MH, MG));

        System.out.println("MK = " + Arrays.deepToString(MK));
    }
}
