package org.zerock.mapper;

import org.zerock.domain.*;

import java.util.List;

public interface CategoryMapper {

    List<CategoryVO> getAllCategories();

    CategoryVO getCategoryById(int category_id);

    void insertCategory(CategoryVO category);

    void updateCategory(CategoryVO category);

    void deleteCategory(int category_id);
}
