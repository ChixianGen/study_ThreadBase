package com.dongnaoedu.waitnotify;   // 16612 于 2018/3/25 创建;

import java.util.Queue;

public class Consumer extends Thread {

    private Queue<Integer> queue;
    private int size;
    private boolean flag = true;

    public Consumer(Queue<Integer> queue,int size,String name) {
        super(name);
        this.queue = queue;
        this.size = size;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("队列 is empty,线程【" + Thread.currentThread().getName() + "】等待生产线程生产消息。");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "-消费消息：" + queue.remove());
                queue.notifyAll();
            }
        }
    }

    public void stopCon() {
        this.flag = false;
    }
}

