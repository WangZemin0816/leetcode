package com.wangzemin.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
作者:pgf
时间:2019年12月20日
描述:当m1 和 m2 发生重排序后，先执行x=b，y=a； 在执行a=1，b=1，最后x=0，y=0
*/
public class VolatileTest {

    private int a = 1;
    private int b = 1;
    private int x = 1;
    private int y = 1;

    private volatile int c = 0;

    public void m1() {
        x = 2;
//        c = 1;
        b = 2;
    }

    public void m2() {
        y = b;
        a = 0;
    }

    public void test() throws Exception {
        CyclicBarrier cyc = new CyclicBarrier(2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cyc.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                m1();
            }
        }, "A");

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    cyc.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                m2();
            }
        }, "B");


        thread1.start();
        thread2.start();
        thread1.join();
        thread1.join();

        if (x == 0 && y == 0) {
            System.out.println("重排序了。。。。");
        }

    }


    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 100000; i++) {
//            VolatileTest jmmTest = new VolatileTest();
//            jmmTest.test();
//        }
        String s;
        StringBuilder sb;
        StringBuffer sf;
        A a = new B();
        B b = new B();
        System.out.println(a.a);
        System.out.println(b.a);
    }

    static class A{
        public int a = 0;
    }
    static class B extends A{
        public int a = 1;
    }

}