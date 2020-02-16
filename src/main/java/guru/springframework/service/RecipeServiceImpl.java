package guru.springframework.service;

import guru.springframework.domain.Recipe;
import guru.springframework.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepo;

    public RecipeServiceImpl(RecipeRepository recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @Override
    public Set<Recipe> getRecipes(){
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepo.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
