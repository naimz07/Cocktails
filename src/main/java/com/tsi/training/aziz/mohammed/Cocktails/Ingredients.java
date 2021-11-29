package com.tsi.training.aziz.mohammed.Cocktails;

import com.google.gson.Gson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idingredient;


    private String name;
    private int alcLevel;
    private String description;


    public Ingredients(String name, int alcLevel, String description){
        this.name = name;
        this.alcLevel = alcLevel;
        this.description = description;
    }

    public String toString(){
        return new Gson().toJson(this);
    }

    public Ingredients(){
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription(){
        return this.description;
    }

    public void setDescription() {
        this.description = description;
    }
    public int getAlcLevel(){
        return this.alcLevel;
    }

    public void setAlcLevel() {
        this.alcLevel = alcLevel;
    }

    public int getIdingredient() {
        return this.idingredient;
    }

    public void setIdingredient(int idingredient) {
        this.idingredient = idingredient;
    }


}
