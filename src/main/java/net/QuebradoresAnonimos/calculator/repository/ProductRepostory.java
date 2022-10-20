package net.QuebradoresAnonimos.calculator.repository;

import net.QuebradoresAnonimos.calculator.model.Product;

public interface ProductRepostory {

    Product findById(long id);
}
