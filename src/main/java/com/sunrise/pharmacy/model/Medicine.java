
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="medicines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Medicine {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

   @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "description", length = 500)
    private String description;
    
    @Column(name = "manufacturer")
    private String manufacturer;
    
    @Column(name = "price", nullable = false)
    private Double price;
    
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;
    
    @Column(name = "category")
    private String category;

    




}
