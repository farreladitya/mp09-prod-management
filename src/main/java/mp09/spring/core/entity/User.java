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
@Table(name = "users")
public class User extends AuditableBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false, name = "name")
    private String name;

    @Column(length = 15, nullable = false)
    private String password;

    // one to many (user can have many products)
//    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_product", referencedColumnName = "id")
//    private List<Product> products;



}
