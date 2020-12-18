package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Data {
    public int n;

    public Data(int n) {
        this.n = n;
    }

    public static int[][] matricesMulti(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static int[] matrixVectorMulti(int[] a, int[][] b) {
        int n = a.length;
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i] += a[j] * b[j][i];
            }
        }
        return c;
    }

    public static int[] vectorScalarMulti(int[] v, int s) {
        int n = v.length;
        int[] c = new int[n];
        for (int i = 0; i < n; i++) c[i] = v[i] * s;
        return c;
    }

    public static int[][] matricesSum(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    public static int[] vectorsSum(int[] a, int[] b) {
        int n = a.length;
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    public int[][] getFiledMatrix(String filename) {
        int[][] a = new int[n][n];
        try {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = myReader.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return a;
    }

    public int[] getFiledVector(String filename) {
        int[] v = new int[n];
        try {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);
            for (int i = 0; i < n; i++) {
                v[i] = myReader.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return v;
    }

    public int getFiledScalar(String filename) {
        int s = 0;
        try {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);
            s = myReader.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }

    public int[][] getNumberedMatrix(int number) {
        int[][] a = new int[n][n];
        if (number != 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = number;
                }
            }
        }
        return a;
    }

    public int[] getNumberedVector(int number) {
        int[] v = new int[n];
        if (number != 0) {
            for (int i = 0; i < n; i++) {
                v[i] = number;
            }
        }
        return v;
    }

    public int[][] getRandomizedMatrix() {
        Random r = new Random();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = r.nextInt(100);
            }
        }
        return a;
    }

    public int[] getRandomizedVector() {
        Random r = new Random();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) v[i] = r.nextInt(20);
        return v;
    }

    public int getRandomizedScalar() {
        Random r = new Random();
        return r.nextInt(50);
    }

    public enum Method {
        Keyboard, File, Random, Number
    }
}
