package ThreadDemos;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用 volatile 关键字
 */
public class TestSync1 {
    // 定义共享变量来实现通信，它需要volatile修饰，否则线程不能及时感知
    static volatile boolean notice = false;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Thread threadA = new Thread() {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    list.add("abc");
                    System.out.println("线程添加元素list的size:" + list.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (list.size() == 5) {
                        notice = true;
                    }
                }
            };
        };

        Thread threadB = new Thread() {
            public void run() {
                while (true) {
                    if (notice) {
                        System.out.println("线程B收到通知，开始执行逻辑");
                        break;
                    }
                }
            };
        };

        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadA.start();
    }
}
