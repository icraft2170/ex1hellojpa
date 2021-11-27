package hellojpa;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Product {
    @Id @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    private String name;
}
