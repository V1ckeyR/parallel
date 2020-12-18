import data.*;

public class Main {
    public static void main(String[] args) {
//        int[][] a = {
//                { 1, 2, 3, 4 },
//                { 4, 5, 6, 4 },
//                { 7, 8, 9, 4 },
//                { 7, 8, 9, 4 },
//        };
//        int[][] b = {
//                { 11, 22, 33, 44 },
//                { 44, 55, 66, 44 },
//                { 77, 88, 99, 44 },
//                { 77, 88, 99, 44 },
//        };
//
//        int[] v = { 6, 7, 2, 4 };

        Thread T1 = new Thread(new F1(1001, Data.Method.Random));
        T1.setName("Function 1");
        T1.setPriority(Thread.MIN_PRIORITY);

        Thread T2 = new Thread(new F2(1001, Data.Method.Random));
        T2.setName("Function 2");
        T2.setPriority(Thread.MAX_PRIORITY);

        T1.start();
        T2.start();

//        T1.join();
    }
}

