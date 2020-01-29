package pl.erti.shopping.shoppingapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.erti.shopping.shoppingapi.dao.domain.ProductEntity;
import pl.erti.shopping.shoppingapi.dao.repository.ProductRepository;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Page<ProductEntity> page(final Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
