package ThreadDemos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 使用JUC工具类 CountDownLatch
 */
public class TestSync3 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        List<String> list = new ArrayList<>();
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
                    countDownLatch.countDown();
                }
            }

        });

        Thread threadB = new Thread(() -> {
            while (true) {
                if (list.size() != 5) {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程B收到通知， 执行业务逻辑");
                break;
            }

        });

        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadA.start();
    }
}
