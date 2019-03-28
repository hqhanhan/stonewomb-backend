package com.stonewomb.broker.demo;

/**
 * 〈description〉<br>
 * 〈sort〉
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019-03-01 23:44
 */
public class Main {

    public static void main(String[] args) {
        int num=0;
        NumContainer numContainer = new NumContainer(0);
        new MyThread(numContainer).start();
        new MyThread(numContainer).start();
        new MyThread(numContainer).start();
        new MyThread(numContainer).start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(numContainer.getNum());


    }
}
