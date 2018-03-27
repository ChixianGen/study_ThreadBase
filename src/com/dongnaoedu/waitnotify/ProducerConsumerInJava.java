package com.dongnaoedu.waitnotify;   // 16612 于 2018/3/25 创建;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerInJava {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 5;
        Producer producer1 = new Producer(queue, maxSize, "生产者-1号");
        Consumer consumer1 = new Consumer(queue, maxSize, "消费者-1号");
        Producer producer2 = new Producer(queue, maxSize, "生产者-2号");
        Consumer consumer2 = new Consumer(queue, maxSize, "消费者-2号");
        Consumer consumer3 = new Consumer(queue, maxSize, "消费者-3号");
        producer1.start();
        consumer1.start();
        producer2.start();
        consumer2.start();
        consumer3.start();
    }
}
