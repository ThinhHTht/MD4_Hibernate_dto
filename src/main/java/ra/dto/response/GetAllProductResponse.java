package ra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllProductResponse {
    private int productId;
    private String productName;
    private float price;
    private String imgUrl;
}
