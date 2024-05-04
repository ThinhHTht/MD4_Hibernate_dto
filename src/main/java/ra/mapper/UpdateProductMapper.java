package ra.mapper;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import ra.dto.request.UpdateProductRequest;
import ra.model.Product;
import ra.repository.CategoryRepository;
import ra.service.ProductService;

import java.io.File;
import java.io.IOException;

@Component
public class UpdateProductMapper implements GennericMapper<UpdateProductRequest, Product, Product>{
    private static final String uploadPath = "C:\\Users\\admin\\IdeaProjects\\dto\\src\\main\\webapp\\uploads";
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Product mapperRequestToEntity(UpdateProductRequest updateProductRequest) {
        // chuyển đổi request thành entity
        Product product = new Product();
        if (updateProductRequest.getFile().getSize()!=0){
            // upload file
            product.setImageUrl(updateProductRequest.getFile().getOriginalFilename());

            try {
                FileCopyUtils.copy(updateProductRequest.getFile().getBytes(),new File(uploadPath+File.separator+updateProductRequest.getFile().getOriginalFilename()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            product.setImageUrl(productService.findById(updateProductRequest.getProductId()).getImageUrl());
        }
        product.setProductId(updateProductRequest.getProductId());
        product.setProductName(updateProductRequest.getProductName());
        product.setCategory(categoryRepository.findById(updateProductRequest.getCategoryId()).orElse(null));
        product.setPrice(updateProductRequest.getPrice());
        return product;
    }

    @Override
    public Product mapperEntityToResponse(Product product) {
        return null;
    }
}
