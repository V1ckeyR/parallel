package data;

import java.util.Arrays;

public class F1 implements Runnable {
    private final int N;
    private final Data.Method method;
    int[][] MO, MP;
    int[] R, S2;
    int v;

    public F1(int n, Data.Method method) {
        this.N = n;
        this.method = method;
    }

    @Override
    public void run() {
        Data d = new Data(N);
        if (N > 1000) {
            switch (method) {
                case File -> {
                    R = d.getFiledVector("R.txt");
                    S2 = d.getFiledVector("S2.txt");
                    MO = d.getFiledMatrix("ML.txt");
                    MP = d.getFiledMatrix("MH.txt");
                    v = d.getFiledScalar("v.txt");
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
            // keyboard
        }
        int[] S = Data.vectorsSum(Data.matrixVectorMulti(R, Data.matricesMulti(MO, MP)), Data.vectorScalarMulti(S2, v));
        System.out.println("S = " + Arrays.toString(S));
    }
}
