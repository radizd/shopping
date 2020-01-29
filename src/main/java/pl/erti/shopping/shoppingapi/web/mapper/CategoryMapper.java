package pl.erti.shopping.shoppingapi.web.mapper;

import org.mapstruct.Mapper;
import pl.erti.shopping.shoppingapi.dao.domain.CategoryEntity;
import pl.erti.shopping.shoppingapi.web.dto.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category fromCategoryEntity(CategoryEntity categoryEntity);
    CategoryEntity toCategoryEntity(Category category);
}
