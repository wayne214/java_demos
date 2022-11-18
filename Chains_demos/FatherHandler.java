package Chains_demos;

public class FatherHandler extends AbstractHandler {

    @Override
    public void handleRequest(String msg, int money) {
        System.out.println(msg + "：" + money + "块~");
        if (money < 500) {
            System.out.println("粑粑：500块以内，粑粑有，给你~");
        } else {
            System.out.println("粑粑：大于500，粑粑木有，找妈妈去吧~");
            if (getNextHandler() != null) {
                getNextHandler().handleRequest(msg, money);
            }
        }

    }

}
