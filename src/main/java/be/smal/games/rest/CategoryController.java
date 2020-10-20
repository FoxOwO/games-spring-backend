package be.smal.games.rest;

import be.smal.games.services.CategoryService;
import be.smal.games.domain.Category;
import be.smal.games.domaindto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping
    public List<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getGame(@PathVariable Integer id){
        return categoryService.findById(id);
    }

    @PostMapping(path = "")
    public Category saveCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.save(categoryDTO);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        System.out.println("trying to delete category with id: "+id);
        categoryService.remove(id);
    }
}
