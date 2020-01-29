package pl.erti.shopping.shoppingapi.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.erti.shopping.shoppingapi.dao.domain.CategoryEntity;
import pl.erti.shopping.shoppingapi.service.CategoryService;
import pl.erti.shopping.shoppingapi.web.dto.Category;
import pl.erti.shopping.shoppingapi.web.mapper.CategoryMapper;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryResource {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    ResponseEntity<Page<Category>> page(final Pageable pageable) {
        Page<CategoryEntity> categoryEntities = categoryService.page(pageable);
        List<Category> categoryList = categoryEntities.getContent().stream()
                .map(categoryMapper::fromCategoryEntity)
                .collect(Collectors.toList());
        Page<Category> categories = new PageImpl<>(categoryList, pageable, categoryEntities.getTotalElements());
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    ResponseEntity<Category> save(final Category category) {
        CategoryEntity categoryEntity = categoryService.save(categoryMapper.toCategoryEntity(category));
        return ResponseEntity.ok(categoryMapper.fromCategoryEntity(categoryEntity));
    }
}
