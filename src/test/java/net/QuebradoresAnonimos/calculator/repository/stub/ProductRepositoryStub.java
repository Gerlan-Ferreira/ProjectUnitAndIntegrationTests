package net.QuebradoresAnonimos.calculator.repository.stub;

import net.QuebradoresAnonimos.calculator.model.Product;

public class ProductRepositoryStub {

    public Product findById(long id) {
        return new Product(1l, 100.00);
    }
}
