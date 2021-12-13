package com.tsi.training.aziz.mohammed.Cocktails.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tsi.training.aziz.mohammed.Cocktails.cocktail_instruction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idinstruction;


//////////////////////////////////////////////////INGREDIENTS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @ManyToMany
    @JoinTable(
            name="instruction_ingredient",
            joinColumns = @JoinColumn(name = "idinstruction"),
            inverseJoinColumns = @JoinColumn(name = "idingredient"))
    private Set<Ingredient> ingredients = new HashSet<>();


//////////////////////////////////////////////////GARNISH\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @ManyToMany
    @JoinTable(
            name="instruction_garnish",
            joinColumns = @JoinColumn(name = "idinstruction"),
            inverseJoinColumns = @JoinColumn(name = "idgarnish")
    )
    private Set<Garnish> garnish = new HashSet<>();


///////////////////////////////////////////////////GLASS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @ManyToMany
    @JoinTable(
            name = "instruction_glass",
            joinColumns = @JoinColumn(name = "idinstruction"),
            inverseJoinColumns = @JoinColumn(name = "idglass")
    )
    private Set<Glass> glass = new HashSet<>();


///////////////////////////////////////////////EQUIPMENT\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @ManyToMany
    @JoinTable(
            name = "instruction_equipment",
            joinColumns = @JoinColumn(name = "idinstruction"),
            inverseJoinColumns = @JoinColumn(name = "idequipment")
    )
    private Set<Equipment> equipment = new HashSet<>();


///////////////////////////////////////////////COCKTAIL\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @JsonIgnore
    @OneToMany(mappedBy = "instruction")
    private Set<cocktail_instruction> cocktailset = new HashSet<cocktail_instruction>();

    public Set<cocktail_instruction> getCocktailset() {
        return cocktailset;
    }

    public void setCocktailset(Set<cocktail_instruction> cocktailset) {
        this.cocktailset = cocktailset;
    }


//    @JsonIgnore
//    @ManyToMany(mappedBy = "instruction")
//    Set<Cocktail> cocktails = new HashSet<>();
//    public Set<Cocktail> getCocktails() {
//        return cocktails;
//    }





//
//
//    private int idglass;
//    private int idgarnish;
//    private int idequipment;
//    private String description;
//    private int step_number;
//    private String name;
//    private int glass_idglass;
//
//
//    public Instruction(String description, int step_number, String name, int glass_idglass){
//        this.description = description;
//        this.step_number = step_number;
//        this.name = name;
//        this.glass_idglass = glass_idglass;
//    }
//
//    public Instruction(){}
//
//    public String toString(){
//        return new Gson().toJson(this);
//    }


}
