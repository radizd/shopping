package pl.erti.shopping.shoppingapi.dao.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQ")
    @SequenceGenerator(sequenceName = "category_seq", allocationSize = 1, name = "CATEGORY_SEQ")
    private Long id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "categories")
    private Set<ProductEntity> products;
}
