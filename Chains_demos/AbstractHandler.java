package Chains_demos;

public abstract class AbstractHandler {
    private AbstractHandler nextHandler;

    public AbstractHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String msg, int money);
}
