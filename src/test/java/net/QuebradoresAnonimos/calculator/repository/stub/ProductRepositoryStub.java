package net.QuebradoresAnonimos.calculator.repository.stub;

import net.QuebradoresAnonimos.calculator.model.Product;

public class ProductRepositoryStub {

    public Product findById(Long id) {
        return new Product(1L, 100.00);
    }
}
