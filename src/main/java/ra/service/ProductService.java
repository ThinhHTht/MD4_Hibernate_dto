package ra.service;

import ra.dto.request.CreateProductRequest;
import ra.dto.request.UpdateProductRequest;
import ra.dto.response.GetAllProductResponse;
import ra.model.Product;

import java.util.List;

public interface ProductService {
    List<GetAllProductResponse> findAll();
    void save(CreateProductRequest product);
    Product findById(int productId);
    void update(UpdateProductRequest product);
    void delete(int productId);
}
