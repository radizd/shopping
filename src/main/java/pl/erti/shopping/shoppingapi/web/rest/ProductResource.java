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
import pl.erti.shopping.shoppingapi.dao.domain.ProductEntity;
import pl.erti.shopping.shoppingapi.dao.domain.ProductEntity;
import pl.erti.shopping.shoppingapi.service.ProductService;
import pl.erti.shopping.shoppingapi.web.dto.Product;
import pl.erti.shopping.shoppingapi.web.mapper.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductResource {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    ResponseEntity<Page<Product>> page(final Pageable pageable) {
        Page<ProductEntity> productEntities = productService.page(pageable);
        List<Product> productList = productEntities.getContent().stream()
                .map(productMapper::fromProductEntity)
                .collect(Collectors.toList());
        Page<Product> categories = new PageImpl<>(productList, pageable, productEntities.getTotalElements());
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    ResponseEntity<Product> save(final Product product) {
        ProductEntity productEntity = productService.save(productMapper.toProductEntity(product));
        return ResponseEntity.ok(productMapper.fromProductEntity(productEntity));
    }
}
