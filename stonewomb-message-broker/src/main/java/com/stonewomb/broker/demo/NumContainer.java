package com.stonewomb.broker.demo;

/**
 * 〈description〉<br>
 * 〈container〉
 *
 * @author hqhan8080@Gmail.com
 * @version V1.0
 * @date 2019-03-01 23:54
 */
public  class  NumContainer {

    public NumContainer(int num){
        this.num=num;
    }

    public  int num = 0;

    public  int getNum() {
        return num;
    }

    public  synchronized void setNum(int num) {
        this.num = num;
    }
}
