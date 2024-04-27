package ra.dto.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id
    @Column(name = "catalog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catalogId;

    @Column(name = "catalog_name", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String catalogName;

    private String descriptions;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @Column(name = "catalog_status")
    private boolean status = true;
}
