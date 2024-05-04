package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dto.request.CreateCategoryRequest;
import ra.dto.response.CreateCategoryResponse;
import ra.dto.response.GetAllResponse;
import ra.mapper.CreateMapper;
import ra.mapper.GetAllMapper;
import ra.model.Category;
import ra.repository.CategoryRepository;
import ra.service.CategoryService;

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
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public boolean update(Category category) {
        Category old = findById(category.getCatalogId());
        if(old == null){
            throw new RuntimeException("Danh mục này không tồn tại!");
        }
        category.setCreated(old.getCreated());
        categoryRepository.save(category);
        return true;
    }

    @Override
    public void deleteById(int categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if(category == null){
            throw new RuntimeException("Danh mục này không tồn tại!");
        }
        categoryRepository.deleteById(categoryId);
    }
}
