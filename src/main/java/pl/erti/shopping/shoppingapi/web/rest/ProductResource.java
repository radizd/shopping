package pl.erti.shopping.shoppingapi.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.erti.shopping.shoppingapi.dao.domain.ProductEntity;
import pl.erti.shopping.shoppingapi.service.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductResource {
    private final ProductService productService;

    @GetMapping
    ResponseEntity<Page<ProductEntity>> page(final Pageable pageable) {
        return ResponseEntity.ok(productService.page(pageable));
    }

    @PostMapping
    ResponseEntity<ProductEntity> save(final ProductEntity categoryEntity) {
        return ResponseEntity.ok(productService.save(categoryEntity));
    }
}
