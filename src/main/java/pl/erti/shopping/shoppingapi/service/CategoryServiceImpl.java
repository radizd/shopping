package pl.erti.shopping.shoppingapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.erti.shopping.shoppingapi.dao.domain.CategoryEntity;
import pl.erti.shopping.shoppingapi.dao.repository.CategoryRepository;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Page<CategoryEntity> page(final Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public CategoryEntity save(final CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }
}
