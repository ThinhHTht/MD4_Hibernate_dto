package ra.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import ra.dto.request.CreateProductRequest;
import ra.dto.response.GetAllProductResponse;
import ra.model.Product;
import ra.repository.CategoryRepository;
import ra.repository.ProductRepository;
import ra.service.CategoryService;

import java.io.File;
import java.io.IOException;

@Component
public class CreateProductMapper implements GennericMapper<CreateProductRequest, Product, GetAllProductResponse>{
    private static final String uploadPath = "C:\\Users\\admin\\IdeaProjects\\dto\\src\\main\\webapp\\uploads";
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product mapperRequestToEntity(CreateProductRequest createProductRequest) {
        // chuyển đổi request thành entity
//        Product product = new Product();
//        if (createProductRequest.getFile().getSize()!=0){
//            // upload file
//            product.setImageUrl(createProductRequest.getFile().getOriginalFilename());
//
//            try {
//                FileCopyUtils.copy(createProductRequest.getFile().getBytes(),new File(uploadPath+File.separator+createProductRequest.getFile().getOriginalFilename()));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//        product.setProductName(createProductRequest.getProductName());
//        product.setCategory(categoryRepository.findById(createProductRequest.getCategoryId()).orElse(null));
//        product.setPrice(createProductRequest.getPrice());
//        return product;
            try{
                FileCopyUtils.copy(createProductRequest.getFile().getBytes(), new File(uploadPath+File.separator+createProductRequest.getFile().getOriginalFilename()));
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        return Product.builder().productName(createProductRequest.getProductName()).price(createProductRequest.getPrice()).imageUrl(createProductRequest.getFile().getOriginalFilename()).category(categoryRepository.findById(createProductRequest.getCategoryId()).orElse(null)).build();

    }

    @Override
    public GetAllProductResponse mapperEntityToResponse(Product product) {
        return null;
    }
}
