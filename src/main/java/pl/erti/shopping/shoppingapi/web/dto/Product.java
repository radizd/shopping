package pl.erti.shopping.shoppingapi.web.dto;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private List<Category> categories;
}
