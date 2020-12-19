package data;

import java.util.Arrays;

public class F1 implements Runnable {
    private final int N;
    private final Data.Method method;
    int[][] MO, MP;
    int[] R, S2;
    int v;

    public F1(int N, Data.Method method) {
        this.N = N;
        this.method = method;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Data d = new Data(N);
        if (N > 1000) {
            switch (method) {
                case File -> {
                    R = d.getFiledVector("asset/R.txt");
                    S2 = d.getFiledVector("asset/S2.txt");
                    MO = d.getFiledMatrix("asset/ML.txt");
                    MP = d.getFiledMatrix("asset/MH.txt");
                    v = d.getFiledScalar("asset/v.txt");
                }
                case Number -> {
                    R = d.getNumberedVector(1);
                    S2 = d.getNumberedVector(1);
                    MO = d.getNumberedMatrix(1);
                    MP = d.getNumberedMatrix(1);
                    v = 1;
                }
                case Random -> {
                    R = d.getRandomizedVector();
                    S2 = d.getRandomizedVector();
                    MO = d.getRandomizedMatrix();
                    MP = d.getRandomizedMatrix();
                    v = d.getRandomizedScalar();
                }
                default -> throw new Error();
            }
        } else {
            if (method == Data.Method.Keyboard) {
                synchronized (System.in) {
                    synchronized (System.out) {
                        R = d.getKeyboardVector();
                        S2 = d.getKeyboardVector();
                        MO = d.getKeyboardMatrix();
                        MP = d.getKeyboardMatrix();
                        v = d.getKeyboardScalar();
                    }
                }
            } else {
                throw new Error();
            }
        }

        int[] S = Data.vectorsSum(Data.matrixVectorMulti(R, Data.matricesMulti(MO, MP)), Data.vectorScalarMulti(S2, v));

        System.out.println("S = " + Arrays.toString(S));
    }
}
