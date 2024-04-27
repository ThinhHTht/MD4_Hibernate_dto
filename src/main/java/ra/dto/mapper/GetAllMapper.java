package ra.dto.mapper;

import org.springframework.stereotype.Component;
import ra.dto.dto.response.GetAllResponse;
import ra.dto.model.Category;
@Component
public class GetAllMapper implements GennericMapper<Category, Category, GetAllResponse>{
    @Override
    public Category mapperRequestToEntity(Category category) {
        return null;
    }
    @Override
    public GetAllResponse mapperEntityToResponse(Category category) {
        return new GetAllResponse(category.getCatalogId(), category.getCatalogName(), category.getCreated());
    }
}
