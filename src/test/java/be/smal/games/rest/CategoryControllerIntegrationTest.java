package be.smal.games.rest;


import be.smal.games.services.CategoryService;
import be.smal.games.domain.Category;
import be.smal.games.domaindto.CategoryDTO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryControllerIntegrationTest {

    @Autowired
    CategoryController categoryController;

    @Autowired
    CategoryService categoryService;

    @Autowired
    EntityManager entityManager;

    //todo   trying to reset the auto increment jpa is applying as for my db not to have a huge gap in id numbers all of a sudden
/*
    @After
    public  void resetAutoIncrement() {
        int size = categoryService.findAll().size() + 1;
        Query query = entityManager.createNativeQuery("ALTER TABLE student AUTO_INCREMENT = " + size);
        query.executeUpdate();
    }
*/

    @Test
   public void addCategoryThenRemoveTest(){
        CategoryDTO categoryDTO = new CategoryDTO("testName");
        Category category = categoryController.saveCategory(categoryDTO);
        Assert.assertNotNull(category);
        Assert.assertEquals(category.getCategory_name(),categoryDTO.getCategory_name());
        Assert.assertNotNull(categoryService.findById(category.getId()));
        int countAfterAdding = categoryService.findAll().size();
        categoryController.remove(category.getId());
        int countAfterDeleting = categoryService.findAll().size();
        Assert.assertEquals(countAfterAdding,countAfterDeleting+1);
        try {
            categoryService.findById(category.getId());
            throw new RuntimeException("Test shouldn't reach this point");
        } catch (NullPointerException e){
            Assert.assertEquals("Category not found",e.getMessage());
        }

    }
}
