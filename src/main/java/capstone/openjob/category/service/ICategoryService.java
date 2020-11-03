package capstone.openjob.category.service;

import capstone.openjob.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {
    CategoryEntity createCategory(CategoryEntity categoryEntity);
    CategoryEntity updateCategory(CategoryEntity categoryEntity);
    List<CategoryEntity> getAllCategory();
    CategoryEntity getCategoryById(int id);
}
