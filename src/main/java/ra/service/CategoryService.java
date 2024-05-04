package ra.service;

import ra.dto.request.CreateCategoryRequest;
import ra.dto.response.CreateCategoryResponse;
import ra.dto.response.GetAllResponse;
import ra.model.Category;

import java.util.List;

public interface CategoryService {
    List<GetAllResponse> findAll();

    CreateCategoryResponse save(CreateCategoryRequest categoryRequest);

    Category findById(int categoryId);

    boolean update(Category category);

    void deleteById(int categoryId);
}
