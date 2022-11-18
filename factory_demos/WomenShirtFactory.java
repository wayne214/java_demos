package factory_demos;

public class WomenShirtFactory extends Factory1 {

    @Override
    public Shirt Exhibit() {
        return new WomenShirt();
    }

}
