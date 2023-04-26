package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tacos.data.IngredientRepository;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo) {
		return args -> {
			repo.deleteAll(); // TODO: Quick hack to avoid tests from stepping on each other with constraint violations
			repo.save(new Ingredient("FLT", "Flour Tortilla", Ingredient.Type.WRAP));
			repo.save(new Ingredient("COT", "Corn Tortilla", Ingredient.Type.WRAP));
			repo.save(new Ingredient("RBF", "Ground Beef", Ingredient.Type.PROTEIN));
			repo.save(new Ingredient("CAN", "Carnivals", Ingredient.Type.PROTEIN));
			repo.save(new Ingredient("TM TO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
			repo.save(new Ingredient("LET", "Lettuce", Ingredient.Type.VEGGIES));
			repo.save(new Ingredient("SHED", "Cheddar", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("SALSA", "Salsa", Ingredient.Type.SAUCE));
			repo.save(new Ingredient("SRC", "Sour Cream", Ingredient.Type.SAUCE));
		};
	}

}
