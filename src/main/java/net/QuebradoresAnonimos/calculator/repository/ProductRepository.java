package net.QuebradoresAnonimos.calculator.repository;

import net.QuebradoresAnonimos.calculator.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}

