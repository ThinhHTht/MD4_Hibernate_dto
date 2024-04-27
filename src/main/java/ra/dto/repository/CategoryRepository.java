package ra.dto.repository;

import ra.dto.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    Category save(Category category);

    Category findById(int categoryId);

    boolean update(Category category);

    boolean delete(int categoryId);
}
