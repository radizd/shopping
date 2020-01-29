package pl.erti.shopping.shoppingapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.erti.shopping.shoppingapi.dao.domain.CategoryEntity;

public interface CategoryService {
    Page<CategoryEntity> page(Pageable pageable);

    CategoryEntity save(CategoryEntity categoryEntity);
}
