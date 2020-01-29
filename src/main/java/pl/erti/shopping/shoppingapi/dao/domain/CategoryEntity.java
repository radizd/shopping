package pl.erti.shopping.shoppingapi.dao.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
public class CategoryEntity {
    @Id
    private Long id;
    @Column
    private String name;
}
