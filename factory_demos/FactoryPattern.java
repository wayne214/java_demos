package factory_demos;

// 工厂模式
public class FactoryPattern {
    public static void main(String[] args) {
        Factory1 womenShiFactory = new WomenShirtFactory();
        womenShiFactory.Exhibit().Show();

        Factory1 menShiFactory = new MenShirtFactory();
        menShiFactory.Exhibit().Show();
    }
}
