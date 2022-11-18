package factory_demos;

public class Factory {
    public static Shirt Exhibit(String ShirtName) {
        switch (ShirtName) {
            case "女款":
                return new WomenShirt();
            case "男款":
                return new MenShirt();
            default:
                return null;
        }
    }
}