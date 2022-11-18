package Chains_demos.ThreadDemos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * 基本 LockSupport 实现线程间的阻塞和唤醒
 * LockSupport 是一种非常灵活的实现线程间阻塞和唤醒的工具，
 * 使用它不用关注是等待线程先进行还是唤醒线程先运行，但是得知道线程的名字。
 */
public class TestSync5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Thread threadB = new Thread(() -> {
            if (list.size() != 5) {
                LockSupport.park();
                ;
            }
            System.out.println("线程B收到通知， 执行业务逻辑");
        });

        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                list.add("abc");
                System.out.println("线程添加元素list的size:" + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 5) {
                    LockSupport.unpark(threadB);
                }
            }
        });

        threadB.start();
        threadA.start();
    }
}
