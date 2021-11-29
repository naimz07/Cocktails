package com.tsi.training.aziz.mohammed.Cocktails;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Instructions {

    private final List<Ingredients> instructionsIngredients = new ArrayList<>();
    private final List<Equipment> instructionsEquipments = new ArrayList<>();
    private final List<Garnish> instructionsGarnish = new ArrayList<>();
    private final List<Glass> instructionsGlass = new ArrayList<>();


    public Instructions(){
        this.instructionsIngredients.add(new Ingredients( "RUM", 5, "This is rum"));
        this.instructionsIngredients.add(new Ingredients( "VODKA", 10, "This is vodka"));
        this.instructionsIngredients.add(new Ingredients( "ICE", 0, "This is ice"));
        this.instructionsIngredients.add(new Ingredients( "CHAMPAGNE", 7, "This is champagne"));
        this.instructionsIngredients.add(new Ingredients( "WHISKEY", 8, "This is whiskey"));


        this.instructionsEquipments.add(new Equipment( "SHAKER", false ));
        this.instructionsEquipments.add(new Equipment( "BLENDER", true ));
        this.instructionsEquipments.add(new Equipment( "STRAINER", false ));
        this.instructionsEquipments.add(new Equipment( "BOTTLE OPENER", false ));


        this.instructionsGarnish.add(new Garnish("UMBRELLA", false ));
        this.instructionsGarnish.add(new Garnish("LEMON", true ));
        this.instructionsGarnish.add(new Garnish("LIME", true ));
        this.instructionsGarnish.add(new Garnish("FLOWER", false ));


        this.instructionsGlass.add(new Glass("MARTINI", 300 ));
        this.instructionsGlass.add(new Glass("MARGARITA", 360 ));
        this.instructionsGlass.add(new Glass("CHAMPAGNE", 200 ));
        this.instructionsGlass.add(new Glass("PINA_COLADA", 450 ));
        this.instructionsGlass.add(new Glass("HAWAII_TIKI", 450 ));

    }



    public List<Ingredients> getInstructionsIngredients(){
        return this.instructionsIngredients;
    }

    public String toString(){
        String json = new Gson().toJson(instructionsIngredients);
        return json;
    }

    public List<Equipment> getInstructionsEquipmentsEquipment(){
        return this.instructionsEquipments;
    }
    public String equipmentStrings(){
        String json = new Gson().toJson(instructionsEquipments);
        return json;
    }

    public List<Garnish> getInstructionsGarnish(){
        return this.instructionsGarnish;
    }
    public String garnishStrings(){
        String json = new Gson().toJson(instructionsGarnish);
        return json;
    }

}
