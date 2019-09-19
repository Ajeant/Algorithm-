package algorithm.factoryModel;

public class Factory implements IFactory {
    @Override
    public Product createProduct() {
        return new Product();
    }
}
