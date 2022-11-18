package Chains_demos;

import java.util.Random;

/**
 * 责任链模式
 */
public class ChainTest {
    public static void main(String[] args) {
        Random random = new Random();
        int needMoney = random.nextInt(1500);
        BrotherHandler brotherHandler = new BrotherHandler();
        FatherHandler fatherHandler = new FatherHandler();

        brotherHandler.setNextHandler(fatherHandler);

        brotherHandler.handleRequest("null", needMoney);
    }
}
