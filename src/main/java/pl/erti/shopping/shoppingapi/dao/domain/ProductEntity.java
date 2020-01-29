package pl.erti.shopping.shoppingapi.dao.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class ProductEntity {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
}
