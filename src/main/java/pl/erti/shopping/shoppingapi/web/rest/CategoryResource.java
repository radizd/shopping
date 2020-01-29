package pl.erti.shopping.shoppingapi.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.erti.shopping.shoppingapi.dao.domain.CategoryEntity;
import pl.erti.shopping.shoppingapi.service.CategoryService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryResource {
    private final CategoryService categoryService;

    @GetMapping
    ResponseEntity<Page<CategoryEntity>> page(final Pageable pageable) {
        return ResponseEntity.ok(categoryService.page(pageable));
    }

    @PostMapping
    ResponseEntity<CategoryEntity> save(final CategoryEntity categoryEntity) {
        return ResponseEntity.ok(categoryService.save(categoryEntity));
    }
}
