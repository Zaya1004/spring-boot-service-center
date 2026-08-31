package mn.icode.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mn.icode.entity.Category;
import mn.icode.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	private final CategoryService categoryService;
	
    CategoryController(CategoryService categoryService){
    	this.categoryService = categoryService;
    }
    
    @GetMapping
    public List<Category> findAllCategories(){
    	return categoryService.findAllCategories();
    }
    
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category category) {
    	return categoryService.createCategory(category);
    }
    
    @GetMapping("{id}")
    public Category findById(@PathVariable Long id) {
    	return categoryService.findCategoryById(id);
    }
    
    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
    	return categoryService.updateCategory(id, category);
    }
    
    public void delete(@PathVariable Long id) {
    	categoryService.deleteCategory(id);
    }
}
