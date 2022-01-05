package com.tsi.training.aziz.mohammed.Cocktails.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idingredient;


    private String name;
    private int alcohol_Level;
    private String description;

    public Ingredient(){
    }
    public String toString(){
        return new Gson().toJson(this);
    }
    public Ingredient(String name, int alcohol_Level, String description){
        this.name = name;
        this.alcohol_Level = alcohol_Level;
        this.description = description;
    }

    ////////////////////////////////////RELATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @JsonIgnore
    @ManyToMany(mappedBy = "ingredients")
    Set<Instruction> instructions = new HashSet<>();

    public Set<Instruction> getInstructions() {
        return instructions;
    }



    //////////////////////////////////////GETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public int getAlcLevel(){
        return this.alcohol_Level;
    }

    public int getIdingredient() {
        return this.idingredient;
    }

    //////////////////////////////////////SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAlcLevel(int alcohol_Level) {
        this.alcohol_Level = alcohol_Level;
    }

    //public void setIdingredient(int idingredient) {
    //    this.idingredient = idingredient;
    //}


}
