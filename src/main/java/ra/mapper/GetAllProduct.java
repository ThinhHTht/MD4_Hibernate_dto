package ra.mapper;

import org.springframework.stereotype.Component;
import ra.dto.response.GetAllProductResponse;
import ra.dto.response.GetAllResponse;
import ra.model.Product;

@Component
public class GetAllProduct implements GennericMapper<Product, Product, GetAllProductResponse>{
    @Override
    public Product mapperRequestToEntity(Product product) {
        return null;
    }

    @Override
    public GetAllProductResponse mapperEntityToResponse(Product product) {
        return new GetAllProductResponse(product.getProductId(), product.getProductName(),product.getPrice(), product.getImageUrl());
    }
}
