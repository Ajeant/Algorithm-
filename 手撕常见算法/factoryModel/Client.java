package algorithm.factoryModel;

public class Client {
    public static void main(String[] args){
        IFactory factory = new Factory();
        Product product = factory.createProduct();
        product.productMethod();
    }
}
