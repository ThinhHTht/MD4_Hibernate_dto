package ra.dto.mapper;

import org.springframework.stereotype.Component;
import ra.dto.dto.request.CreateCategoryRequest;
import ra.dto.dto.response.CreateCategoryResponse;
import ra.dto.model.Category;

import java.util.Date;

@Component
public class CreateMapper implements GennericMapper<CreateCategoryRequest, Category, CreateCategoryResponse>{

    @Override
    public Category mapperRequestToEntity(CreateCategoryRequest createCategoryRequest) {
        Category newCatgory = Category.builder().catalogName(createCategoryRequest.getCatalogName()).descriptions(createCategoryRequest.getDescriptions()).created(new Date()).build();
        return newCatgory;
    }

    @Override
    public CreateCategoryResponse mapperEntityToResponse(Category category) {
        return new CreateCategoryResponse(category.getCatalogId(), category.getCatalogName(), category.getCreated());
    }
}
