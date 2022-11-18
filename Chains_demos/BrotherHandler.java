package Chains_demos;

public class BrotherHandler extends AbstractHandler {

    @Override
    public void handleRequest(String msg, int money) {
        System.out.println(msg + "：" + money + "块~");
        if (money < 100) {
            System.out.println("哥哥：小于100块哥哥还是有的，给你~");
        } else {
            System.out.println("哥哥：大于100块哥哥木有那么多钱，找粑粑去吧~");
            if (getNextHandler() != null) {
                getNextHandler().handleRequest(msg, money);
            }
        }

    }

}
