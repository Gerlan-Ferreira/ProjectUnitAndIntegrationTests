package net.QuebradoresAnonimos.calculator.service;

import net.QuebradoresAnonimos.calculator.model.Product;

public interface ProductDiscountCalculationService {

    Product calculate(Product product, Double discountFactor);

}
