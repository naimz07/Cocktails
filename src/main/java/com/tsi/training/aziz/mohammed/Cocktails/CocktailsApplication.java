package com.tsi.training.aziz.mohammed.Cocktails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/cocktails")
public class CocktailsApplication {

	@Autowired
	private GlassRepository glassRepository;
	@Autowired
	private GarnishRepository garnishRepository;
	@Autowired
	private IngredientsRepository ingredientsRepository;
	@Autowired
	private EquipmentRepository equipmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(CocktailsApplication.class, args);
	}

	@GetMapping(value = "/glass/getAll")
	public @ResponseBody
	Iterable<Glass> getAllGlasses() {
		return glassRepository.findAll();
	}
	@GetMapping(value = "/glass/getGlass")
	public @ResponseBody
	Optional<Glass> getGlass(@RequestParam int idglass){
		return glassRepository.findById(idglass);
	}
	@PostMapping(value = "glass/addGlass")
	public @ResponseBody String addAGLass(@RequestParam String name,
			@RequestParam int volume) {
		Glass savedGlass = new Glass(name,volume);
		glassRepository.save(savedGlass);
		return "New Glass Saved";
	}
	@DeleteMapping(value = "/glass/deleteGlass")
	public @ResponseBody String deleteGlass(@RequestParam int idglass){
		glassRepository.deleteById(idglass);
		return "Glass Deleted";
	}
	@PutMapping(value = "/updateGlass")
	public @ResponseBody String updateGlass(RequestParam Glass glass){
		glassRepository.save(glass);
		return "Glass Updated";
	}


	@GetMapping(value = "/garnish/getAll")
	public @ResponseBody
	Iterable<Garnish> getAllGarnishes(){
		return garnishRepository.findAll();
	}
	@GetMapping(value = "/garnish/getGarnish")
	public @ResponseBody
	Optional<Garnish> getGarnish(@RequestParam int idgarnish){
		return garnishRepository.findById(idgarnish);
	}
	@PostMapping(value = "/garnish/addGarnish")
	public @ResponseBody String addAGarnish(@RequestParam String name,
			@RequestParam boolean food){
		Garnish savedGarnish = new Garnish(name, food);
		garnishRepository.save(savedGarnish);
		return "New Garnish Saved";
	}
	@DeleteMapping(value = "/garnish/deleteGarnish")
	public @ResponseBody String deleteGarnish(@RequestParam int idgarnish){
		glassRepository.deleteById(idgarnish);
		return "Garnish Deleted";
	}


	@GetMapping(value = "/ingredients/getAll")
	public @ResponseBody
	Iterable<Ingredients> getAllIngredients(){
		return ingredientsRepository.findAll();
	}
	@GetMapping(value = "/ingredients/getIngredient")
	public @ResponseBody
	Optional<Ingredients> getIngredients(@RequestParam int idingredient){
		return ingredientsRepository.findById(idingredient);
	}
	@PostMapping(value = "/ingredients/addIngredients")
	public @ResponseBody String addAGarnish(@RequestParam String name,
			@RequestParam int alcLevel, @RequestParam String description){
		Ingredients savedIngredients = new Ingredients(name, alcLevel, description);
		ingredientsRepository.save(savedIngredients);
		return "New Garnish Saved";
	}
	@DeleteMapping(value = "/ingredients/deleteIngredients")
	public @ResponseBody String deleteIngredients(@RequestParam int idingredient){
		ingredientsRepository.deleteById(idingredient);
		return "Ingredient Deleted";
	}


	@GetMapping(value = "/equipment/getAll")
	public @ResponseBody
	Iterable<Equipment> getAllEquipment(){
		return equipmentRepository.findAll();
	}
	@GetMapping(value = "/equipment/getEquipment")
	public @ResponseBody
	Optional<Equipment> getEquipment(@RequestParam int idequipment){
		return equipmentRepository.findById(idequipment);
	}
	@PostMapping(value = "/equipment/addEquipment")
	public @ResponseBody String addEquipment(@RequestParam String name,
			@RequestParam boolean needsPower){
		Equipment savedEquipment = new Equipment(name, needsPower);
		equipmentRepository.save(savedEquipment);
		return "New Equipment Saved";
	}
	@DeleteMapping(value = "/equipment/deleteEquipment")
	public @ResponseBody String deleteEquipment(@RequestParam int idequipment){
	equipmentRepository.deleteById(idequipment);
	return "Equipment Deleted";
	}





}


