package ra.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(columnDefinition = "varchar(100)", unique = true, nullable = false)
    private String productName;
    private float price;
    private int stock;
    private String imageUrl;
    private Date created;
    private boolean status;
    @ManyToOne
    @JoinColumn(name= "categoryId")
    private Category category;
}
