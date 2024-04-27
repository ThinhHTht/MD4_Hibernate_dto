package ra.dto.repositoryImp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.dto.model.Category;
import ra.dto.repository.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class CategoryRepositoryImp implements CategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("select c from Category c", Category.class).getResultList();
    }

    @Override
    @Transactional
    public Category save(Category category) {
        try{
            entityManager.persist(category);
            return category;
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }

    @Override
    public Category findById(int categoryId) {
        return entityManager.createQuery("select c from Category c where c.catalogId = :id", Category.class).setParameter("id", categoryId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean update(Category category) {
        try{
            entityManager.merge(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }return false;
    }

    @Override
    @Transactional
    public boolean delete(int categoryId) {
        try{
            Category delCat = findById(categoryId);
            entityManager.remove(delCat);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }return false;
    }
}
