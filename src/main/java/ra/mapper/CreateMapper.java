package ra.mapper;

import org.springframework.stereotype.Component;
import ra.dto.request.CreateCategoryRequest;
import ra.dto.response.CreateCategoryResponse;
import ra.model.Category;

import java.util.Date;

@Component
public class CreateMapper implements GennericMapper<CreateCategoryRequest, Category, CreateCategoryResponse>{

    @Override
    public Category mapperRequestToEntity(CreateCategoryRequest createCategoryRequest) {
        return Category.builder()
                .catalogName(createCategoryRequest.getCatalogName())
                .descriptions(createCategoryRequest.getDescriptions())
                .created(new Date())
                .build();
    }

    @Override
    public CreateCategoryResponse mapperEntityToResponse(Category category) {
        return new CreateCategoryResponse(
                category.getCatalogId(),
                category.getCatalogName(),
                category.getCreated()
        );
    }
}
