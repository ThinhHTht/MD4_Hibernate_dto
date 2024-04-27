package ra.dto.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dto.dto.request.CreateCategoryRequest;
import ra.dto.dto.response.CreateCategoryResponse;
import ra.dto.dto.response.GetAllResponse;
import ra.dto.mapper.CreateMapper;
import ra.dto.mapper.GetAllMapper;
import ra.dto.model.Category;
import ra.dto.repository.CategoryRepository;
import ra.dto.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorySericeImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GetAllMapper getAllMapper;
    @Autowired
    private CreateMapper createMapper;
    @Override
    public List<GetAllResponse> findAll() {
        List<Category> listCategories = categoryRepository.findAll();
        return listCategories.stream().map(category -> getAllMapper.mapperEntityToResponse(category)).collect(Collectors.toList());
    }

    @Override
    public CreateCategoryResponse save(CreateCategoryRequest categoryRequest) {
        Category newCategory = createMapper.mapperRequestToEntity(categoryRequest);
        Category addedCat = categoryRepository.save(newCategory);
        return createMapper.mapperEntityToResponse(addedCat);
    }

    @Override
    public Category findById(int categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public boolean update(Category category) {
        Category old = findById(category.getCatalogId());
        category.setCreated(old.getCreated());
        return categoryRepository.update(category);
    }

    @Override
    public boolean delete(int categoryId) {
        return categoryRepository.delete(categoryId);
    }
}
