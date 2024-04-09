package org.zerock.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.CategoryVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CategoryMapperTest {
	
	@Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void testGetAllCategories() {
        List<CategoryVO> categories = categoryMapper.getAllCategories();
        assertNotNull(categories);
        // 여기에 추가적인 검증을 수행할 수 있습니다.
    }

    @Test
    public void testGetCategoryById() {
        int categoryId = 1; // 존재하는 카테고리 ID로 설정
        CategoryVO category = categoryMapper.getCategoryById(categoryId);
        assertNotNull(category);
        assertEquals(categoryId, category.getCategory_id());
        // 여기에 추가적인 검증을 수행할 수 있습니다.
    }

    @Test
    public void testInsertCategory() {
        CategoryVO category = new CategoryVO();
        // 새로운 카테고리 객체를 생성하고 필요한 필드를 설정합니다.
        // 여기에 추가적인 설정을 할 수 있습니다.
        categoryMapper.insertCategory(category);

        // 삽입 후에 해당 카테고리가 데이터베이스에 존재하는지 확인하는 검증 코드를 작성할 수 있습니다.
    }

    @Test
    public void testUpdateCategory() {
        CategoryVO category = new CategoryVO();
        // 업데이트할 카테고리 객체를 생성하고 필요한 필드를 설정합니다.
        // 여기에 추가적인 설정을 할 수 있습니다.
        categoryMapper.updateCategory(category);

        // 업데이트 후에 해당 카테고리 정보가 올바르게 수정되었는지 확인하는 검증 코드를 작성할 수 있습니다.
    }

    @Test
    public void testDeleteCategory() {
        int categoryId = 1; // 삭제할 카테고리 ID로 설정
        categoryMapper.deleteCategory(categoryId);

        // 삭제 후에 해당 카테고리가 데이터베이스에 존재하지 않는지 확인하는 검증 코드를 작성할 수 있습니다.
    }
}
