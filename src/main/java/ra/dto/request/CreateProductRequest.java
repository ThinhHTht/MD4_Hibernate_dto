package ra.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductRequest {
    private String productName;
    private float price;
    private MultipartFile file;
    private int categoryId;

}
