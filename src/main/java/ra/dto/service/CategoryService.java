package ra.dto.service;

import ra.dto.dto.request.CreateCategoryRequest;
import ra.dto.dto.response.CreateCategoryResponse;
import ra.dto.dto.response.GetAllResponse;
import ra.dto.model.Category;

import java.util.List;

public interface CategoryService {
    List<GetAllResponse> findAll();

    CreateCategoryResponse save(CreateCategoryRequest categoryRequest);

    Category findById(int categoryId);

    boolean update(Category category);

    boolean delete(int categoryId);
}
