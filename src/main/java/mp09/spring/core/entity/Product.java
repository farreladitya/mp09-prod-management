package mp09.spring.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mp09.spring.core.audit.AuditableBase;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "products")
public class Product extends AuditableBase {

    @Id
    @GeneratedValue()
    private int id;
    private String productname;
    private String categoryname;
    private int qty;
    private Long price;
    private String description;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn
    private Category category;
}
