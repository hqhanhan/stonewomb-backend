package com.stonewomb.broker.demo;

/**
 * 〈description〉<br>
 * 〈test〉
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019-03-01 23:45
 */
public class MyThread extends Thread {

    NumContainer numContainer;

    public MyThread(NumContainer numContainer) {
        this.numContainer = numContainer;
    }

    @Override
    public void run() {
        this.numContainer.setNum(numContainer.getNum() + 1);
    }
}
