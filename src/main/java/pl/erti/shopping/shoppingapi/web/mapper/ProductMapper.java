package pl.erti.shopping.shoppingapi.web.mapper;

import org.mapstruct.Mapper;
import pl.erti.shopping.shoppingapi.dao.domain.ProductEntity;
import pl.erti.shopping.shoppingapi.web.dto.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product fromProductEntity(ProductEntity productEntity);
    ProductEntity toProductEntity(Product product);
}
