package com.tsi.training.aziz.mohammed.Cocktails;

import com.tsi.training.aziz.mohammed.Cocktails.controllers.Glass;
import com.tsi.training.aziz.mohammed.Cocktails.controllers.Equipment;
import com.tsi.training.aziz.mohammed.Cocktails.controllers.Garnish;
import com.tsi.training.aziz.mohammed.Cocktails.controllers.Ingredient;
import com.tsi.training.aziz.mohammed.Cocktails.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/cocktails")
@CrossOrigin
public class main {

	//////////////////////////////////////////////REPOSITORIES\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	@Autowired
	private GlassRepository glassRepository;
	@Autowired
	private GarnishRepository garnishRepository;
	@Autowired
	private IngredientsRepository ingredientsRepository;
	@Autowired
	private EquipmentRepository equipmentRepository;
	@Autowired
	private Cocktail_instructionsRepository cocktail_instructionsRepository;


	public main(GlassRepository glassRepository){
		this.glassRepository = glassRepository;
	}

	public main(GarnishRepository garnishRepository){
		this.garnishRepository = garnishRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(main.class, args);
	}


	//////////////////////////////////////////////GLASSES\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	@GetMapping(value = "/glass/getAll")
	public @ResponseBody
	Iterable<Glass> getAllGlasses() {
		return glassRepository.findAll();
	}
	@GetMapping(value = "/glass/getGlass")
	@ResponseBody
	public Optional<Glass> getGlass(@RequestParam int idglass){
		return glassRepository.findById(idglass);
	}
	@PostMapping(value = "/glass/addGlass")
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

	@PutMapping(value = "/glass/updateGlass")
	public @ResponseBody String updatedGlass (@RequestBody Glass glass)
	{
		glassRepository.save(glass);
		return "Glass Updated";
	}


	/////////////////////////////////////////////GARNISHES\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
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
	@PutMapping(value = "/garnish/updateGarnish")
	public @ResponseBody String updatedGarnish (@RequestBody Garnish garnish){
		garnishRepository.save(garnish);
		return "Garnish Updated";
	}


	////////////////////////////////////////////INGREDIENTS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	@GetMapping(value = "/ingredients/getAll")
	public @ResponseBody
	Iterable<Ingredient> getAllIngredients(){
		return ingredientsRepository.findAll();
	}
	@GetMapping(value = "/ingredients/getIngredient")
	public @ResponseBody
	Optional<Ingredient> getIngredients(@RequestParam int idingredient){
		return ingredientsRepository.findById(idingredient);
	}
	@PostMapping(value = "/ingredients/addIngredients")
	public @ResponseBody String addAGarnish(@RequestParam String name,
			@RequestParam int alcohol_Level, @RequestParam String description){
		Ingredient savedIngredients = new Ingredient(name, alcohol_Level, description);
		ingredientsRepository.save(savedIngredients);
		return "New Garnish Saved";
	}
	@DeleteMapping(value = "/ingredients/deleteIngredients")
	public @ResponseBody String deleteIngredients(@RequestParam int idingredient){
		ingredientsRepository.deleteById(idingredient);
		return "Ingredient Deleted";
	}
	@PutMapping(value = "/ingredients/updateIngredient")
	public @ResponseBody String updatedIngredient (@RequestBody Ingredient ingredient){
		ingredientsRepository.save(ingredient);
		return "Ingredient Updated";
	}


	/////////////////////////////////////////////EQUIPMENT\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
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
	@PutMapping(value = "/equipment/updateEquipment")
	public @ResponseBody String updatedEquipment (@RequestBody Equipment equipment){
		equipmentRepository.save(equipment);
		return "Equipment Updated";
	}


	///////////////////////////////////COCKTAIL INSTRUCTIONS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	@GetMapping(value = "/cocktailInstructions/getAll")
	public @ResponseBody
	Iterable<cocktail_instruction> getAllCocktailInstructions(){
		return cocktail_instructionsRepository.findAll();
	}




}


