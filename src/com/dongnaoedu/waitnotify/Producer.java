package com.dongnaoedu.waitnotify;   // 16612 于 2018/3/25 创建; 消费者

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread {

    private Queue<Integer> queue;
    private int size;
    private boolean flag = true;

    public Producer(Queue<Integer> queue,int size,String name) {
        super(name);
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {
        while (flag) {
            synchronized (queue) {
                while (queue.size() == size) {
                    try {
                        System.out.println("队列 is full,线程【" + Thread.currentThread().getName() + "】等待消费线程消费消息。");
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace(); }
                }
                Random random = new Random();
                int i = random.nextInt(1000);
                System.out.println(Thread.currentThread().getName() + "-生产消息：" + i);
                queue.add(i);
                queue.notifyAll();
            }
        }
    }

    public void stopPro() {
        this.flag = false;
    }
}
