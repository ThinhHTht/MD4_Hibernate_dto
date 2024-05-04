package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ra.dto.request.CreateProductRequest;
import ra.dto.request.UpdateProductRequest;
import ra.dto.response.GetAllProductResponse;
import ra.mapper.CreateProductMapper;
import ra.mapper.GetAllProduct;
import ra.mapper.UpdateProductMapper;
import ra.model.Product;
import ra.repository.CategoryRepository;
import ra.repository.ProductRepository;
import ra.service.ProductService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GetAllProduct getAllProduct;
    @Autowired
    private CreateProductMapper createProductMapper;
    @Autowired
    private UpdateProductMapper updateProductMapper;
    private static final String uploadpath = "C:\\Users\\admin\\IdeaProjects\\dto\\src\\main\\webapp\\uploads";


    @Override
    public List<GetAllProductResponse> findAll() {
        return productRepository.findAll().stream().map(product -> getAllProduct.mapperEntityToResponse(product)).collect(Collectors.toList());
    }

    @Override
    public void save(CreateProductRequest product) {
       Product product1 = createProductMapper.mapperRequestToEntity(product);
        productRepository.save(product1);
//        Product product1 = new Product();
//        if (product.getFile().getSize()!=0){
//            // upload file
//            product1.setImageUrl(product.getFile().getOriginalFilename());
//
//            try {
//                FileCopyUtils.copy(product.getFile().getBytes(),new File(uploadpath+File.separator+product.getFile().getOriginalFilename()));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//        product1.setProductName(product.getProductName());
//        product1.setCategory(categoryRepository.findById(product.getCategoryId()).orElse(null));
//        product1.setPrice(product.getPrice());
//        productRepository.save(product1);
    }

    @Override
    public Product findById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public void update(UpdateProductRequest product) {
        Product old = findById(product.getCategoryId());
        Product productUpdate = updateProductMapper.mapperRequestToEntity(product);
        productUpdate.setCreated(old.getCreated());
        productRepository.save(productUpdate);

    }

    @Override
    public void delete(int productId) {
        productRepository.deleteById(productId);

    }
}
