package factory_demos;

public class MenShirtFactory extends Factory1 {

    @Override
    public Shirt Exhibit() {
        return new MenShirt();
    }

}
