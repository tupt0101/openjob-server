package capstone.openjob.category.service;

import capstone.openjob.dao.ICategoryRepository;
import capstone.openjob.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository ICategoryRepository;

    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return ICategoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity categoryEntity) {
        return ICategoryRepository.save(categoryEntity);
    }

    @Override
    public List<CategoryEntity> getAllCategory() {
        return ICategoryRepository.findAll();
    }

    @Override
    public CategoryEntity getCategoryById(int id) {
        if (ICategoryRepository.findById(id).isPresent()) {
            return ICategoryRepository.findById(id).get();
        } else return null;
    }
}
