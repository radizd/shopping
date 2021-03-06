package pl.erti.shopping.shoppingapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.erti.shopping.shoppingapi.dao.domain.CategoryEntity;
import pl.erti.shopping.shoppingapi.dao.domain.ProductEntity;

public interface ProductService {
    Page<ProductEntity> page(Pageable pageable);

    ProductEntity save(ProductEntity categoryEntity);
}
