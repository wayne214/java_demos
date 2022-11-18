package factory_demos;

// 简单工厂模式
public class SimpleFactoryPattern {
    public static void main(String[] args) {
        // Factory exhibitFactory = new Factory();
        try {
            Factory.Exhibit("女款").Show();
        } catch (Exception e) {
            // TODO: handle exception
        }

        try {
            Factory.Exhibit("男款").Show();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
