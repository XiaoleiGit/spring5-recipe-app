package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repository.CategoryRepository;
import guru.springframework.repository.UnitOfMeasureRepository;
import guru.springframework.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

//    private CategoryRepository categoryRepository;
//    private UnitOfMeasureRepository unitOfMeasureRepository;
//
//    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
//        this.categoryRepository = categoryRepository;
//        this.unitOfMeasureRepository = unitOfMeasureRepository;
//    }

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
//        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
//        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
//        System.out.println("Category ID is:" + categoryOptional.get().getId());

        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
