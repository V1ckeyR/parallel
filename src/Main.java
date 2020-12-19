import data.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread T1 = new Thread(new F1(1001, Data.Method.Random));
        T1.setName("F1");
        T1.setPriority(1);

        Thread T2 = new Thread(new F2(1001, Data.Method.Random));
        T2.setName("F2");
        T2.setPriority(10);

        Thread main = Thread.currentThread();
        main.setName("lab2");

        T1.start();
        T2.start();

        T1.join();
        T2.join();
        System.out.println("main " + Thread.currentThread().getName());
    }
}

