package be.smal.games.services;

import be.smal.games.domain.Category;
import be.smal.games.domaindto.CategoryDTO;
import be.smal.games.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return  categories;
    }

    public Category save(CategoryDTO categoryDTO) {
        Category category = new ModelMapper().map(categoryDTO,Category.class);
        log.trace(String.format("saving category: %s to the database", category.toString()));
        return categoryRepository.save(category);
    }

    public void remove(int id) {
        log.trace(String.format("removing category with id: %d from the database", id));
        categoryRepository.delete(this.findById(id));
    }

    public Category findById(int id) {
       Optional<Category> category = categoryRepository.findById(id);
       if (category.isPresent()){
           return category.get();
       }
       throw new NullPointerException("Category not found");
    }
}
