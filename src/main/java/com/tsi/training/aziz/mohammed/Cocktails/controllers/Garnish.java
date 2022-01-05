package com.tsi.training.aziz.mohammed.Cocktails.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Garnish {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idgarnish;

    private String name;
    private boolean food;

    public Garnish(){
    }

    public String toString(){
        return new Gson().toJson(this);
    }

    public Garnish(String name, boolean food) {
        this.name = name;
        this.food = food;
    }

/////////////////////////////////////////RELATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @JsonIgnore
    @ManyToMany(mappedBy = "garnish")
    Set<Instruction> instructions = new HashSet<>();
    public Set<Instruction> getInstructions() {
        return instructions;
    }

    //////////////////////////////////////GETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public String getName() {
        return this.name;
    }

    public boolean getFood() {
        return this.food;
    }

    public int getIdGarnish() {
        return this.idgarnish;
    }

    ////////////////////////////////////SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void setName(String name) {
        this.name = name;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

//    public void setIdGarnish(int idGarnish) {
//        this.idgarnish = idGarnish;
//    }


}
