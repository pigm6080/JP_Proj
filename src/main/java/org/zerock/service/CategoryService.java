package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.CategoryVO;
import org.zerock.mapper.CategoryMapper;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    // 모든 카테고리 가져오기
    public List<CategoryVO> getAllCategories() {
        return categoryMapper.getAllCategories();
    }

    // 카테고리 ID로 카테고리 가져오기
    public CategoryVO getCategoryById(int category_id) {
        return categoryMapper.getCategoryById(category_id);
    }

    // 카테고리 추가
    public void insertCategory(CategoryVO category) {
        categoryMapper.insertCategory(category);
    }

    // 카테고리 수정
    public void updateCategory(CategoryVO category) {
        categoryMapper.updateCategory(category);
    }

    // 카테고리 삭제
    public void deleteCategory(int category_id) {
        categoryMapper.deleteCategory(category_id);
    }
}
